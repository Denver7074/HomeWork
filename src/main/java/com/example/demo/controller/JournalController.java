package com.example.demo.controller;

import com.example.demo.entities.Journal;
import com.example.demo.services.JournalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/journals")
public class JournalController {

    JournalService journalService;

    @GetMapping("/")
    public List<Journal> getAllJournals() {
        return journalService.findAll();
    }

    @GetMapping("/{id}")
    public Journal getJournalById(@PathVariable Long id) {
        return journalService.findJournal(id);
    }

    @PostMapping("/")
    public void createJournal(@RequestBody String title, @RequestBody String description){
        journalService.saveJournal(title,description);
    }

    @DeleteMapping("/{id}")
    public void deleteJournal(@PathVariable Long id){
        journalService.deleteJournal(id);
    }
}
