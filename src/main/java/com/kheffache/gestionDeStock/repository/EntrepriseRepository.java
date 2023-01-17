package com.kheffache.gestionDeStock.repository;

import com.kheffache.gestionDeStock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
