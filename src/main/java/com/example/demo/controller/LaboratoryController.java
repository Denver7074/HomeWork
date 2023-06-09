package com.example.demo.controller;

import com.example.demo.entities.structure.Laboratory;
import com.example.demo.services.LaboratoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/laboratories")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LaboratoryController {

  LaboratoryService laboratoryService;

  @PostMapping
  @SneakyThrows
  @Operation(summary = "Добавить лабораторию")
  public void addNewLaboratory(@RequestBody Laboratory laboratory) {
    laboratoryService.addNewLaboratory(laboratory);
  }

  @GetMapping
  @Operation(summary = "Посмотреть все лаборатории")
  public String getAllLaboratory() {
    return laboratoryService.getAllLaboratory().toString();
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Удалить лабораторию")
  public void deleteLaboratory(@PathVariable Long id) {
    laboratoryService.softDeleteLaboratory(id);
  }

  @SneakyThrows
  @PutMapping("/{id}")
  @Operation(summary = "Изменить данные лаборатории")
  public void updateLaboratory(@RequestBody Laboratory newLab, @PathVariable Long id) {
    laboratoryService.updateLaboratory(newLab, id);
  }

  @GetMapping("/search")
  @Operation(summary = "Поиск ближайших лабораторий")
  public String findLaboratory(@RequestParam String city) {
    return laboratoryService.nearestLaboratory(city).toString();
  }
}
