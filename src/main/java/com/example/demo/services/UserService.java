package com.example.demo.services;

import com.example.demo.entities.Organization;
import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.UserRep;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class UserService {

    UserRep clientRep;

    public void saveUser(String name, String patronymic, String surname, String birth, Organization organization){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(birth, formatter);
        int age = LocalDate.now().getYear() - date.getYear();
        UserEntity subscriber = new UserEntity(name,patronymic,surname,date,age,organization);
        clientRep.save(subscriber);
        log.info("Create new user. Name{}",name);
    }

    public void deleteUser(Long id){
        log.info("Delete user. Name{}", getById(id).getName());
        clientRep.deleteById(id);
    }

    public UserEntity getById(Long id) {
        return clientRep.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<UserEntity> findAll(){
        return clientRep.findAll();
    }
}
