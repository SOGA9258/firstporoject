package com.example.firstporoject.controller;

import com.example.firstporoject.dto.ArticleForm;
import com.example.firstporoject.entity.Article;
import com.example.firstporoject.repositor.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.rmi.MarshalledObject;
import java.util.List;
import java.util.Optional;

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
        return "redirect:/articles/" + saved.getId();
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id ,Model model){
        log.info("id="+id);

        //해당 id값 없으면  null반환
         Article articleEntity= articleRepository.findById(id).orElse(null);

         model.addAttribute("article",articleEntity);

        return "articles/show";
    }
    @GetMapping("/articles")
    public String index(Model model) {
       List<Article> articleEntityList = articleRepository.findAll();

       model.addAttribute("articleList",articleEntityList);

        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable  Long id,Model model) {

        Article articleEntity = articleRepository.findById(id).orElse(null);

        model.addAttribute("article",articleEntity);

        return "articles/edit";

    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form ) {
        log.info(form.toString());

        Article articleEntity = form.toEntity();

        Article target =articleRepository.findById(articleEntity.getId()).orElse(null);

        if (target != null) {
            articleRepository.save(articleEntity);
        }
        return "redirect:/articles/"+articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable long id) {

        Article target= articleRepository.findById(id).orElse(null);

        if(target != null) {
            articleRepository.delete(target);
        }

        return "redirect:/articles";
    }
}
