package com.nuti.nuti.controller;

import com.nuti.nuti.model.Tags;
import com.nuti.nuti.model.Urls;
import com.nuti.nuti.repository.TagsRepository;
import com.nuti.nuti.repository.UrlsRepository;
import com.nuti.nuti.service.HtmlParserService;
import com.nuti.nuti.service.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

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
        List<Tags> tagList = tagsRepository.findAll();
        
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

        return "result"; // Redireciona para a página de resultado se a URL passar
    }
}
