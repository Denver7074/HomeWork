package com.example.demo.entities.structure;

import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.enums.Duties;
import com.example.demo.entities.structure.Organization;
import com.example.demo.entities.structure.UserEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserOrganization extends BaseEntity {

    Boolean dismissed;
    @ElementCollection(targetClass = Duties.class)
    @Enumerated(EnumType.STRING)
    Set<Duties> duties;
    @ManyToOne
    UserEntity userEntity;
    @ManyToOne
    Organization organization;

}
