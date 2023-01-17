package com.kheffache.gestionDeStock.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kheffache.gestionDeStock.model.LingeCommandeClient;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {

    private Integer id;

    @JsonIgnore
    private ArticleDto article;
    @JsonIgnore
    private CommandeClientDto commandeClient;


    private BigDecimal quatite;


    private BigDecimal prixUnintaire;


    public  LigneCommandeClientDto fromEntity (LingeCommandeClient lingeCommandeClient){
        if(lingeCommandeClient==null){
            return null;
        }
       return LigneCommandeClientDto.builder()
                .id(lingeCommandeClient.getId())
                .quatite(lingeCommandeClient.getQuatite())
                .prixUnintaire(lingeCommandeClient.getPrixUnintaire())
                .build();
    }

    public LingeCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if(ligneCommandeClientDto== null){
            return  null;
        }

        LingeCommandeClient lingeCommandeClient=new LingeCommandeClient();
        lingeCommandeClient.setId(ligneCommandeClientDto.getId());
        lingeCommandeClient.setQuatite(ligneCommandeClientDto.getQuatite());
        lingeCommandeClient.setPrixUnintaire(ligneCommandeClientDto.getPrixUnintaire());

        return lingeCommandeClient;
    }

}
