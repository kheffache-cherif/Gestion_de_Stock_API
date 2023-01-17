package com.kheffache.gestionDeStock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kheffache.gestionDeStock.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {

    private Integer id;
    private String roleName;
    @JsonIgnore
    private UtilisateurDto utilisateur;



    public static RolesDto fromEntity(Roles roles){
        if(roles== null){
            return null;
        }
       return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public  Roles toEntity(RolesDto rolesDto){
        if (rolesDto == null){
            return  null;
        }


        Roles roles = new Roles();
        roles.setRoleName(rolesDto.getRoleName());
        roles.setId(rolesDto.getId());
        return roles;
    }
}


