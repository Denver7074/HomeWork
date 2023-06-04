package com.example.demo.controller;

import com.example.demo.entities.room.LaboratoryFacilities;
import com.example.demo.services.LaboratoryFacilitiesService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class LaboratoryFacilitiesController {

    LaboratoryFacilitiesService laboratoryFacilitiesService;

//    @PostMapping
//    @Operation(summary = "Добавить новое помещение")
//    public void addNewRoom(@RequestBody LaboratoryFacilities room, @RequestParam Long organizationId){
//        laboratoryFacilitiesService.addNewRoom(room,organizationId);
//    }
}
