package com.example.demo.controller;

import com.example.demo.entities.Organization;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.services.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organization")
public class OrganizationController {

    OrganizationService organizationService;

    @GetMapping
    @Operation(summary = "Поиск организации по id")
    public Organization getById(@PathVariable Long id) {
        return organizationService.organizationGetById(id);
    }

    @PostMapping
    @Operation(summary = "Регистрация новой организации")
    public void createJournal(@RequestBody Organization organization){
        organizationService.saveOrganization(organization);
    }

}
