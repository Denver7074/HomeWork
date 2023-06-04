package com.example.demo.repositories.structure;

import com.example.demo.entities.structure.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRep extends JpaRepository<Organization,Long> {
    Organization findByName(String name);
    boolean existsByInn(String innOrganization);
    @Modifying
    @Query("update Organization o set o.dateOfDeletion = current_date where o.id = :id")
    void softRemoval(@Param("id") Long id);

}
