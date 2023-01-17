package com.kheffache.gestionDeStock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kheffache.gestionDeStock.model.LigneCommandeFournisseur;
import com.kheffache.gestionDeStock.model.LingeCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder

public class LigneCommandeFournisseurDto {

    private Integer id;
    @JsonIgnore
    private ArticleDto article;
    @JsonIgnore
    private CommandeFournisseurDto commandeFournisseur;
    private BigDecimal quatite;
    private BigDecimal prixUnintaire;


    public  LigneCommandeFournisseurDto fromEntity (LigneCommandeFournisseur ligneCommandeFournisseur){
        if(ligneCommandeFournisseur==null){
            return null;
        }
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .quatite(ligneCommandeFournisseur.getQuatite())
                .prixUnintaire(ligneCommandeFournisseur.getPrixUnintaire())
                .build();
    }

    public LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        if(ligneCommandeFournisseurDto== null){
            return  null;
        }

        LigneCommandeFournisseur ligneCommandeFournisseur=new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
        ligneCommandeFournisseur.setQuatite(ligneCommandeFournisseurDto.getQuatite());
        ligneCommandeFournisseur.setPrixUnintaire(ligneCommandeFournisseurDto.getPrixUnintaire());

        return ligneCommandeFournisseur;
    }

}
