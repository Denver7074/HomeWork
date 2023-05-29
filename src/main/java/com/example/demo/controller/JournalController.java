package com.example.demo.controller;

import com.example.demo.entities.document.journal.Journal;
import com.example.demo.services.JournalService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/journals")
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class JournalController {

    private JournalService journalService;

//    @GetMapping
//    @Operation(summary = "Все журналы созданные организацией")
//    public List<Journal> getAllJournals(@RequestParam Long organizationId) {
//        return journalService.findAllByOrganization(organizationId);
//    }

    @GetMapping
    @Operation(summary = "Все журналы")
    public List<Journal> getAllJournals() {
        return journalService.findAllJournal();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Поиск журнала по id")
    public Journal getJournalById(@PathVariable Long id) {
        return journalService.findJournalById(id);
    }

    @PostMapping
    @Operation(summary = "Создать новый журнал")
    public String createJournal(@RequestBody Journal journal, @RequestParam Long organizationId){
        journalService.createJournal(journal,organizationId);
        return "Журнал создан";
    }

    @PutMapping
    @Operation(summary = "Списать в архив")
    public String writeOffToTheArchive(@RequestParam Long journalId){
        journalService.writeOffToTheArchive(journalId);
        return "Журнал списан в архив";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить журнал")
    public String deleteJournal(@PathVariable Long id){
        journalService.deleteJournal(id);
        return "Журнал бесследно удален";
    }
}
