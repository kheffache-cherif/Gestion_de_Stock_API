package com.kheffache.gestionDeStock.validator;

import com.kheffache.gestionDeStock.dto.MvtStckDto;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MvtStkValidator {


    public static List<String> validate(MvtStckDto mvtStckDto) {
        List<String> errors = new ArrayList<>();
        if (mvtStckDto == null) {
            errors.add("Veuillez renseigner la date du mouvenent");
            errors.add("Veuillez renseigner la quantite du mouvenent");
            errors.add("Veuillez renseigner l'article");
            errors.add("Veuillez renseigner le type du mouvement");

            return errors;
        }
        if (mvtStckDto.getDateMvt() == null) {
            errors.add("Veuillez renseigner la date du mouvenent");
        }
        if (mvtStckDto.getQuantite() == null || mvtStckDto.getQuantite().compareTo(BigDecimal.ZERO) == 0) {
            errors.add("Veuillez renseigner la quantite du mouvenent");
        }
        if (mvtStckDto.getArticle() == null || mvtStckDto.getArticle().getId() == null) {
            errors.add("Veuillez renseigner l'article");
        }
        if (!StringUtils.hasLength(mvtStckDto.getTypeMvStock().name())) {
            errors.add("Veuillez renseigner le type du mouvement");
        }

        return errors;
    }
}
