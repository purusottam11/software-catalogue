package com.purusottam.softwarecatalogue.repository;

import com.purusottam.softwarecatalogue.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
