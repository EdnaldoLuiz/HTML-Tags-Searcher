package com.nuti.nuti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuti.nuti.repository.TagsRepository;

@Service
public class TagsService {

    @Autowired
    private TagsRepository tagCountRepository;

    
}
