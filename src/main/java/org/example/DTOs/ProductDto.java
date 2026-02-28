package org.example.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String amount;

    public ProductDto(String name, String amount){
        this.name=name;
        this.amount=amount;

    }
}
