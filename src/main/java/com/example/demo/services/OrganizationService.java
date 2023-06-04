package com.example.demo.services;

import com.example.demo.entities.structure.Organization;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.repositories.structure.OrganizationRep;
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
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrganizationService {

  OrganizationRep organizationRep;

  /**
  * Организация может быть только одна.
  * Лабораторий на базе данной организации может быть много.
  */
  public void createNewOrganization(Organization organization) {
    if (organizationRep.existsByInn(organization.getInn())) {
      throw new EntityAlreadyExistException("Такая компания уже существует");
    }
    organizationRep.save(organization);
    log.info("Create new organization. Organization{}", organization.getName());
  }

  public Organization organizationGetById(Long id) {
    return organizationRep.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Организация не найдена"));
  }

  public void deleteOrganization(Long id) {
    Organization organization = organizationGetById(id);
    String name = organization.getName();
    if (organization.getDateOfDeletion() == null) {
      organizationRep.softRemoval(id);
      log.info("Soft delete organization. Name{} ", name);
    } else {
      organizationRep.delete(organization);
      log.info("Delete organization. Name{}", name);
    }
  }

  public List<Organization> findAll() {
    return organizationRep.findAll();
  }

   // public List<Organization> findByArea(String area){
//        return organizationRep.findByArea(area);
//    }

}
