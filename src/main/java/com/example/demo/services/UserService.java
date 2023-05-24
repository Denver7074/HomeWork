package com.example.demo.services;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entities.UserEntity;
import com.example.demo.exception.EntityNotFound;
import com.example.demo.repositories.UserRep;
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

    UserRep clientRep;

//    public void saveUser(String name, String patronymic, String surname, String birth, Organization organization){
//        UserEntity subscriber = new UserEntity(name,patronymic,surname,date,age,organization);
//        clientRep.save(subscriber);
//        log.info("Create new user. Name{}",name);
//    }

    public void deleteUser(Long id) throws EntityNotFound {
        UserEntity userEntity = findUserEntityById(id);
        log.info("Delete user. Name{}", userEntity.getName());
        clientRep.delete(userEntity);
    }

    public UserDTO userDTOGetById(Long id) throws EntityNotFound {
        UserEntity userEntity = findUserEntityById(id);
        return UserDTO.userDTO(userEntity);
    }

    private UserEntity findUserEntityById(Long id) throws EntityNotFound {
        UserEntity userEntity = clientRep.findById(id).get();
        if (userEntity == null){
            throw new EntityNotFound("Пользователь не найден");
        }
        return userEntity;
    }

    public List<UserEntity> findAll(){
        return clientRep.findAll();
    }
}
