package com.example.demo.entities.structure;


import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.structure.Organization;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

/**
 * Приказ 707:
 * 26.9. сведения о работниках, подтверждающие соответствие лаборатории критериям аккредитации:
 * фамилия, имя, отчество (при наличии), страховой номер индивидуального лицевого счета, дата и место рождения;
 * основание для привлечения личного труда (трудовой договор, гражданско-правовой договор или иное), работа по основному месту работы или по совместительству;
 * выполняемые функции, проводимые исследования, испытания, измерения;
 * образование (наименование учебного заведения, год окончания, квалификация по документу об образовании, реквизиты документа об образовании);
 * практический опыт по исследованиям, испытаниям, измерениям, включенным в область аккредитации (в годах, с указанием, в каких организациях, в какой период и по каким видам исследований (испытаний) измерений получен).
 */

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserEntity extends BaseEntity {
  /**
  * ИНН пользователя
  */
  @NotBlank
  String inn;
//    String SNILS;
  /**
  * Имя пользователя
  */
  String userName;
//    Integer age;
//    String surname;
//    @Getter(AccessLevel.NONE)
//    String password;
//    LocalDate birth;
//    String patronymic;
//    LocalDate createDate = LocalDate.now();
//  @ManyToMany(mappedBy = "userEntities")
//  Set<Organization> organizations= new HashSet<>();



}
