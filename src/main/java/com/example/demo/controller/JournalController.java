package com.example.demo.controller;

import com.example.demo.entities.Journal;
import com.example.demo.entities.Organization;
import com.example.demo.exception.EntityAlreadyExistException;
import com.example.demo.services.JournalService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> getAllJournals(@RequestParam Organization organization) {
        try {
            return ResponseEntity.ok(journalService.findAll(organization));
        }
        catch (Exception e){
          return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Поиск журнала по id")
    public ResponseEntity<?> getJournalById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(journalService.findJournal(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    @Operation(summary = "Создать новый журнал")
    public ResponseEntity<String> createJournal(@RequestBody Journal journal){
        try {
            journalService.saveJournal(journal);
            return ResponseEntity.ok("Документ создан");
        } catch (EntityAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить журнал")
    public ResponseEntity<String> deleteJournal(@PathVariable Long id){
        try {
            journalService.deleteJournal(id);
            return ResponseEntity.ok("Журнал удален");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
