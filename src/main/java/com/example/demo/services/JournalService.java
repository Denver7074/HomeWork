package com.example.demo.services;

import com.example.demo.entities.Journal;
import com.example.demo.entities.Organization;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.repositories.JournalRep;
import com.example.demo.repositories.OrganizationRep;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class JournalService {

    JournalRep journalRep;
    OrganizationRep organizationRep;

    public void createJournal(Journal journal,Long id) throws EntityAlreadyExistException {
        String title = journal.getTitle();
        if (journalRep.findByTitleAndInTheArchiveFalse(title) != null ){
            throw new EntityAlreadyExistException("Документ с таким названием уже существует");
        }
        Organization organization = organizationRep.findById(id).get();
        journal.setOrganization(organization);
        journalRep.save(journal);
        log.info("Create new journal. Journal{}", title);
    }

    public void deleteJournal(Long id) {
        Journal journalById = findJournalById(id);
        log.info("Delete journal. Journal{}", journalById.getTitle());
        journalRep.delete(journalById);
    }

    public List<Journal> findAll(Organization organization){
        return journalRep.findByOrganization(organization);
    }

    public Journal findJournalById(Long id){
        return journalRep.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Документа с таким id не существует"));
    }
}
