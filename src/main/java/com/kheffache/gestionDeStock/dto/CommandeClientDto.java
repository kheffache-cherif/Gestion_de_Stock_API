package com.kheffache.gestionDeStock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kheffache.gestionDeStock.model.CommandeClient;
import com.kheffache.gestionDeStock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;


import java.time.Instant;
import java.util.List;

@Data
@Builder

public class CommandeClientDto {

    private Integer id;
    private String codeCommande;
    private Instant dateCommande;
    private EtatCommande etatCommande;
    @JsonIgnore
    private ClientDto client;
    @JsonIgnore
    private List<LigneCommandeClientDto> ligneCommandeClients;


    public CommandeClientDto fromEntity(CommandeClient commandeClient){
        if (commandeClient== null){
            return  null;

        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .codeCommande(commandeClient.getCodeCommande())
                .dateCommande(commandeClient.getDateCommande())
                .build();

    }
    public CommandeClient toEntity(CommandeClientDto commandeClientDto){
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        commandeClient.setCodeCommande(commandeClientDto.getCodeCommande());
        return commandeClient;
    }
}
