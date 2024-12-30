package com.sagar.SpringDataJPAIntro.controller;


import com.sagar.SpringDataJPAIntro.entity.Product;
import com.sagar.SpringDataJPAIntro.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductControllers {

    @Autowired
    ProductServices productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProductDetails(product);
    }
}
