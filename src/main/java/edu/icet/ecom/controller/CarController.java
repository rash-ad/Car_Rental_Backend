package edu.icet.ecom.controller;

import edu.icet.ecom.model.Car;
import edu.icet.ecom.model.User;
import edu.icet.ecom.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarController {

        private final  CarService carService;

        @GetMapping("/AllCars")
        public List<Car> getAllCars() {
            return carService.getAllCars();
        }
    @PostMapping("/createCar")
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Car car) {
        boolean updated = carService.update(id,car);
        if (updated) {
            return ResponseEntity.ok("Car updated successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
    }

    }

