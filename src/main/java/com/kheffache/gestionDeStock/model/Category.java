package com.kheffache.gestionDeStock.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "Category")
public class Category extends AbstractEntity {
    @Column(name = "codeCategory")
    private String codeCategory;

    @Column(name = "designation")
    private String designation;

    @Column(name = "identreprise")
    private Integer idEntreprise;

 //une category contien plusieurs articles
    @OneToMany(mappedBy = "category")
    private List<Article> Articles;



}
