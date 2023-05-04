package com.example.demo.controller;

import com.example.demo.entities.Journal;
import com.example.demo.services.JournalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/journals")
@Tag(name = "Журналы",description = "Работа с журналами")
public class JournalController {

    JournalService journalService;

    @GetMapping("/")
    @Operation(description = "Показать весь список журналов")
    public List<Journal> getAllJournals() {
        return journalService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(description = "Поиск журналов по его идентификатору")
    public Journal getJournalById(@PathVariable Long id) {
        return journalService.findJournal(id);
    }

    @PostMapping("/")
    @Operation(description = "Создать новый журнал")
    public void createJournal(@RequestBody String title, @RequestBody String description){
        journalService.saveJournal(title,description);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Удалить журнал")
    public void deleteJournal(@PathVariable Long id){
        journalService.deleteJournal(id);
    }
}
