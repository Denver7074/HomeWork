package com.example.demo.repositories;

import com.example.demo.entities.equipment.type.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRep extends JpaRepository<Equipment,String> {

    boolean existsByMitNumberAndNumber(String mitNumber, String Number);
}
