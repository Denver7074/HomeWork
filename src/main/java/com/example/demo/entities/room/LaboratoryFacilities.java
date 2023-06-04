package com.example.demo.entities.room;

import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.structure.Laboratory;
import com.example.demo.entities.structure.Organization;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 26.14. сведения о помещениях, используемых для проведения исследований (испытаний) и измерений, подтверждающие соответствие лаборатории критериям аккредитации:
 * назначение помещения (в том числе виды проводимых испытаний, для приемки и хранения образцов, обработки результатов испытаний, хранения документации или другое);
 * специальное или приспособленное;
 * место нахождения или иная уникальная идентификация;
 * площадь;
 * перечень контролируемых параметров в помещении;
 * наличие специального оборудования (например, вентиляционного, защиты от помех);
 * право собственности или иное законное основание, предусматривающее право владения и пользования (реквизиты подтверждающих документов).
 */
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LaboratoryFacilities extends BaseEntity {

  /**
  * Площадь помещения.
  */
  Long square;
  /**
  * Используетя помещение или нет?
  */
  boolean used;
  /**
  * Адрес помещения.
  * Поле "address" должно содержать адрес вплоть до номера кабинета.
  */
  String address;
//    String ownership;
//    @Enumerated(EnumType.STRING)
//    Appointment appointment;
//    String indoorConditions;
//    String specialEquipment;
//    String purposeOfTheRoom;
  @ManyToOne()
  Laboratory laboratory;
}
