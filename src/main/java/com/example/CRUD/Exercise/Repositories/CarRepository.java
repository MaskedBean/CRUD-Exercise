package com.example.CRUD.Exercise.Repositories;

import com.example.CRUD.Exercise.Entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {
}
