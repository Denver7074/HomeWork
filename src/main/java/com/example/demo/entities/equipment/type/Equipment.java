package com.example.demo.entities.equipment.type;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Приказ 707:
 * 26.10. сведения об оснащенности средствами измерений (СИ), подтверждающие соответствие
 * лаборатории критериям аккредитации:
 * наименование определяемых (измеряемых) характеристик (параметров) продукции;
 * наименование СИ, тип (марка), регистрационный номер;
 * в Федеральном информационном фонде по обеспечению единства измерений (при наличии);
 * изготовитель (страна, наименование организации, год выпуска);
 * год ввода в эксплуатацию, заводской номер (при наличии), инвентарный номер или другая уникальная идентификация;
 * метрологические характеристики:
 * диапазон измерений;
 * класс точности (разряд), погрешность и (или) неопределенность (класс, разряд);
 * сведения о результатах поверки СИ
 * в Федеральном информационном фонде по обеспечению единства измерений (номер, дата, срок действия)
 * и (или) сертификат о калибровке СИ (номер, дата, срок действия (при наличии)
 * в соответствии с требованиями законодательства Российской Федерации в области обеспечения единства измерений;
 * право собственности или иное законное основание, предусматривающее право владения
 * и пользования (реквизиты подтверждающих документов);
 * место установки или хранения.
 */

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipment extends BaseEquipment {


    @JsonAlias("vri_id")
    //Номер записи о поверке во ФГИС аршин
    String idVerification;
    @JsonAlias("mi.mitnumber")
    //Номер в реестре СИ
    String mitNumber;
    @JsonAlias("mi.number")
    //Заводской номер
    String number;
    @JsonAlias("valid_date")
    //Дата окончания поверки
    LocalDate validDate;
    @JsonAlias("verification_date")
    //Дата поверки
    LocalDate verificationDate;
    @JsonAlias("mi.modification")
    //Название оборудования -> Нужно корректировать пользователем
    String miType;
    //Результат поверки Да(true)/Нет(false)
    Boolean applicability;

    @Override
    public String toString() {
        return "Equipment{" +
                "idVerification='" + idVerification + '\'' +
                ", mitNumber='" + mitNumber + '\'' +
                ", number='" + number + '\'' +
                ", validDate=" + validDate +
                ", verificationDate=" + verificationDate +
                ", applicability=" + applicability +
                '}';
    }

    @Override
    public String getNameEquipment() {
        return miType;
    }

//    @ManyToMany
//    List<Organization> organizations = new ArrayList<>();

}
