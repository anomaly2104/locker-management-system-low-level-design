package com.uditagarwal.model;

public class User implements LockerUser {
    private final Contact contact;

    public User(Contact contact) {
        this.contact = contact;
    }

    @Override
    public Contact getContact() {
        return contact;
    }
}
