package com.htmlTags.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htmlTags.model.Urls;

public interface UrlsRepository extends JpaRepository<Urls, Long> {
    // Metodo criado para procurar pela URL 
    Urls findByUrl(String url); 
}
