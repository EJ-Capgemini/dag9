package com.capgemini.dag9.controller;

import com.capgemini.dag9.model.Car;
import com.capgemini.dag9.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public void addCar(@RequestBody Car car) {
        carService.save(car);
    }
}
