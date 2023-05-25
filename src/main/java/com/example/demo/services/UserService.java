package com.example.demo.services;

import com.example.demo.entities.Organization;
import com.example.demo.entities.UserEntity;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.repositories.OrganizationRep;
import com.example.demo.repositories.UserRep;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class UserService {
    UserRep userRep;
    OrganizationRep organizationRep;

    public void createUser(UserEntity userEntity, Long organizationId){
        Organization organization = organizationRep.findById(organizationId)
                .orElseThrow(()->new EntityNotFoundException("Такой организации не существует"));
        userEntity.setOrganization(organization);
        userRep.save(userEntity);
    }
    public void deleteUser(Long id) {
        UserEntity userEntity = getUserById(id);
        log.info("Delete user. Name{}", userEntity.getUserName());
        userRep.delete(userEntity);
    }

    public UserEntity getUserById(Long id) {
        return userRep.findById(id).orElseThrow(()-> new EntityNotFoundException("Пользователь не найден"));
    }

    public List<UserEntity> findAll(){
        return userRep.findAll();
    }
}
