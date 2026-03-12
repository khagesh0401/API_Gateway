package org.example.controller;

import org.example.DTOs.ProductDto;
import org.springframework.web.bind.annotation.*;
import org.example.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/API_Gateway")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/product/all")
    public List<ProductDto> getProducts() {
        List<ProductDto> products;
        products = productService.getProducts();
        return products;
    }

    @PostMapping("/product/create")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @GetMapping("/product/{id}")
    public ProductDto getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }
}
