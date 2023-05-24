package com.example.demo.services;

import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.UserRep;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class UserService {

    UserRep userRep;

//    public void saveUser(String name, String patronymic, String surname, String birth, Organization organization){
//        UserEntity subscriber = new UserEntity(name,patronymic,surname,date,age,organization);
//        clientRep.save(subscriber);
//        log.info("Create new user. Name{}",name);
//    }

    public void deleteUser(Long id) {
        UserEntity userEntity = getUserById(id);
        log.info("Delete user. Name{}", userEntity.getName());
        userRep.delete(userEntity);
    }

    private UserEntity getUserById(Long id) {
        return userRep.findById(id).orElseThrow(()-> new EntityNotFoundException("Пользователь не найден"));
    }

    public List<UserEntity> findAll(){
        return userRep.findAll();
    }
}
