package com.example.demo.services;

import com.example.demo.entities.Organization;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.exception.EntityNotFound;
import com.example.demo.repositories.OrganizationRep;
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
public class OrganizationService {

    OrganizationRep organizationRep;

    public Organization organizationGetById(Long id) throws EntityNotFound {
        Organization organization = organizationRep.findById(id).get();
        if (organization == null){
            throw new EntityNotFound("Организация с таким id не найдена");
        }
        return organization;
    }

    public void saveOrganization(Organization organization) throws EntityAlreadyExistException {
        if (organizationRep.findByName(organization.getName()) != null){
            throw new EntityAlreadyExistException("Такая компания уже существует");
        }
        organizationRep.save(organization);
        log.info("Create new organization. Organization{}", organization.getName());
    }

    public void deleteOrganization(Long id) throws EntityNotFound {
        Organization organization = organizationGetById(id);
        organizationRep.delete(organization);
        log.info("Delete organization. Name{}", organization.getName());
    }

    public List<Organization> findByArea(String area){
        return organizationRep.findByArea(area);
    }

}
