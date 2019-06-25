package com.ibm.bank.bank.repositories;

import com.ibm.bank.bank.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {
}
