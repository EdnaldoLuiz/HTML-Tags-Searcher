package com.nuti.nuti.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nuti.nuti.model.TagInfo;
import com.nuti.nuti.model.UrlInfo;
import com.nuti.nuti.repository.TagInfoRepository;
import com.nuti.nuti.repository.UrlInfoRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class TagInfoController {

    private boolean isValidURL(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            // Adicione aqui outras verificações se necessário.
            return true; // Se a URL é válida e a página foi redirecionada para a página de resultado.
        } catch (IOException e) {
            return false; // Se ocorreu algum erro ou a página não foi redirecionada corretamente.
        }
    }

    @Autowired
    private UrlInfoRepository urlInfoRepository;

    @Autowired
    private TagInfoRepository tagInfoRepository;

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/")
    public String processUrl(@RequestParam("url") String url, Model model) throws IOException {
        if (url == null || url.trim().isEmpty()) {
            return "error"; 
        }
    
        if (isValidURL(url.trim())) {
            UrlInfo urlInfo = urlInfoRepository.findByUrl(url.trim());
            if (urlInfo == null) {
                urlInfo = new UrlInfo(url.trim());
                urlInfoRepository.save(urlInfo);
            }
    
            Document document = Jsoup.connect(url).get();
            List<String> tags = new ArrayList<>();
            for (Element e : document.getAllElements()) {
                String tagName = e.tagName().toLowerCase();
                if (!tagName.equals("#root")) {
                    tags.add(tagName);
                }
            }
            
            List<TagInfo> tagInfoList = new ArrayList<>();
            for (String tag : new HashSet<>(tags)) {
                long count = tags.stream().filter(t -> t.equals(tag)).count();
                tagInfoList.add(new TagInfo(tag, count, urlInfo));
            }
    
            if (!tagInfoList.isEmpty()) {
                tagInfoRepository.saveAll(tagInfoList);
            }
    
            model.addAttribute("tagInfoList", tagInfoList);
            model.addAttribute("url", url.trim());
            return "result"; 
        } else {
            return "error"; // Redireciona para a página de erro se a URL não é válida.
        }
    }
}
