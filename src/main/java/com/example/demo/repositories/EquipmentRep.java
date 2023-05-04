package com.example.demo.repositories;

import com.example.demo.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRep extends JpaRepository<Equipment,String> {

}
