package com.sagar.SpringDataJPAIntro.service;

import com.sagar.SpringDataJPAIntro.entity.Product;
import com.sagar.SpringDataJPAIntro.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProductDetails(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProductDetails(){
        return productRepository.findAll();

    }
}
