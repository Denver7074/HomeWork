package com.example.demo.entities.structure;

import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.document.journal.Journal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Organization extends BaseEntity {

  String inn;
  String name;
  String address;
  LocalDate dateOfDeletion;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "organization")
  List<Journal> journals = new ArrayList<>();
//    @JsonIgnore
//    @ManyToMany(mappedBy = "organizations")
//    List<Equipment> equipmentList = new ArrayList<>();
//    @JsonIgnore
//    @ManyToMany(mappedBy = "organizations")
//    Set<UserEntity> userEntities = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "organization")
    List<Laboratory> laboratories = new ArrayList<>();

}
