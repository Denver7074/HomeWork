package com.example.demo.services.equipment;

import com.example.demo.entities.equipment.type.Equipment;
import com.example.demo.repositories.EquipmentRep;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class EquipmentService {

    EquipmentRep equipmentRep;
    EquipmentApiService equipmentApiService;

    public Equipment getEquipmentByFGIS(String mitNumber,String number){
        return getAllHistoryAboutEquipment(mitNumber, number).get(0);
    }

    public List<Equipment> getAllHistoryAboutEquipment(String mitNumber,String number){
        List<Equipment> equipmentList = equipmentApiService.api(mitNumber, number);
        if (equipmentList.isEmpty()){
            throw new EntityNotFoundException("Прибор не найден. Проверьте введенные данные.");
        }
        return equipmentList;
    }

    /**
     * Нужно потом привязать к организации
     * @param mitNumber - номер в реестре СИ
     * @param number - заводской номер
     */
    public void createEquipment(String mitNumber,String number){
        Equipment equipment = getAllHistoryAboutEquipment(mitNumber, number).get(0);
        if (!equipmentRep.existsByMitNumberAndNumber(mitNumber,number)){
            equipmentRep.save(equipment);
        }
    }
}
