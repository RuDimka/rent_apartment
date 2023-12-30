package com.example.rent_apartment.repository;

import com.example.rent_apartment.model.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

    public UserInfoEntity findUserInfoEntityByNickName(String nickName); //SpringData generation

    public UserInfoEntity findUserInfoEntityByEmail(String email); //SpringData generation

    @Query(nativeQuery = true, value = "SELECT * FROM user_info WHERE nick_name = :nickName")//native Query
    public UserInfoEntity findUserInfoEntityNative(String nickName);

    @Query(value = "SELECT u FROM UserInfoEntity u WHERE u.nickName = :nickName")//jpql query (решает проблему N+1)
    public UserInfoEntity findUserInfoEntityJPQL(String nickName);

    @Query(nativeQuery = true, value = "SELECT * FROM user_info WHERE email = :email")
    public UserInfoEntity fingUserInfoEntityEmailNative(String email);

    @Query(value = "SELECT e FROM UserInfoEntity  e WHERE e.email = :email")
    public UserInfoEntity findUserInfoEntityEmailJPQL(String email);

    public List<UserInfoEntity> findUserInfoEntitiesByTokenIsNotNull();

//    @Query(nativeQuery = true, value = "SELECT * FROM user_info WHERE password = 123qwer OR 1=1")
//    public UserInfoEntity login(String password);
//    String password = "123qwer OR 1=1"; //todo SQL injection example
}
