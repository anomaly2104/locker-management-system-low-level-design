package com.uditagarwal.model;

import lombok.NonNull;

import java.text.SimpleDateFormat;

public class Size {
    private final Double width;
    private final Double height;

    public Size(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    public boolean canAccomodate(@NonNull final Size sizeToAccomodate) {
        return this.width >= sizeToAccomodate.width && this.height >= sizeToAccomodate.height;
    }
}
