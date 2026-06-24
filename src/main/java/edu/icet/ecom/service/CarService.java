package edu.icet.ecom.service;

import edu.icet.ecom.dto.CarResponse;
import edu.icet.ecom.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CarService {

    List<Car> getAllCars();

    Car addCar(Car car);
}