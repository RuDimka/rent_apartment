package com.example.rent_apartment.mapper;

import com.example.rent_apartment.model.dto.RegistrationApartmentFormDto;
import com.example.rent_apartment.model.entity.AddressEntity;
import com.example.rent_apartment.model.entity.ApartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.jpa.repository.Query;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RentApartmentMapper {

    AddressEntity registrationApartmentDtoToAddressEntity(RegistrationApartmentFormDto registrationApartmentFormDto);

    ApartmentEntity registrationApartmentDtoToApartmentEntity(RegistrationApartmentFormDto registrationApartmentFormDto);


}
