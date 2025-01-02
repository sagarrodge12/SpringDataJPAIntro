package com.sagar.SpringDataJPAIntro.controller;


import com.sagar.SpringDataJPAIntro.dto.ProductDTO;
import com.sagar.SpringDataJPAIntro.entity.Product;
import com.sagar.SpringDataJPAIntro.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductControllers {

    @Autowired
    ProductServices productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProductDetails(product);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> allProductDetails = productService.getAllProductDetails();
        if (allProductDetails.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allProductDetails);
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Object> getProductByID(@PathVariable long id){
        Product productDetailsById = productService.getProductDetailsById(id);
        if (productDetailsById == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found for: "+id);
        }
        return ResponseEntity.ok(productDetailsById);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Object> updateProductById(@PathVariable long id,@RequestBody Product product){
        Product updatedProduct = productService.UpdateProductDetailsById(id, product);
        if (updatedProduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found for: "+id+" to update");
        }
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("getProductPage/{offset}/{pageSize}")
    public Page<Product> findProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        return productService.findProductsWithPagination(offset, pageSize);
    }

    @GetMapping("/getAllProducts/{field}")
    public List<Product> getProductSort(@PathVariable String field){
        return productService.getProductsWithSorting(field);
    }

    @GetMapping("/getAllProducts/{offset}/{pageSize}/{field}")
    public Page<Product> getProductsWithSortAndPage(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
        return productService.getProductWithSortingAndPagination(offset, pageSize, field);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public String deleteProductById(@PathVariable long id){
        productService.DeleteProductDetailsById(id);
        return "Product is deleted from DB...";
    }

}
