package org.example.service;

import org.example.DTOs.ProductDto;
import org.example.model.Product;
import org.example.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProducts() {
        List<Product> productsList = productRepository.getProducts();
//        TODO :- Add Null checks
        return productsList.stream().map(prd -> new ProductDto(
                prd.getName(),
                prd.getAmount())).toList();
    }

    public ProductDto createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setAmount(productDto.getAmount());
        Product product1 = productRepository.createProduct(product);
        return new ProductDto(product1.getName(), product1.getAmount());
    }

    public ProductDto getProductById(String id) {
        Product product = productRepository.getProductById(id);
        return new ProductDto(product.getName(), product.getAmount());
    }

    //TODO :- handle this null check properly, proper messaging, and can we add something like,
    // while updating only fields given will get updated and others will still have old value instead of null?
    public ProductDto updateProductById(String id, ProductDto newProductDetails) {
        if (newProductDetails != null) {
            Product newProduct = new Product(newProductDetails.getName(), newProductDetails.getAmount());
            Product product = productRepository.updateProductById(id, newProduct);
            if (product != null)
                return new ProductDto(product.getName(), product.getAmount());
            }
            return null;
    }

}
