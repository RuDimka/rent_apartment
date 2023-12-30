package com.example.rent_apartment.repository;

import com.example.rent_apartment.model.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

//    @Query(nativeQuery = true, value = " SELECT * FROM address WHERE street = :street")
//    public AddressEntity findAddressEntityNative(String street);
//
//    @Query(value = "SELECT a FROM AddressEntity a WHERE a.street = :street")
//    public AddressEntity findAddressEntityJPQL(String street);
}
