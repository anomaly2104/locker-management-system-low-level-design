package com.uditagarwal.model;

import lombok.Getter;

@Getter
public class Package implements LockerItem {
    private final String id;
    private final Size size;

    public Package(String id, Size size) {
        this.id = id;
        this.size = size;
    }
}
