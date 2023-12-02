package com.example.rent_apartment.model.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {

    private String nickName;
    private String email;
    private String password;
    private String parentCity;
}
