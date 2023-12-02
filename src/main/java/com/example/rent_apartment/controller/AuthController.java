package com.example.rent_apartment.controller;

import com.example.rent_apartment.model.dto.UserAuthorizationDto;
import com.example.rent_apartment.model.dto.UserRegistrationDto;
import com.example.rent_apartment.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.rent_apartment.application_constant.ApplicationConstant.AUTHORIZATION;
import static com.example.rent_apartment.application_constant.ApplicationConstant.REGISTRATION;

@RestController
@Setter
@RequiredArgsConstructor
public class AuthController {

        private final AuthService authService;

        @PostMapping(REGISTRATION)
        public String getRegistration(@RequestBody UserRegistrationDto registrationForm){
                return authService.registrationUser(registrationForm);
        }


        @PostMapping(AUTHORIZATION)
        public String getAuthorization(@RequestBody UserAuthorizationDto authorizationInfo){
                return authService.authorizationInfo(authorizationInfo);
        }
}
