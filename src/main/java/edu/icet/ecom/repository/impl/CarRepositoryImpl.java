package edu.icet.ecom.repository.impl;

import edu.icet.ecom.model.Car;
import edu.icet.ecom.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CarRepositoryImpl implements CarRepository {

  private final JdbcTemplate jdbcTemplate;


    @Override
    public List<Car> getAllCars() {
        return jdbcTemplate.query("select id,brand,model,color,price,year,fuelType,transmission," +
                        " available from car",
                new BeanPropertyRowMapper<>(Car.class));
    }

    @Override
    public void addCar(Car car) {
        String sql="Insert into Car(brand,model,color,price,year," +
                "fuelType,transmission,available)" +
                "values(?,?,?,?,?,?,?,?)";
        MapSqlParameterSource params =
                new MapSqlParameterSource()
                        .addValue("brand", car.getBrand())
                        .addValue("model",car.getModel())
                        .addValue("color", car.getColour())
                        .addValue("price", car.getPrice())
                        .addValue("year", car.getYear())
                        .addValue("fuelType", car.getFuelType())
                        .addValue("transmission", car.getTransmission())
                        .addValue("available", car.isAvailable());


        int update = jdbcTemplate.update(sql, params);
    }
}
