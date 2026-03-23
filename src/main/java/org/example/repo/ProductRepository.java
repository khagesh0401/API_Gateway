package org.example.repo;

import org.example.model.Product;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final MongoTemplate mongoTemplate;

    public ProductRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public List<Product> getProducts(){
        List<Product> products = mongoTemplate.findAll(Product.class);
        //for debugging purporse
        System.out.println("------product size-----"+products.size());
        return mongoTemplate.findAll(Product.class);
    }

    public Product createProduct(Product product) {
        return mongoTemplate.insert(product);
    }

    public Product getProductById(String id) {
        return mongoTemplate.findById(id, Product.class);
    }

    public Product updateProductById(String id, Product newProductDetails) {
        Product product = mongoTemplate.findById(id,Product.class);
        if(product!=null){
        product.setName(newProductDetails.getName());
        product.setAmount(newProductDetails.getAmount());
        mongoTemplate.save(product);
        return product;}
        return null;
    }
}
