package edu.icet.ecom.repository.impl;

import edu.icet.ecom.model.Car;
import edu.icet.ecom.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CarRepositoryImpl implements CarRepository {

  private final JdbcTemplate jdbcTemplate;


    @Override
    public List<Car> getAllCars() {
        return jdbcTemplate.query("select * from car",
                new BeanPropertyRowMapper<>(Car.class));
    }
}
