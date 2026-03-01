package org.example.controller;

import org.example.DTOs.ProductDto;
import org.springframework.web.bind.annotation.*;
import org.example.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/API_Gateway")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        List<ProductDto> products = new ArrayList<>();
        products = productService.getProducts();
        return products;
    }

    @PostMapping("/create/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }
}
