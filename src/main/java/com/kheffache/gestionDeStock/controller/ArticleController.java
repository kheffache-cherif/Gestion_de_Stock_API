package com.kheffache.gestionDeStock.controller;

import com.kheffache.gestionDeStock.controller.api.ArticleAPI;
import com.kheffache.gestionDeStock.dto.ArticleDto;
import com.kheffache.gestionDeStock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ArticleController implements ArticleAPI {

    private  ArticleService articleService;

@Autowired  // permet l'injection automatique  creation d'instance
// injection feald injection au niveau de la variable
// injection par constructeur
//getter injection
    public ArticleController( ArticleService articleService){
            this.articleService = articleService;
    }
    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String CodeArticle) {
        return articleService.findByCodeArticle(CodeArticle);

    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
    articleService.delete(id);

    }
}
