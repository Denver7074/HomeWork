package com.example.demo.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class CategoryDocument extends BaseEntity {
    String name;

}
