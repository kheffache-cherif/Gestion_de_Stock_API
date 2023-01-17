package com.kheffache.gestionDeStock.dto;

import com.kheffache.gestionDeStock.model.Adresse;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AdresseDto {

    private String adresse1;
    private String adresse2;
    private String Ville;
    private String codePostale;
    private String pays;



    public static AdresseDto fromEntity(Adresse adresse){
        if(adresse== null){
            return null;
            // exception
        }
        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .codePostale(adresse.getCodePostale())
                .pays(adresse.getPays())
                .Ville(adresse.getVille())
                .build();
    }
    public static Adresse toEntity(AdresseDto adresseDto){
        if(adresseDto==null){
            return null;
        }
        Adresse adresse = new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2(adresseDto.getAdresse2());
        adresse.setPays(adresseDto.getPays());
        adresse.setVille(adresseDto.getVille());
        adresse.setCodePostale(adresseDto.getCodePostale());
    return adresse;

    }

}
