package com.nuti.nuti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nuti.nuti.model.TagInfo;

public interface TagInfoRepository extends JpaRepository<TagInfo, Long> {
    
}
