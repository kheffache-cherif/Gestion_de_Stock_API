package com.kheffache.gestionDeStock.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data

@EqualsAndHashCode(callSuper = true)

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LingeCommandeClient")
public class LingeCommandeClient extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name="idarticle")
    private Article article;
    @ManyToOne
    @JoinColumn(name="idcommandeclient")
    private CommandeClient commandeClient;

    @Column(name = "quantite")
    private BigDecimal quatite;

    @Column(name = "prixUnintaire")
    private BigDecimal prixUnintaire;


    @Column(name = "identreprise")
    private Integer idEntreprise;


}
