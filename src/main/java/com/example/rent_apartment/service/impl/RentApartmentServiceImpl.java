package com.example.rent_apartment.service.impl;

import com.example.rent_apartment.mapper.RentApartmentMapper;
import com.example.rent_apartment.model.dto.RegistrationApartmentFormDto;
import com.example.rent_apartment.model.entity.AddressEntity;
import com.example.rent_apartment.model.entity.ApartmentEntity;
import com.example.rent_apartment.repository.AddressRepository;
import com.example.rent_apartment.repository.ApartmentRepository;
import com.example.rent_apartment.service.RentApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentApartmentServiceImpl implements RentApartmentService {

    private final AddressRepository addressRepository;
    private final ApartmentRepository apartmentRepository;
    private final RentApartmentMapper rentApartmentMapper;

    @Override
    public String registrationNewApartment(RegistrationApartmentFormDto regFormDto) {

        AddressEntity addressEntity = rentApartmentMapper.registrationApartmentDtoToAddressEntity(regFormDto);
        addressRepository.save(addressEntity);
        ApartmentEntity apartmentEntity = rentApartmentMapper.registrationApartmentDtoToApartmentEntity(regFormDto);
        apartmentEntity.setAddressEntity(addressEntity);
        apartmentRepository.save(apartmentEntity);
        return "Апартаменты успешно зарегистрированы";
    }
}
