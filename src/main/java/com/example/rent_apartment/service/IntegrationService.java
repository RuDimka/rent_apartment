package com.example.rent_apartment.service;

import com.example.rent_apartment.model.dto.LocationDataDto;

public interface IntegrationService {

    public String getInfoByLocation(LocationDataDto loc);
}
