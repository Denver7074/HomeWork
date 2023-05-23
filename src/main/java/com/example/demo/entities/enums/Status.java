package com.example.demo.entities.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Эти роли служат для выдачи прав доступа на редактирование и просто чтение документов.
 */
@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum Status {
    DIRECTOR_LABORATORY,
    DIRECTOR_ORGANIZATION,
    CUSTOMER,
    WORKER_LABORATORY;
}
