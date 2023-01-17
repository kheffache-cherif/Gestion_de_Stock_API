package com.kheffache.gestionDeStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClientRepository, Integer> {


  List<LigneCommandeClientRepository> findAllByCommandeClientId(Integer id);

  List<LigneCommandeClientRepository> findAllByArticleId(Integer id);
}
