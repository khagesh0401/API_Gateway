package org.example.service;

import org.example.DTOs.ProductDto;
import org.example.model.Product;
import org.example.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProducts(){
        List<Product> productsList = productRepository.getProducts();
//        TODO :- Add Null checks
        return productsList.stream().map(prd -> new ProductDto(
                prd.getName(),
                prd.getAmount())).toList();
    }
}
