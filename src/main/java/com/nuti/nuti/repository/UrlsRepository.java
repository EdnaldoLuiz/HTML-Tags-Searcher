package com.nuti.nuti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nuti.nuti.model.Urls;

public interface UrlsRepository extends JpaRepository<Urls, Long> { Urls findByUrl(String url); }
