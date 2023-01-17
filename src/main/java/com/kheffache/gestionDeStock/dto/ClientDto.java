package com.kheffache.gestionDeStock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kheffache.gestionDeStock.model.Adresse;
import com.kheffache.gestionDeStock.model.Client;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import java.util.List;

@Data
@Builder
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String mail;

    private String numTel;

    private String photo;

    @JsonIgnore
    private List<CommandeClientDto> CommandeClients;


    public ClientDto fromEntity(Client client){
        if(client == null){
            return  null;

            //exception
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                //.adresse(client.getAdresse())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .photo(client.getPhoto())
                .build();
    }

    public Client toEntity(ClientDto clientDto){
        if(clientDto == null){
            return null;
            ///
        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setMail(clientDto.getMail());
        client.setNumTel(clientDto.getNumTel());
        client.setPhoto(clientDto.getPhoto());
        return client;
    }
}
