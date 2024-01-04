package com.example.rent_apartment.service;

import com.example.rent_apartment.model.dto.LocationDataDto;
import com.example.rent_apartment.model.dto.RegistrationApartmentFormDto;
import com.example.rent_apartment.model.entity.AddressEntity;

import java.util.List;

public interface RentApartmentService {

    public String registrationNewApartment(RegistrationApartmentFormDto regFormDto);
    public List<AddressEntity> findApartmentByLocation(LocationDataDto loc);
}

