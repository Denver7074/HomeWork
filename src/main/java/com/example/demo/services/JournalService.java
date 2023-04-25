package com.example.demo.services;

import com.example.demo.entities.Journal;
import com.example.demo.repositories.JournalRep;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

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
        log.info("Create new journal. Journal{}", title);

    }

    public void deleteJournal(Long id){
        journalRep.deleteById(id);
        String title = journalRep.findById(id).orElseThrow().getTitle();
        log.info("Delete journal. Journal{}", title);
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
