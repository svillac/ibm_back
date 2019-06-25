package com.ibm.bank.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.bank.bank.entities.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
}
