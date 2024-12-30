package com.sagar.SpringDataJPAIntro.service;

import com.sagar.SpringDataJPAIntro.entity.Product;
import com.sagar.SpringDataJPAIntro.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProductDetails(Product product){
        return productRepository.save(product);
    }
}
