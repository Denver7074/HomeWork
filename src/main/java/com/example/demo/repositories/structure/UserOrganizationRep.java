package com.example.demo.repositories.structure;

import com.example.demo.entities.structure.UserOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrganizationRep extends JpaRepository<UserOrganization, Long> {
}
