package com.kheffache.gestionDeStock.repository;

import com.kheffache.gestionDeStock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
