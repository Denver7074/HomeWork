package com.example.demo.repositories;

import com.example.demo.entities.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRep extends JpaRepository<Journal,Long> {

   Journal findByTitle(String title);


}
