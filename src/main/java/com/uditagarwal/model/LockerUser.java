package com.uditagarwal.model;

import lombok.Getter;

@Getter
public abstract class LockerUser {
    private final Contact contact;

    public LockerUser(Contact contact) {
        this.contact = contact;
    }
}
