package com.nuti.nuti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nuti.nuti.model.UrlInfo;

public interface UrlInfoRepository extends JpaRepository<UrlInfo, Long> { UrlInfo findByUrl(String url); }
