package com.kheffache.gestionDeStock.validator;

import com.kheffache.gestionDeStock.dto.VentesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> validate(VentesDto ventesDto) {
        List<String> errors = new ArrayList<>();
        if (ventesDto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            return errors;
        }

        if (!StringUtils.hasLength(ventesDto.getCodeVentes())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (ventesDto.getDateVente() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }

        return errors;
    }
}
