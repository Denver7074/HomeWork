package com.example.demo.entities.equipment;

import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.structure.Organization;
import com.example.demo.entities.enums.EquipmentStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EquipmentOrganization extends BaseEntity {

    @ElementCollection(targetClass = EquipmentStatus.class)
    @Enumerated(EnumType.STRING)
    Set<EquipmentStatus> equipmentStatuses;
    @ManyToOne
    Organization organization;


}
