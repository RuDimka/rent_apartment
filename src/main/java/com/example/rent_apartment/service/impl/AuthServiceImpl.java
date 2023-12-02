package com.example.rent_apartment.service.impl;

import com.example.rent_apartment.model.dto.UserAuthorizationDto;
import com.example.rent_apartment.model.dto.UserRegistrationDto;
import com.example.rent_apartment.model.entity.UserInfoEntity;
import com.example.rent_apartment.repository.UserInfoRepository;
import com.example.rent_apartment.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public String registrationUser(UserRegistrationDto regDto) {

        UserInfoEntity userByNickName = userInfoRepository.findUserInfoEntityByNickName(regDto.getNickName());
        if(!isNull(userByNickName)){
            throw new RuntimeException("Пользователь с таким именем существует");
        }
        UserInfoEntity userByEmail = userInfoRepository.findUserInfoEntityByEmail(regDto.getEmail());
        if(!isNull(userByEmail)){
            throw new RuntimeException("Такой адрес почты уже существует");
        }
        UserInfoEntity userInfoEntity = new UserInfoEntity(regDto.getNickName(), regDto.getEmail(), regDto.getPassword(), null, regDto.getParentCity());
        userInfoRepository.save(userInfoEntity);
        return "Успешная регистрация";
    }

    @Override
    public String authorizationInfo(UserAuthorizationDto authDto) {

        UserInfoEntity user = userInfoRepository.findUserInfoEntityByEmail(authDto.getEmail());
        if(isNull(user)){
            throw new RuntimeException("Такого пользователя не существует, пройдите регистрацию!");
        }
        if(!authDto.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Неверный пароль");
        }
        String token = generatedToken();
        user.setToken(token);
        userInfoRepository.save(user);
        return token;
    }
    private String generatedToken(){

        String uniqueToken = UUID.randomUUID().toString();
        return uniqueToken + "|" + LocalDateTime.now().plusDays(1);
    }
}


