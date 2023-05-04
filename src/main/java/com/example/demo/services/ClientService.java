package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.entities.Journal;
import com.example.demo.repositories.ClientRep;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class ClientService {

    ClientRep clientRep;

    public void saveJournal(String name, String patronymic, String surname, String birth){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(birth, formatter);
        Client client = new Client(name,patronymic,surname,date);
        clientRep.save(client);
        log.info("Create new user. Name{}",name);
    }

    public void deleteClient(Long id){
        log.info("Delete journal. Name{}", getById(id).getName());
        clientRep.deleteById(id);
    }

    public Client getById(Long id) {
        return clientRep.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Client> findAll(){
        return clientRep.findAll();
    }
}
