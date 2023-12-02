package com.example.rent_apartment.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationApartmentFormDto {

    private String city;
    private String street;
    private String houseNumber;
    private String roomsCount;
    private Double price;
    private Boolean freePets;
}
