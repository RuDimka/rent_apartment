package com.example.rent_apartment.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "apartment")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentEntity {

    @Id
    @SequenceGenerator(name = "apartment", sequenceName = "apartment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment")
    @Column(name = "id")
    private Long id;

    @Column(name = "rooms_count")
    private String roomsCount;

    @Column(name = "price")
    private Double price;

    @Column(name = "free_pets")
    private Boolean freePets;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "date_registration")
    private LocalDateTime dateRegistration;

    @Column(name = "free_flag")
    private Boolean freeFlag;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private AddressEntity addressEntity;
}
