package com.example.demo.controller;

import com.example.demo.entities.Organization;
import com.example.demo.services.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class OrganizationController {

    OrganizationService organizationService;

    @GetMapping("/{id}")
    @Operation(summary = "Поиск организации по id")
    public Organization getById(@PathVariable Long id) {
        return organizationService.organizationGetById(id);
    }

    @PostMapping
    @Operation(summary = "Регистрация новой организации")
    public String createJournal(@RequestBody Organization organization){
        organizationService.createOrganization(organization);
        return "Организация зарегистрирована";
    }

    @GetMapping
    @Operation(summary = "Все организации")
    public List<Organization> findAll() {
        return organizationService.findAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить организацию")
    public String deleteOrganization(@PathVariable Long id){
        organizationService.deleteOrganization(id);
        return "Организация удалена";
    }

}
