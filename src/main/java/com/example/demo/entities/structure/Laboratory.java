package com.example.demo.entities.structure;


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
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;


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

  Point position;

  @ManyToOne
  @JsonIgnore
  Organization organization;
  @OneToMany
  @JsonIgnore
  List<LaboratoryFacilities> laboratoryFacilitiesList = new ArrayList<>();

  @Override
  public String toString() {
    return "Laboratory{" +
            "city='" + city + '\'' +
            ", fullName='" + fullName + '\'' +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            ", uniqueNumber='" + uniqueNumber + '\'' +
            ", abbreviatedName='" + abbreviatedName + '\'' +
            ", deleted=" + deleted +
            ", position=" + position +
            '}';
  }
}
