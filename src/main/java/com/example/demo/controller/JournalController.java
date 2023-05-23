package com.example.demo.controller;

import com.example.demo.entities.Journal;
import com.example.demo.entities.Organization;
import com.example.demo.services.JournalService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping("journal/")
    @Operation(summary = "Все журналы созданные организацией")
    public List<Journal> getAllJournals(@PathVariable Organization organization) {return journalService.findAll(organization);}

    @GetMapping("journal/{id}")
    @Operation(summary = "Поиск журнала по id")
    public Journal getJournalById(@PathVariable Long id) {
        return journalService.findJournal(id);
    }

    @PostMapping("journal/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Создать новый журнал")
    public void createJournal(@RequestBody Journal journal){journalService.saveJournal(journal);}

    @DeleteMapping("journal/{id}")
    @Operation(summary = "Удалить журнал")
    public void deleteJournal(@PathVariable Long id){
        journalService.deleteJournal(id);
    }
}
