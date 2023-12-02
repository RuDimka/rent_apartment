package com.example.rent_apartment.service;

import com.example.rent_apartment.model.dto.UserAuthorizationDto;
import com.example.rent_apartment.model.dto.UserRegistrationDto;

public interface AuthService {

    public String registrationUser(UserRegistrationDto userRegistrationInfo);

    public String authorizationInfo(UserAuthorizationDto userAuthorizationDto);
}
