package com.example.demo.entities;

import com.example.demo.entities.enums.Duties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserOrganization extends BaseEntity{

    @ElementCollection(targetClass = Duties.class)
    @CollectionTable(name = "user_organization_duties", joinColumns = @JoinColumn(name = "user_organization_id"))
    @Column(name = "duties")
    @Enumerated(EnumType.STRING)
    Set<Duties> duties;
    Boolean dismissed;
    @ManyToOne
    Organization organization;
    @ManyToOne
    UserEntity userEntity;
}
