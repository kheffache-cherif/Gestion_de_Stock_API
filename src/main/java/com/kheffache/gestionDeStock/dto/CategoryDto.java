package com.kheffache.gestionDeStock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kheffache.gestionDeStock.model.Category;
import lombok.Builder;
import lombok.Data;

;
import java.util.List;
import java.util.Locale;

@Data
@Builder
public class CategoryDto {


    private Integer id;
    private String codeCategory;
    private String designation;
    @JsonIgnore
    private List<ArticleDto> Articles;

    // à partir de cette entity je vais construire mon dto
    public static CategoryDto fromEntity(Category category){
        if (category==null){
            return null;

                    // return exception
        }

        // maping de category vers category dto
        return CategoryDto.builder()
                .id(category.getId())
                .codeCategory(category.getCodeCategory())
                .designation(category.getDesignation())
                .build();
    }
    // maping de categoryDto dto vers category
    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto== null){
            return null;

            // return exception


        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCodeCategory(categoryDto.codeCategory);
        category.setDesignation(categoryDto.getDesignation());
        return category;
    }
}
