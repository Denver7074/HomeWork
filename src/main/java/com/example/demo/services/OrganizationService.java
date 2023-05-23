package com.example.demo.services;

import com.example.demo.entities.Organization;
import com.example.demo.repositories.OrganizationRep;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class OrganizationService {

    OrganizationRep organizationRep;

    public Organization getById(Long id) {
        return organizationRep.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void saveOrganization(String name){
        Organization organization = new Organization();
        organizationRep.save(organization);
        log.info("Create new organization. Organization{}", name);
    }

    public void deleteOrganization(Long id){
        log.info("Delete organization. Name{}", getById(id).getName());
        organizationRep.deleteById(id);
    }

    public List<Organization> findAll(String area){
        if (organizationRep.findByArea(area) == null) {
            return organizationRep.findAll();
        }
        return organizationRep.findByArea(area);
    }

}
