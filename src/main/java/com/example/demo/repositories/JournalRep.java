package com.example.demo.repositories;

import com.example.demo.entities.document.journal.Journal;
import com.example.demo.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRep extends JpaRepository<Journal,Long> {

   Journal findByTitleAndInTheArchiveFalse(String title);

   List<Journal> findByOrganization(Organization organization);

   @Modifying
   @Query("update Journal j set  j.inTheArchive = true where j.id = :id")
   void writeOffToTheArchive(@Param("id") Long id);

}
