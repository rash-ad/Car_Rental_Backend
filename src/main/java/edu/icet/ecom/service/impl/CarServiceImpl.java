package edu.icet.ecom.service.impl;

import edu.icet.ecom.model.Car;
import edu.icet.ecom.repository.CarRepository;
import edu.icet.ecom.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;


    @Override
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }
}
