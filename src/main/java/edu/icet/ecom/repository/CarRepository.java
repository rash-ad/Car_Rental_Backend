package edu.icet.ecom.repository;

import edu.icet.ecom.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    //List<Car> findByStatus(CarStatus status);

    List<Car> findByCategoryId(Long categoryId);

    List<Car> findByBranchId(Long branchId);
}
