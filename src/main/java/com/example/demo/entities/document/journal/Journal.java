package com.example.demo.entities.document.journal;


import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.CategoryDocument;
import com.example.demo.entities.Organization;
import com.example.demo.entities.document.BaseDocument;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Сущность будет наподобие Google table
 */
import java.time.LocalDate;
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Journal extends BaseDocument {


}
