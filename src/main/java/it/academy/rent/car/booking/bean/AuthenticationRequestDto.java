package it.academy.rent.car.booking.bean;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
