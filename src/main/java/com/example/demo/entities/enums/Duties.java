package com.example.demo.entities.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum Duties {
    ADMIN,
    QUALITY_MANAGER,
    DIRECTOR_LABORATORY,
    DIRECTOR_ORGANIZATION,
    CARRYING_OUT_MEASUREMENTS;
}
