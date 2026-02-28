package org.example.repo;

import org.example.DTOs.ProductDto;
import org.example.model.Product;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private MongoTemplate mongoTemplate;

    public ProductRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public List<Product> getProducts(){
        List<Product> products = mongoTemplate.findAll(Product.class);
        System.out.println("------product size-----"+products.size());
        return mongoTemplate.findAll(Product.class);
    }

}
