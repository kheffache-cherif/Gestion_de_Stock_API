package com.kheffache.gestionDeStock.dto;

import com.kheffache.gestionDeStock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import java.util.List;
@Data
@Builder

public class EntrepriseDto {


    private Integer id;

    private String nom;

    private String description;

    private AdresseDto adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private String numTel;

    private String steWeb;

    private List<UtilisateurDto> utilisateurs;


    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if(entreprise == null){
            return  null ;
        }
        return  EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .email(entreprise.getEmail())
                .codeFiscal(entreprise.getCodeFiscal())
                .description(entreprise.getDescription())
                .steWeb(entreprise.getSteWeb())
                .photo(entreprise.getPhoto())
                .numTel(entreprise.getNumTel())
                .build();

    }
    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if(entrepriseDto== null){
            return  null ;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setSteWeb(entrepriseDto.getSteWeb());

        return entreprise;
    }
}
