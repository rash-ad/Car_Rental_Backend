package edu.icet.ecom.dto;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@AllArgsConstructor
@Data
@Setter
@ToString
public class CarResponse {
    @Id
    private Integer id;
    private String brand;
    private String model;
    private String color;
    private Double price;
    private Integer year;
    private String fuelType;
    private String transmission;
    private Boolean available;
}
