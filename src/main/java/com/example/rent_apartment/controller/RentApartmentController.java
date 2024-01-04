package com.example.rent_apartment.controller;

import com.example.rent_apartment.model.dto.LocationDataDto;
import com.example.rent_apartment.model.dto.RegistrationApartmentFormDto;
import com.example.rent_apartment.model.entity.AddressEntity;
import com.example.rent_apartment.service.RentApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.rent_apartment.application_constant.ApplicationConstant.BY_LOCATION;
import static com.example.rent_apartment.application_constant.ApplicationConstant.REG_APARTMENT;

@RestController
@RequiredArgsConstructor
public class RentApartmentController {

    private final RentApartmentService rentApartmentService;

    @PostMapping(REG_APARTMENT)
    public String getRegApartment(@RequestBody RegistrationApartmentFormDto regFormDto) {
        return rentApartmentService.registrationNewApartment(regFormDto);
    }

    @PostMapping(BY_LOCATION)
    public List<AddressEntity> findApartmentByLocation(@RequestBody LocationDataDto loc){
        return rentApartmentService.findApartmentByLocation(loc);
    }
}
