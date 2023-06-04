package com.example.demo.entities.equipment.type;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 26.12. сведения об оснащенности вспомогательным оборудованием,
 * подтверждающие соответствие лаборатории критериям аккредитации:
 * наименование;
 * изготовитель (страна, наименование организации, год выпуска);
 * год ввода в эксплуатацию, заводской номер (при наличии),
 * инвентарный номер или другая уникальная идентификация;
 * назначение;
 * место установки или хранения;
 * право собственности либо иное законное основание,
 * предусматривающее право владения и пользования (реквизиты подтверждающих документов).
 */

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuxiliaryEquipment extends BaseEquipment {

}
