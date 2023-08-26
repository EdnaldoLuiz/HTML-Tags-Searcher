package com.htmlTags.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htmlTags.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long> {}
