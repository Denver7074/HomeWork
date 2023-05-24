package com.example.demo.controller;

import com.example.demo.entities.Journal;
import com.example.demo.entities.Organization;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.services.JournalService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/journals")
public class JournalController {

    private JournalService journalService;

    @GetMapping
    @Operation(summary = "Все журналы созданные организацией")
    public List<Journal> getAllJournals(@RequestParam Organization organization) {
        return journalService.findAll(organization);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Поиск журнала по id")
    public Journal getJournalById(@PathVariable Long id) {
        return journalService.findJournalById(id);
    }

    @PostMapping
    @Operation(summary = "Создать новый журнал")
    public void createJournal(@RequestBody Journal journal, @RequestParam Long organization_id){
        journalService.createJournal(journal,organization_id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить журнал")
    public void deleteJournal(@PathVariable Long id){
        journalService.deleteJournal(id);
    }
}
