package com.example.demo.repositories;

import com.example.demo.entities.room.LaboratoryFacilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryFacilitiesRep extends JpaRepository<LaboratoryFacilities,Long> {

    boolean existsByAddress(String address);

    @Modifying
    @Query("update LaboratoryFacilities r set r.used = false where r.id = :id")
    void notUsed(@Param("id") Long id);
}
