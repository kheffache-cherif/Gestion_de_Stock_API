package com.kheffache.gestionDeStock.controller.api;

import com.kheffache.gestionDeStock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kheffache.gestionDeStock.UTILS.Constants.APP_ROOT;


public interface ArticleAPI {
        // contoller, on consomme un JSON ET ON PRODUIT UN JSON.
    @PostMapping(value = APP_ROOT +"/article/creat",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

    ArticleDto save(@RequestBody ArticleDto dto);  // POUR FAIRE LA TRANSFORMATION DE JSON VERS OBJET DTO

    @GetMapping(value = APP_ROOT +"/article/idArticle",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);  // UN PATH VARIABLE

    @GetMapping(value = APP_ROOT +"/article/codeArticle",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String CodeArticle);

    @GetMapping(value = APP_ROOT +"/article/All",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT +"/article/delete/{idArticle}")
    void delete(@PathVariable("idArticle")Integer id);
}
