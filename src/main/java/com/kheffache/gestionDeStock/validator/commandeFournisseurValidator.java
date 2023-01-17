package com.kheffache.gestionDeStock.validator;

import com.kheffache.gestionDeStock.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class commandeFournisseurValidator {

    public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto) {
        List<String> errors = new ArrayList<>();
        if (commandeFournisseurDto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
            return errors;
        }

        if (!StringUtils.hasLength(commandeFournisseurDto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (commandeFournisseurDto.getDateCommande() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }
        if (!StringUtils.hasLength(commandeFournisseurDto.getEtatCommande().toString())) {
            errors.add("Veuillez renseigner l'etat de la commande");
        }

        // || commandeFournisseurDto.getFournisseur().getId() == null
        if (commandeFournisseurDto.getFournisseur() == null) {
            errors.add("Veuillez renseigner le fournisseur");
        }

        return errors;
    }
}
