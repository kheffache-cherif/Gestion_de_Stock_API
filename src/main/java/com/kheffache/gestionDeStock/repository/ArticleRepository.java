package com.kheffache.gestionDeStock.repository;

import com.kheffache.gestionDeStock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findArticleByCodeArticle(String CodeArticle);
    List<Article> findAllByCategoryId(Integer idCategory);



}
