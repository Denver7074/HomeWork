package com.example.demo.controller;


import com.example.demo.entities.structure.UserEntity;
import com.example.demo.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

//    @PostMapping
//    @Operation(summary = "Регистрация нового пользователя")
//    public String createJournal(@RequestBody UserEntity user, @RequestParam Long organizationId){
//        userService.createUser(user,organizationId);
//        return "Пользователь создан";
//    }

    @GetMapping("/{id}")
    @Operation(summary = "Поиск пользователя по id")
    public UserEntity getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    @Operation(summary = "Все пользователи")
    public ResponseEntity<List<UserEntity>> getAllUser(){
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить пользователя")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
