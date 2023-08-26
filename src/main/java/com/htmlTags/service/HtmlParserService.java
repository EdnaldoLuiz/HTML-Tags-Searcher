package com.htmlTags.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htmlTags.model.Tags;
import com.htmlTags.model.Urls;
import com.htmlTags.repository.TagsRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HtmlParserService {

    @Autowired
    private TagsRepository tagInfoRepository;

    public List<Tags> buscarESalvar(String url, Urls urlInfo) throws IOException {
        // Pega a URL passada no html do formulario
        Document documento = Jsoup.connect(url).get();

        // Pega todas as tags da url passada, menos essa #root que estava vindo mas filtrei
        List<String> tags = documento.getAllElements()
                .stream()
                .map(e -> e.tagName().toLowerCase())
                .filter(tag -> !tag.equals("#root"))
                .collect(Collectors.toList());

        // Calcula a quantidade de cada tag
        Map<String, Long> quantidadeTags = tags
                .stream()
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));

        // Mapeia para um objeto de TagInfo, juntando as Tags e as Quantidades
        List<Tags> tagsList = quantidadeTags
                .entrySet()
                .stream()
                .map(entry -> new Tags(entry.getKey(), entry.getValue(), urlInfo))
                .collect(Collectors.toList());

        // Se for diferente de vazio, salve no banco de dados
        if (!tagsList.isEmpty()) {
            tagInfoRepository.saveAll(tagsList);
        }

        return tagsList;
    }
}
