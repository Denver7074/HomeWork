package com.example.demo.entities.document;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Сущность будет наподобие Google doc.
 */
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Document extends BaseDocument {
}
