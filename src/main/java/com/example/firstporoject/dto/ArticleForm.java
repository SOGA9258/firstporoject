package com.example.firstporoject.dto;

import com.example.firstporoject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private  String title;
    private String content;


    public Article toEntity() {
        return new Article(null,title,content);
    }
}
