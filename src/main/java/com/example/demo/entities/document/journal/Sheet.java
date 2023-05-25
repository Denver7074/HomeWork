package com.example.demo.entities.document.journal;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sheet extends BaseEntity {


}
