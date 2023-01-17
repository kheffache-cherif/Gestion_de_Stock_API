package com.kheffache.gestionDeStock.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data

@EqualsAndHashCode(callSuper = true)

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Fournisseur")
public class Fournisseur extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Embedded  // pour dire que c'est un champs composé et à reutiliser Embbarqué
    private Adresse adresse;

    @Column(name = "photo")
    private String photo;

    @Column(name = "mail")
    private String mail;

    @Column(name = "numTel")
    private String numTel;
    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
