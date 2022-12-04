package com.example.CRUD.Exercise.Entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Car {

    @Id
    private String id;

    private String modelName;
    private String type;

}
