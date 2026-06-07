package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Data
public class CarResponse {
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
