package com.example.demo.services;

import com.example.demo.entities.Journal;
import com.example.demo.entities.Organization;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.repositories.JournalRep;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;


@Slf4j
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class JournalService {

    JournalRep journalRep;

    public void saveJournal(Journal journal) throws EntityAlreadyExistException {
        if (journalRep.findByTitle(journal.getTitle()) != null){
            throw new EntityAlreadyExistException("Документ с таким названием уже существует");
        }
        journalRep.save(journal);
        log.info("Create new journal. Journal{}", journal.getTitle());
    }

    public void deleteJournal(Long id){
        String title = journalRep.findById(id).orElseThrow().getTitle();
        log.info("Delete journal. Journal{}", title);
        journalRep.deleteById(id);
    }

    public List<Journal> findAll(Organization organization){
        return journalRep.findByOrganization(organization);
    }

    public Journal findJournal(Long id) {
        return journalRep.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}
