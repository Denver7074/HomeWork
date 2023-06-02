package com.example.demo.entities.document;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Форма заявки для обращения заказчика.
 */

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationForm extends BaseEntity {

  String nameObject;
  String addressObject;
  String emailCustomer;
  String innCustomer;

}
