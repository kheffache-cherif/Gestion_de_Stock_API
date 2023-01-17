package com.kheffache.gestionDeStock.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable  //integrable dans d'autres classes

public class Adresse implements Serializable {
    @Column(name="adresse1")
    private String adresse1;
    @Column(name="adresse2")
    private String adresse2;
    @Column(name="Ville")
    private String Ville;
    @Column(name="codePostale")
    private String codePostale;
    @Column(name="pays")
    private String pays;
    @Column(name = "identreprise")
    private Integer idEntreprise;
}
