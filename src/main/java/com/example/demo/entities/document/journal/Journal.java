package com.example.demo.entities.document.journal;


import com.example.demo.entities.document.BaseDocument;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Сущность будет наподобие Google table
 */

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Journal extends BaseDocument {


}
