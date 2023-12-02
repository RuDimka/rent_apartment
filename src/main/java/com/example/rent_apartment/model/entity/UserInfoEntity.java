package com.example.rent_apartment.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_info")
@NoArgsConstructor
@Data
public class UserInfoEntity {

    @Id
    @SequenceGenerator(name = "user_info", sequenceName = "user_info_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info")
    @Column(name = "id")
    private Long id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "date_registration")
    private String dateRegistration;

    @Column(name = "token")
    private String token;

    @Column(name = "parent_city")
    private String parentCity;

    public UserInfoEntity(String nickName, String email, String password, String token, String parentCity) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.dateRegistration = LocalDateTime.now().toString();
        this.token = token;
        this.parentCity = parentCity;
    }
}
