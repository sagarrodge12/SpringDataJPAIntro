package com.sagar.SpringDataJPAIntro.service;

import com.sagar.SpringDataJPAIntro.dto.ProductDTO;
import com.sagar.SpringDataJPAIntro.entity.Product;
import com.sagar.SpringDataJPAIntro.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProductDetails(Product product) {
        return productRepository.save(product);
    }

    public List<ProductDTO> getAllProductDetails() {
        List<Product> productList = productRepository.findAll();

        //Converting Product to ProductDTO so only necessary fields will show to client(Postman)
        return productList.stream().map(product -> new ProductDTO(
                product.getName(), product.getDescription(), product.getPrice(), product.getImageUrl()
        )).toList();
    }

    public Product getProductDetailsById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByStockKeepingUnit(String skuNumber) {
        return productRepository.findByStockKeepingUnit(skuNumber);
    }

    public Product UpdateProductDetailsById(long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setImageUrl(product.getImageUrl());
        return productRepository.save(existingProduct);
    }

    public String DeleteProductDetailsById(long id) {
        productRepository.deleteById(id);
        return "Record Deleted for: " + id;

    }

    public Page<Product> findProductsWithPagination(int offset,int pageSize){
        return productRepository.findAll(PageRequest.of(offset, pageSize));
    }

    public List<Product> getProductsWithSorting(String field){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

}
