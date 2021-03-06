package com.uditagarwal.model;

import lombok.Getter;

@Getter
public class LockerItem {
    private final String id;
    private final Size size;

    public LockerItem(String id, Size size) {
        this.id = id;
        this.size = size;
    }
}
