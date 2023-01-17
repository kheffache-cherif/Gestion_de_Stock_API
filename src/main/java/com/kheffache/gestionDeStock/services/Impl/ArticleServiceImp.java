package com.kheffache.gestionDeStock.services.Impl;

import com.kheffache.gestionDeStock.Exceptions.EntityNotFondException;
import com.kheffache.gestionDeStock.Exceptions.ErrorCodes;
import com.kheffache.gestionDeStock.Exceptions.InvalidEntityException;
import com.kheffache.gestionDeStock.dto.ArticleDto;
import com.kheffache.gestionDeStock.model.Article;
import com.kheffache.gestionDeStock.repository.ArticleRepository;
import com.kheffache.gestionDeStock.services.ArticleService;
import com.kheffache.gestionDeStock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImp implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired  // injection par constructeur.
    public ArticleServiceImp(ArticleRepository articleRepository){
        this.articleRepository=articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        // si l'article n'est pas valide ont leve une exception
        List<String> errors = ArticleValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}",dto);
            throw new InvalidEntityException("Article is not valid", ErrorCodes.ARTICLE_NOT_VALID);
        }
        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(dto)
                ));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null){
            log.error("Article Id IS NULL");
            return null;

        }
        Optional<Article> article = articleRepository.findById(id);

        return  Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
        new EntityNotFondException(
                "aucun article avec l'id =" + id + " n'est trouvé dans  BDD" + ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article CODE is null");
            return null;
        }

        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);

        return  Optional.of(ArticleDto.fromEntity(
                article.get())).orElseThrow(() ->
                new EntityNotFondException(
                        "aucun article avec le code  =" + codeArticle + " n'est trouvé dans  BDD" + ErrorCodes.ARTICLE_NOT_FOUND));
    }


    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article Id IS NULL");
            return;

        }
        articleRepository.deleteById(id);
    }
}
