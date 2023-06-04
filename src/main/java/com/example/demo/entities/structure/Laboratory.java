package com.example.demo.entities.structure;

import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.room.LaboratoryFacilities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

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
  * Номер записи в реестре аккредитованных лиц.
  */
  String uniqueNumber;
  /**
  * Сокращенное наименование лаборатории.
  */
  double longitude;
  double latitude;
  //String abbreviatedName;
  boolean deleted;
  @ManyToOne
  @JsonIgnore
  Organization organization;
  @OneToMany
  @JsonIgnore
  List<LaboratoryFacilities> laboratoryFacilitiesList = new ArrayList<>();

}
