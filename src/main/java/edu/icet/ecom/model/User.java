package edu.icet.ecom.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
}
