package com.example.demo.repositories;

import com.example.demo.entities.Organization;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRep extends JpaRepository<Organization,Long> {
    Organization findByName(String name);
    boolean existsByInnOrganization(String innOrganization);
   //List<Organization> findByArea(String area);
}
