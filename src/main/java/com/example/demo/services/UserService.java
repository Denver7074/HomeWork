package com.example.demo.services;

import com.example.demo.entities.Organization;
import com.example.demo.entities.UserEntity;
import com.example.demo.exception.InvalidData;
import com.example.demo.repositories.UserRep;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class UserService {
    UserRep userRep;
    OrganizationService organizationService;

//    public void createUser(UserEntity userEntity, Long organizationId){
//        Organization organization = organizationService.organizationGetById(organizationId);
//        String inn = userEntity.getInn().trim();
//        if (inn.length() != 12){
//            throw new InvalidData("Индивидуальный налоговый номер введен некорректно");
//        }
//        UserEntity user = userRep.findByInn(inn);
//        if (user != null){
//            List<Organization> organizations = user.getOrganizations();
//            if (organizations.indexOf(organization) == -1){
//                organizations.add(organization);
//                user.setOrganizations(organizations);
//                userRep.save(user);
//                log.info("Accepted a new job. Name{}; Organization{} ",user.getUserName(), organization.getName());
//            }
//        }
//        else {
//            userEntity.setOrganizations(List.of(organization));
//            userRep.save(userEntity);
//            log.info("Create new user. Name{} ",userEntity.getUserName());
//        }

//    }
    public void deleteUser(Long id) {
        UserEntity userEntity = getUserById(id);
        log.info("Dismissed user. Name{}", userEntity.getUserName());
        userRep.delete(userEntity);
    }

    public UserEntity getUserById(Long id) {
        log.info("Find user by id. Id{} ", id);
        return userRep.findById(id).orElseThrow(()-> new EntityNotFoundException("Пользователь не найден"));
    }

    public List<UserEntity> findAll(){
        return userRep.findAll();
    }
}
