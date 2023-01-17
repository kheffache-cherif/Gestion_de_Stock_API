package com.kheffache.gestionDeStock.services.Impl;


import com.kheffache.gestionDeStock.Exceptions.ErrorCodes;
import com.kheffache.gestionDeStock.Exceptions.InvalidEntityException;
import com.kheffache.gestionDeStock.dto.CategoryDto;
import com.kheffache.gestionDeStock.model.Article;
import com.kheffache.gestionDeStock.repository.ArticleRepository;
import com.kheffache.gestionDeStock.repository.CategoryRepository;
import com.kheffache.gestionDeStock.services.CategoryService;
import com.kheffache.gestionDeStock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.awt.dnd.InvalidDnDOperationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

  private CategoryRepository categoryRepository;
  private ArticleRepository articleRepository;

  @Autowired
  public CategoryServiceImpl(CategoryRepository categoryRepository, ArticleRepository articleRepository) {
    this.categoryRepository = categoryRepository;
    this.articleRepository = articleRepository;
  }

  @Override
  public CategoryDto save(CategoryDto dto) {
    List<String> errors = CategoryValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalidEntityException("La category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID);
    }
    return CategoryDto.fromEntity(
        categoryRepository.save(CategoryDto.toEntity(dto))
    );
  }

  @Override
  public CategoryDto findById(Integer id) {
    if (id == null) {
      log.error("Category ID is null");
      return null;
    }
    return categoryRepository.findById(id)
        .map(CategoryDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
                "aucune category avec l'id =" + id + " n'est trouvé dans  BDD" + ErrorCodes.ARTICLE_NOT_FOUND));
  }

  @Override
  public CategoryDto findByCode(String code) {
    if (!StringUtils.hasLength(code)) {
      log.error("Category CODE is null");
      return null;
    }
    return categoryRepository.findCategoryByCode(code)
        .map(CategoryDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
                "aucun article avec le code  =" + code + " n'est trouvé dans  BDD" + ErrorCodes.ARTICLE_NOT_FOUND));
  }

  @Override
  public List<CategoryDto> findAll() {
    return categoryRepository.findAll().stream()
        .map(CategoryDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Category ID is null");
      return;
    }
    List<Article> articles = articleRepository.findAllByCategoryId(id);
    if (!articles.isEmpty()) {
      throw new InvalidDnDOperationException();
    }
    categoryRepository.deleteById(id);
  }
}
