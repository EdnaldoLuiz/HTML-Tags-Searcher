package com.htmlTags.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "Tags")
@Table(name = "tb_tags")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private Long quantidade;

    @ManyToOne
    private Urls urlInfo;

    public Tags(String tag, long qtd, Urls url) {
        this.tag = tag;
        this.quantidade =  qtd;
        this.urlInfo = url;
    }
}
