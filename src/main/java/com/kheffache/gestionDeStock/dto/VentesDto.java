package com.kheffache.gestionDeStock.dto;


import com.kheffache.gestionDeStock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder

public class VentesDto {

    private Integer id;
    private String codeVentes;

    private Instant dateVente;

    private String commentaire;




    public VentesDto fromEntity(Ventes ventes){
        if (ventes== null){
            return null;
        }
        return VentesDto.builder()
                .id(ventes.getId())
                .codeVentes(ventes.getCodeVentes())
                .dateVente(ventes.getDateVente())
                .commentaire(ventes.getCommentaire())
                .build();
    }

    public Ventes toEntity(VentesDto ventesDto){

        if(ventesDto== null){
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(ventesDto.getId());
        ventes.setCodeVentes(ventesDto.getCodeVentes());
        ventes.setDateVente(ventesDto.getDateVente());
        ventes.setCommentaire(ventesDto.getCommentaire());

        return  ventes;

    }

}
