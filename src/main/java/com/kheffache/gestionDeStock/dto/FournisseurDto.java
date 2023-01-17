package com.kheffache.gestionDeStock.dto;

import com.kheffache.gestionDeStock.model.Adresse;
import com.kheffache.gestionDeStock.model.Entreprise;
import com.kheffache.gestionDeStock.model.Fournisseur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import java.util.List;


@Data
@Builder

public class FournisseurDto {


    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numTel;

    private List<CommandeFournisseurDto> commandeFournisseurs;



    public FournisseurDto fromEntity(Fournisseur fournisseur){
        if(fournisseur == null){
            return  null ;
        }
        return  FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .photo(fournisseur.getPhoto())
                .numTel(fournisseur.getNumTel())
                .mail(fournisseur.getMail())
                .build();

    }
    public Fournisseur toEntity(FournisseurDto fournisseurDto){
        if(fournisseurDto== null){
            return  null ;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setNumTel(fournisseurDto.getNumTel());
        return fournisseur;
    }
}