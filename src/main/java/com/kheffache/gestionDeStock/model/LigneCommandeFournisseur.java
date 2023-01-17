package com.kheffache.gestionDeStock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data

@EqualsAndHashCode(callSuper = true)

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LigneCommandeFournisseur")
public class LigneCommandeFournisseur extends  AbstractEntity{


    @ManyToOne
    @JoinColumn(name="idarticle")
    private Article article;


    @ManyToOne
    @JoinColumn(name="idcommandefournisseur")
    private CommandeFournisseur commandeFournisseur;

    @Column(name = "quantite")
    private BigDecimal quatite;

    @Column(name = "prixUnintaire")
    private BigDecimal prixUnintaire;
    @Column(name = "identreprise")
    private Integer idEntreprise;

}
