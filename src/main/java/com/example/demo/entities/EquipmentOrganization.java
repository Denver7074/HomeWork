package com.example.demo.entities;

import com.example.demo.entities.enums.Duties;
import com.example.demo.entities.enums.EquipmentStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EquipmentOrganization extends BaseEntity{

    @ElementCollection(targetClass = EquipmentStatus.class)
    @CollectionTable(name = "equipment_organization_status", joinColumns = @JoinColumn(name = "equipment_organization_id"))
    @Column(name = "equipmentStatus")
    @Enumerated(EnumType.STRING)
    Set<EquipmentStatus> equipmentStatuses;
    @ManyToOne
    Organization organization;
    @ManyToOne
    Equipment equipment;

}
