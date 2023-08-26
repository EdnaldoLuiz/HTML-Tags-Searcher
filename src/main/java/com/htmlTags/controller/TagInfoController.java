package com.htmlTags.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.htmlTags.repository.UrlsRepository;
import com.htmlTags.model.Tags;
import com.htmlTags.model.Urls;
import com.htmlTags.repository.TagsRepository;
import com.htmlTags.service.HtmlParserService;
import com.htmlTags.service.UrlValidator;

@Controller
public class TagInfoController {

    @Autowired
    private UrlsRepository urlsRepository;

    @Autowired
    private TagsRepository tagsRepository;

    @Autowired
    private UrlValidator validador;

    @Autowired
    private HtmlParserService parseador;

    @GetMapping("/")
    public String exibirFormularioETabelas(Model model) {
        List<Urls> urlList = urlsRepository.findAll();
        List<Tags> tagList = tagsRepository.findAll(Sort.by(Sort.Direction.DESC, "urlInfo.id"));
        
        model.addAttribute("urlList", urlList);
        model.addAttribute("tagList", tagList);
        
        return "index";
    }

    @PostMapping("/")
    public String processarUrl(@RequestParam("url") String url, Model model) throws IOException {
        Urls urlInfo = validador.validarESalvar(url);
        List<Tags> tagList = parseador.buscarESalvar(url, urlInfo);

        model.addAttribute("tagInfoList", tagList);
        model.addAttribute("url", url.trim());

        return "result";
    }
}
