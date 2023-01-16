package com.example.firstporoject.controller;

import com.example.firstporoject.dto.ArticleForm;
import com.example.firstporoject.entity.Article;
import com.example.firstporoject.repositor.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticleController {


    @Autowired
    private ArticleRepository articleRepository;


    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());

         Article article= form.toEntity();
        log.info(article.toString());
         Article saved= articleRepository.save(article);

        log.info(saved.toString());
        return "";
    }
}
