package com.example.demo.repositories;

import com.example.demo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<UserEntity,Long> {

    UserEntity findByUserName(String userName);
    UserEntity findByInn(String inn);
}
