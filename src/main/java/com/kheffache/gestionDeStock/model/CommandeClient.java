package com.kheffache.gestionDeStock.model;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data

@EqualsAndHashCode(callSuper = true)

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CommandeClient")
public class CommandeClient extends AbstractEntity{

    @Column(name = "codeCommande")
    private String codeCommande;

    @Column(name = "dateCommande")
    private Instant dateCommande;

    @Column(name = "etatcommande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;

    @ManyToOne()
    @JoinColumn(name = "idclient")
    private Client client;

    @Column(name = "identreprise")
    private Integer idEntreprise;


    @OneToMany(mappedBy = "commandeClient")
    private List<LingeCommandeClient>ligneCommandeClients;

}
