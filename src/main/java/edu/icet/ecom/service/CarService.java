package edu.icet.ecom.service;

import edu.icet.ecom.model.Car;
import edu.icet.ecom.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CarService {

    List<Car> getAllCars();

    Car addCar(Car car);

    boolean update( Integer id, Car car);

    User addUser(User user);
}