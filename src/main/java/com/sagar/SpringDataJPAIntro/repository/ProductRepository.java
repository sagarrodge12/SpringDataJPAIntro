package com.sagar.SpringDataJPAIntro.repository;

import com.sagar.SpringDataJPAIntro.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
