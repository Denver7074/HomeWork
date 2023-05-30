package com.example.demo.controller;

import com.example.demo.entities.equipment.type.Equipment;
import com.example.demo.services.equipment.EquipmentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

/**
 * @param mitNumber - номер прибора в реестре СИ
 * @param number - заводской номер
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/equipments")
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class EquipmentController {

    EquipmentService equipmentService;

    /**
     * Сначала мы ищем прибор во ФГИС Аршин, если прибор найдет тот что нужен,
     * то переходим к кнопке добавить @PostMapping("/findInFGIS")
     * если нет, то повторяем поиск
     */
    @GetMapping("/findInFGIS")
    @Operation(summary = "Найти прибор во ФГИС Аршин")
    public Equipment getByMitNumberAndNumber(@RequestParam String mitNumber,@RequestParam String number){
        return equipmentService.getEquipmentByFGIS(mitNumber, number);
    }

    /**
     * Добавить в свою БД этот прибор
     */
    @PostMapping("/findInFGIS")
    @Operation(summary = "Найти прибор во ФГИС Аршин")
    public void saveEquipment(@RequestParam String mitNumber,@RequestParam String number){
        equipmentService.createEquipment(mitNumber, number);
    }
}
