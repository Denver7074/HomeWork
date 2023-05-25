package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Organization extends BaseEntity{

    String name;
 //   String area;
//    String workDescription;
//    String accreditationNumber;
//    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "organization")
//    List<Journal> journals = new ArrayList<>();
//    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "organization")
//    List<Equipment> equipmentList = new ArrayList<>();
    @ManyToMany(mappedBy = "organizations")
    List<UserEntity> users = new ArrayList<>();

}
