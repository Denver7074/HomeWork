package com.example.demo.services;

import com.example.demo.entities.structure.Laboratory;
import com.example.demo.entities.structure.Organization;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.repositories.structure.LaboratoryRep;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LaboratoryService {

  LaboratoryRep laboratoryRep;
  OrganizationService organizationService;
  GeoCoordinateService geoCoordinateService;


  @SneakyThrows
  public void addNewLaboratory(Laboratory laboratory) {
//    if (laboratoryRep.findFirst(laboratory.getUniqueNumber())) {
//      throw new EntityAlreadyExistException("Лаборатория уже существует");
//    } else {
//      Organization organization = organizationService.organizationGetById(organizationId);
//      laboratory.setOrganization(organization);
      List<Double> geoCoordinate = geoCoordinateService.findGeoCoordinate(laboratory.getCity());
      laboratory.setLatitude(geoCoordinate.get(0));
      laboratory.setLongitude(geoCoordinate.get(1));
      GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
      laboratory.setPosition(geometryFactory.createPoint(new Coordinate(geoCoordinate.get(1), geoCoordinate.get(0))));
      laboratoryRep.save(laboratory);
      log.info("Create new laboratory. Name {}", laboratory.getFullName());
   // }
  }

  public List<Laboratory> getAllLaboratory() {
    return laboratoryRep.findAll();
  }

  public Laboratory getById(Long id) {
    return laboratoryRep.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Лаборатория не найдена"));
  }

  public void softDeleteLaboratory(Long id) {
    Laboratory laboratory = getById(id);
    if (!laboratory.getDeleted()) {
      laboratory.setDeleted(true);
      laboratoryRep.save(laboratory);
    } else {
      laboratoryRep.delete(laboratory);
    }
  }

  public void updateLaboratory(Laboratory newLab, Long id) throws IOException, InterruptedException {
    List<Double> geoCoordinate = geoCoordinateService.findGeoCoordinate(newLab.getCity());
    laboratoryRep.updateLaboratory(newLab.getFullName(), newLab.getUniqueNumber(),
             newLab.getCity(), geoCoordinate.get(0), geoCoordinate.get(1), id);
  }

  /**
  * Поиск ближайших лабораторий.
  * Сначала проверяем есть ли в этом же городе лаборатории.
  * Потом проверяем в радиусе заданном пользователем.
  */
  @SneakyThrows
  public Laboratory nearestLaboratory(String cityCustomer) {
//    if (laboratoryRep.existsByCity(cityCustomer)) {
//      return laboratoryRep.findLaboratoriesByCity(cityCustomer);
//    }
    return geoCoordinateService.distanceCalculation(cityCustomer, getAllLaboratory());
  }

}
