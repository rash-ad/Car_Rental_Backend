package edu.icet.ecom.service;

import edu.icet.ecom.dto.CarResponse;
import edu.icet.ecom.model.Car;
import edu.icet.ecom.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CarService  {


    List<Car>  getAllCars();


    void addCar(Car car);
}