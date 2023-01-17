package com.kheffache.gestionDeStock.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data

@EqualsAndHashCode(callSuper = true)

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MvtStk")
public class MvtStk  extends AbstractEntity{

    @Column(name = "dateMvt")
    private Instant dateMvt; // date movement stock
    @Column(name = "quantite")
    private BigDecimal quantite;

    @ManyToOne
    @JoinColumn(name="idarticle")
    private Article article;

    @Column(name = "typeMvSock")
    private TypeMvStock typeMvStock;
    @Column(name = "identreprise")
    private Integer idEntreprise;
}
