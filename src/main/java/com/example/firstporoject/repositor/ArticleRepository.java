package com.example.firstporoject.repositor;

import com.example.firstporoject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {
}
