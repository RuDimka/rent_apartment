package com.example.rent_apartment.repository;

import com.example.rent_apartment.model.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

        public UserInfoEntity findUserInfoEntityByNickName(String nickName);
        public UserInfoEntity findUserInfoEntityByEmail(String email);

}
