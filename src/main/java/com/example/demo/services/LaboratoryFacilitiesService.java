package com.example.demo.services;

import com.example.demo.entities.structure.Organization;
import com.example.demo.entities.room.LaboratoryFacilities;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.repositories.LaboratoryFacilitiesRep;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class LaboratoryFacilitiesService {

    LaboratoryFacilitiesRep laboratoryFacilitiesRep;
    OrganizationService organizationService;

    /**
     *Тут нужно подумать если другая организация по ошибке заняла это помещение
     * Не может быть несколько лабораторий в одном помещении
     */
//    public void addNewRoom(LaboratoryFacilities room, Long organizationId){
//        if (laboratoryFacilitiesRep.existsByAddress(room.getAddress())){
//            throw new EntityAlreadyExistException("Кабинет с таким адресом уже существует");
//        }
//        Organization organization = organizationService.organizationGetById(organizationId);
//        room.setOrganization(organization);
//        room.setUsed(true);
//        laboratoryFacilitiesRep.save(room);
//    }

    /**
     *Первый раз просто помечаем, что не используем, второй раз удаляем
     */
    public void notUsedRoom(Long id){
        LaboratoryFacilities room = getById(id);
        if (room.getUsed() == true){
            laboratoryFacilitiesRep.notUsed(id);
        }
        else {
            laboratoryFacilitiesRep.delete(room);
        }
    }

    public LaboratoryFacilities getById(Long id){
        return laboratoryFacilitiesRep.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Помещение не найдено"));
    }

}
