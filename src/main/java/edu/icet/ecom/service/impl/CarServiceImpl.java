package edu.icet.ecom.service.impl;

import edu.icet.ecom.model.Car;
import edu.icet.ecom.model.User;
import edu.icet.ecom.repository.CarRepository;
import edu.icet.ecom.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public boolean update(Integer id,Car car) {
        if (!carRepository.existsById(car.getId())) {
            return false;
        }
        carRepository.save(car); // save() does update if id already exists
        return true;
    }

    @Override
    public User addUser(User user) {
        return null;
    }
}
