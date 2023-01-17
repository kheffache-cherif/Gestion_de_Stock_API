package com.kheffache.gestionDeStock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kheffache.gestionDeStock.model.CommandeFournisseur;
import com.kheffache.gestionDeStock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@Builder

public class CommandeFournisseurDto {

    private Integer id;
    private String code;
    private Instant dateCommande;
    private EtatCommande etatCommande;

    @JsonIgnore
    private FournisseurDto fournisseur;
    @JsonIgnore
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

public CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
    if(commandeFournisseur== null){
        return null;
    }
    return CommandeFournisseurDto.builder()
            .id(commandeFournisseur.getId())
            .code(commandeFournisseur.getCode())
            .dateCommande(commandeFournisseur.getDateCommande())
            .build();
}

public CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
    if (commandeFournisseurDto==null){
        return  null;
        // exception
    }
    CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
    commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
    commandeFournisseur.setCode(commandeFournisseur.getCode());
    commandeFournisseur.setId(commandeFournisseurDto.getId());
    return commandeFournisseur;
}


}
