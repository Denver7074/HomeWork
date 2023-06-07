package com.example.demo.entities.structure;

import jakarta.persistence.ManyToMany;
import lombok.Data;
import java.util.List;
import lombok.AccessLevel;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.experimental.FieldDefaults;
import com.example.demo.entities.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.demo.entities.room.LaboratoryFacilities;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Laboratory extends BaseEntity {

  /**
  * Город расположения лаборатории.
  */
  String city;
  /**
  * Полное наименование лаборатории.
  */
  String fullName;
  /**
  * Широта
  */
  Double latitude;
  /**
  * Долгота
  */
  Double longitude;
  /**
  * Номер записи в реестре аккредитованных лиц.
  */
  String uniqueNumber;
  /**
  * Сокращенное наименование лаборатории.
  */
  String abbreviatedName;
  Boolean deleted = Boolean.FALSE;
  @ManyToOne
  @JsonIgnore
  Organization organization;
  @OneToMany
  @JsonIgnore
  List<LaboratoryFacilities> laboratoryFacilitiesList = new ArrayList<>();
}
