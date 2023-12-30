package com.example.rent_apartment.service.impl;

import com.example.rent_apartment.model.entity.UserInfoEntity;
import com.example.rent_apartment.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@EnableScheduling
@Service
@RequiredArgsConstructor
@Slf4j
public class TokenValueScheduler {

    private final UserInfoRepository userInfoRepository;

    @Scheduled(fixedDelay = 60000)
    public void checkStatusToken() {

        log.info("Планировщик начал работу, подготовка списка токенов для проверки");

        List<UserInfoEntity> tokenList = userInfoRepository.findUserInfoEntitiesByTokenIsNotNull();
        for (UserInfoEntity u : tokenList) {
            LocalDateTime timeToken = parsTimeValue(u.getToken());
            if (timeToken.isBefore(LocalDateTime.now())) {

                log.info("Токен пользователся " + u.getNickName() + " просрочен и был удален");

                u.setToken(null);
                userInfoRepository.save(u);
            }
        }

        log.info("Планировщик закончил свою работу " + LocalDateTime.now());

    }

    private LocalDateTime parsTimeValue(String token) {
        int index = token.indexOf("|") + 1;
        String timeValue = token.substring(index);
        LocalDateTime dateTimeToken = LocalDateTime.parse(timeValue);
        return dateTimeToken;
    }
}
