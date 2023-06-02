package com.example.demo.entities.equipment.type;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
/**
 * Согласно ГОСТ 17025-2019
 * 6.4.13 Должны вестись записи о состоянии оборудования, которое может повлиять на лабораторную деятельность.
 * Записи должны включать следующее, когда это применимо:
 * a) идентификацию оборудования, включая версию программного обеспечения, в том числе
 * встроенного:
 * b) наименование изготовителя, идентификацию типа, серийный номер или другую уникальную
 * идентификацию;
 * c) данные верификации о том. что оборудование соответствует установленным требованиям;
 * d) текущее местонахождение;
 * e) даты и результаты калибровок, регулировок, критерии приемки и планируемую дату следующей калибровки
 * или межкалибровочный интервал;
 * 0 документацию на стандартные образцы, результаты, критерии приемки, соответствующие даты
 * и сроки годности;
 * д) план технического обслуживания и техническое обслуживание, выполненное к настоящему
 * моменту времени, если это требуется для работы оборудования;
 * h) подробную информацию о любых повреждениях, неисправностях, модификациях или ремонте
 * оборудования.
 */
@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEquipment {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;
        String ownership;
        String nameEquipment;
        String installationLocation;

}
