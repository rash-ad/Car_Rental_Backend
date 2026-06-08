package edu.icet.ecom.service.impl;

import edu.icet.ecom.model.Car;
import edu.icet.ecom.repository.CarRepository;
import edu.icet.ecom.service.CarService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j

public class CarServiceImpl implements CarService {
    @Autowired
    private  final CarRepository carRepository;


    @Override
    public List<Car> getAllCars() {
        log.info("Connecting to DB...");
        log.info("Connected...");
        return carRepository.getAllCars();
    }

    @Override
    public void addCar(Car car) {
          carRepository.addCar(car);
    }



}
