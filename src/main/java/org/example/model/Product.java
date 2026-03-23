package org.example.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Data
@Document(collection = "Products")
public class Product {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String name;
    private String amount;

    public Product(){}

    public Product(String name, String amount) {
        this.name=name;
        this.amount=amount;
    }
}
