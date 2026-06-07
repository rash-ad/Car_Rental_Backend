package edu.icet.ecom.controller;

import edu.icet.ecom.model.Car;
import edu.icet.ecom.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarController {
        @Autowired
        private CarService carService;

        @GetMapping("/AllCars")
        public List<Car> getAllCars() {
            return carService.getAllCars();
        }

    }

