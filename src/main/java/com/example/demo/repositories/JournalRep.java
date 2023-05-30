package com.example.demo.repositories;

import com.example.demo.entities.document.journal.Journal;
import com.example.demo.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JournalRep extends JpaRepository<Journal,Long> {

   List<Journal> findByOrganization(Organization organization);

   @Modifying
   @Query("update Journal j set j.dateWriteOffInTheArchive = current_date where j.id = :id")
   void writeOffToTheArchive(@Param("id") Long id);
   @Modifying
   @Query("update Journal j set j.dateCompleteRemoval = current_date where j.id = :id")
   void completeRemoval(@Param("id") Long id);
}
