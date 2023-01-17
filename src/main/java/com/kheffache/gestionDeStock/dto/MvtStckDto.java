package com.kheffache.gestionDeStock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kheffache.gestionDeStock.model.MvtStk;
import com.kheffache.gestionDeStock.model.TypeMvStock;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder


public class MvtStckDto {


    private Integer id;
    private Instant dateMvt; // date movement stock
    private BigDecimal quantite;
    @JsonIgnore
    private ArticleDto article;

    private TypeMvStock typeMvStock;

    public MvtStckDto fromEntity(MvtStk mvtStk){
        if (mvtStk==null){
            return  null;
        }
       return MvtStckDto.builder()
                .id(mvtStk.getId())
                .dateMvt(getDateMvt())
                .quantite(getQuantite())
               .build();
    }

    public MvtStk toEntity(MvtStckDto mvtStckDto){
        if(mvtStckDto== null){
            return  null;

        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setDateMvt(mvtStckDto.getDateMvt());
        mvtStk.setId(mvtStckDto.getId());
        mvtStk.setQuantite(mvtStckDto.getQuantite());

        return mvtStk;
    }
}
