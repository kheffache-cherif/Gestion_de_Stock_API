package com.kheffache.gestionDeStock.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data

@EqualsAndHashCode(callSuper = true)

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LigneVente")
public class LigneVente extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name ="idvente")
    private Ventes vente;


    @Column(name = "quantite")
    private BigDecimal quatite;

    @Column(name = "prixUnintaire")
    private BigDecimal prixUnintaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;
}
