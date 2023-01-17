package com.kheffache.gestionDeStock.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@EqualsAndHashCode(callSuper = true)
@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article")
public class Article  extends AbstractEntity{

@Column(name = "codeArticle")
private String codeArticle;

@Column(name = "designation")
private String designation;

@Column(name = "prixUnitaireHt")
private BigDecimal prixUnitaireHt;

@Column(name = "tauxTva")
private BigDecimal tauxTva;

@Column(name = "prixUnitaireTtc")
private  BigDecimal prixUnitaireTtc;

@Column(name = "photo")
private String photo;
    @Column(name = "identreprise")
    private Integer idEntreprise;

@ManyToOne
@JoinColumn(name = "IdCategory")
private Category category;

}
