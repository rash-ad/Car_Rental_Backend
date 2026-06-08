package edu.icet.ecom.repository;

import edu.icet.ecom.model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository  {

    List<Car> getAllCars();
    void  addCar(Car car);

}
