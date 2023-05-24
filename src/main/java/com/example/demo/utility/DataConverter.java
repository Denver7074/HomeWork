package com.example.demo.utility;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@UtilityClass
public class DataConverter {

    public static LocalDate stringToLocalDate(String text){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(text, formatter);
        return date;
    }

    public static Integer countAge(LocalDate date){
        return Math.toIntExact(ChronoUnit.YEARS.between(date, LocalDate.now()));
    }
}
