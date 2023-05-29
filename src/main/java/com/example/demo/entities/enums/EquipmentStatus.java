package com.example.demo.entities.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum EquipmentStatus {
    SOLD,
    ON_CONSERVATION,
    DISPOSED_OF;
}
