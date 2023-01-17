package com.kheffache.gestionDeStock.model;


import lombok.*;

import javax.persistence.*;

@Data

@EqualsAndHashCode(callSuper = true)

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Roles")

public class Roles extends AbstractEntity {

    @Column(name = "rolename")
  private String roleName;


    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    private Utilisateur utilisateur;


}
