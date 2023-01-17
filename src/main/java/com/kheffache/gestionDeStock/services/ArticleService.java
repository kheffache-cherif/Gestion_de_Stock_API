package com.kheffache.gestionDeStock.services;

import com.kheffache.gestionDeStock.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto dto);
    ArticleDto findById(Integer id);
    ArticleDto findByCodeArticle(String CodeArticle);
    List<ArticleDto> findAll();


    void delete(Integer id);
}
