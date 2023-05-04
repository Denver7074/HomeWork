package com.example.demo.repositories;

import com.example.demo.entities.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRep extends JpaRepository<Journal,Long> {

   Journal findByTitle(String title);

   @Query("select j from Journal j where j.client.id = :id")
   List<Journal> findByUser(@Param("id") Long id);

}
