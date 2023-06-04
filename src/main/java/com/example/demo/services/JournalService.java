package com.example.demo.services;


import com.example.demo.entities.document.journal.Journal;
import com.example.demo.entities.structure.Organization;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.repositories.JournalRep;
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
    OrganizationService organizationService;

    public void createJournal(Journal journal, Long organizationId) {
        if (findAllByOrganization(organizationId).contains(journal)){
            throw new EntityAlreadyExistException("Документ с таким названием уже существует");
        }
        Organization organization = organizationService.organizationGetById(organizationId);
        journal.setOrganization(organization);
        journalRep.save(journal);
        log.info("Create new journal. Journal{}", journal.getTitle());
    }

    /**
     * 1. Проверяем не списан ли журнал в архив уже, если нет, то перемещаем в архив.
     * 2. При повторном удалении уже в архиве (отправляется запрос руководителю на подтверждение удаления)
     * и только после подтверждения руководителя бесследно удалиться (защита от дураков).
     * @param id - индивидуальный идентификатор журнала
     */
    public void deleteJournal(Long id){
        Journal journalById = findJournalById(id);
        if (journalById.getDateWriteOffInTheArchive() == null){
            journalRep.writeOffToTheArchive(id);
            log.info("The journal has been moved to the archive.Journal{} ",journalById.getTitle());
        }
        else {
            journalRep.completeRemoval(id);
            log.info("Delete journal. Journal{} ", journalById.getTitle());
        }
    }

    public List<Journal> findAllByOrganization(Long organizationId){
        Organization organization = organizationService.organizationGetById(organizationId);
        return journalRep.findByOrganization(organization);
    }

    public Journal findJournalById(Long id){
        log.info("Find journal by id. id{} ",id);
        return journalRep.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Документа с таким id не существует"));
    }

    public List<Journal> findAllJournal(){
        return journalRep.findAll();
    }
}
