package com.kheffache.gestionDeStock.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Data

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ventes")
public class Ventes extends AbstractEntity{

    @Column(name = "codeVentes")
    private String codeVentes;

    @Column(name = "dateVente")
    private Instant dateVente;

    @Column(name = "commentaire")

    private String commentaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;


}
