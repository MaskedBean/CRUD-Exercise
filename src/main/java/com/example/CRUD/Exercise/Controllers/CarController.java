package com.example.CRUD.Exercise.Controllers;

import com.example.CRUD.Exercise.Entities.Car;
import com.example.CRUD.Exercise.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;



    @PostMapping("")
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping("")
    public List<Car> getCarS(@RequestParam String id) {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable String id) {
        if (carRepository.existsById(id)) {
            return carRepository.findById(id);
        } else {
            return Optional.of(new Car());
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable String id) {
        if (carRepository.existsById(id)){
            carRepository.deleteById(id);
            return "The Car with id: " + "'" + id + "'" + " is been deleted!";
        }else{
            return String.valueOf(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("")
    public String deleteAllCars(){
        carRepository.deleteAll();
        return "All the cars are deleted";
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable String id,@RequestParam String type){
        if (carRepository.existsById(id)){
            Car cart = carRepository.findById(id).get();
            cart.setType(type);
            carRepository.save(cart);
            return cart;
        }else{
            return new Car();
        }

    }
}
