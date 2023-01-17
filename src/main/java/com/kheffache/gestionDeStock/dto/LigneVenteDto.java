package com.kheffache.gestionDeStock.dto;

import com.kheffache.gestionDeStock.model.LigneVente;
import com.kheffache.gestionDeStock.model.LingeCommandeClient;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {

    private Integer id;

    @JoinColumn
    private VentesDto vente;

    private BigDecimal quatite;

    private BigDecimal prixUnintaire;



    public  LigneVenteDto fromEntity (LigneVente ligneVente){
        if(ligneVente==null){
            return null;
        }
        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .quatite(ligneVente.getQuatite())
                .prixUnintaire(ligneVente.getPrixUnintaire())
                .build();
    }

    public LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if(ligneVenteDto== null){
            return  null;
        }

        LigneVente ligneVente=new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setQuatite(ligneVenteDto.getQuatite());
        ligneVente.setPrixUnintaire(ligneVenteDto.getPrixUnintaire());

        return ligneVente;
    }

}


