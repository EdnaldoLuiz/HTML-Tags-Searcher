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

    @Autowired
    private UrlInfoRepository urlInfoRepository;

    @Autowired
    private TagInfoRepository tagInfoRepository;

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/")
    public String processUrl(@RequestParam("url") String url, Model model) {
        if (url == null || url.trim().isEmpty()) {
            return "error"; 
        }
    
        try {
            UrlInfo urlInfo = urlInfoRepository.findByUrl(url.trim());
            if (urlInfo == null) {
                urlInfo = new UrlInfo(url.trim());
                urlInfoRepository.save(urlInfo);
            }
    
            Document document = Jsoup.connect(url).get();
            List<String> tags = new ArrayList<>();
            for (Element e : document.getAllElements()) {
                tags.add(e.tagName().toLowerCase());
            }
            
            List<TagInfo> tagInfoList = new ArrayList<>();
            for (String tag : new HashSet<>(tags)) {
                long count = tags.stream().filter(t -> t.equals(tag)).count();
                tagInfoList.add(new TagInfo(tag, count, urlInfo));
            }
    
            tagInfoRepository.saveAll(tagInfoList);
    
            model.addAttribute("tagInfoList", tagInfoList);
            return "result"; 
        } catch (IOException e) {
            e.printStackTrace();
            return "error"; 
        }
    }
    

}
