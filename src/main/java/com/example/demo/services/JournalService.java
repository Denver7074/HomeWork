package com.example.demo.services;

import com.example.demo.entities.Journal;
import com.example.demo.repositories.JournalRep;
import io.swagger.v3.oas.annotations.tags.Tag;
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
        String title = journalRep.findById(id).orElseThrow().getTitle();
        log.info("Delete journal. Journal{}", title);
        journalRep.deleteById(id);
    }

    public List<Journal> findAll(){
        List<Journal> journals = journalRep.findAll();
        return journals;
    }

    public Journal findJournal(Long id) {
        return journalRep.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}
