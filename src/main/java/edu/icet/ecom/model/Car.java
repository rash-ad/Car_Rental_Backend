package edu.icet.ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@ToString
@Setter
@Entity
public class Car {
    @Id
    private int id;
    private String brand;
    private String model;
    private String color;
    private double price;
    private int year;
    private String fuelType;
    private String transmission;
    private boolean available;

}
