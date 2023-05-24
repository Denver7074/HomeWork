package com.example.demo.utility;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DataConverter {

    public static LocalDate stringToLocalDate(String text){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(text, formatter);
        return date;
    }

    public static int countAge(LocalDate date){
        int age = LocalDate.now().getYear() - date.getYear();
        return age;
    }
}
