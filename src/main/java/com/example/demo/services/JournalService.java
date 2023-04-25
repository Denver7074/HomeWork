package com.example.demo.services;

import com.example.demo.entities.Journal;
import com.example.demo.repositories.JournalRep;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class JournalService {

    JournalRep journalRep;

    public void saveJournal(String title, String description){
        Journal journal = new Journal(title,description);
        journalRep.save(journal);
    }

    public void deleteJournal(Long id){
        journalRep.deleteById(id);
    }

    public List<Journal> findAll(){
        List<Journal> journals = journalRep.findAll();
        return journals;
    }

    public Journal findJournal(Long id) {
        try {
            Journal journal = journalRep.findById(id).orElseThrow();
            return journal;
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
