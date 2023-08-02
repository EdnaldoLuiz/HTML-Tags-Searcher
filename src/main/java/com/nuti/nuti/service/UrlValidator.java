package com.nuti.nuti.service;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuti.nuti.model.Urls;
import com.nuti.nuti.repository.UrlsRepository;

import java.io.IOException;
import java.net.MalformedURLException;

@Service
public class UrlValidator {

    @Autowired
    private UrlsRepository urlRepository;

    public boolean validarUrl(String url) {
        try {
            Jsoup.connect(url).get();
            return true; 
        } catch (IOException e) {
            return false;
        }
    }

    public Urls validarESalvar(String url) throws MalformedURLException {
        if (!validarUrl(url)) {
            throw new MalformedURLException("URL inválida: " + url);
        }

        String urlVerificada = url.trim();
        Urls urlInfo = urlRepository.findByUrl(urlVerificada);
        if (urlInfo == null) {
            urlInfo = new Urls(urlVerificada);
            urlRepository.save(urlInfo);
        }

        return urlInfo;
    }
}
