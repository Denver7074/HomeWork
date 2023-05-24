package com.example.demo.controller;

import com.example.demo.entities.Journal;
import com.example.demo.entities.Organization;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.exception.EntityNotFound;
import com.example.demo.services.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
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
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(organizationService.organizationGetById(id));
        }
        catch (EntityNotFound e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    @Operation(summary = "Регистрация новой организации")
    public ResponseEntity<String> createJournal(@RequestBody Organization organization){
        try {
            organizationService.saveOrganization(organization);
            return ResponseEntity.ok("Организация зарегистрирована");
        } catch (EntityAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
