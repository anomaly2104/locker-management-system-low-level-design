package com.uditagarwal.model;

public class DeliveryPerson extends LockerUser {
    boolean isAvailable;
    Slot assignedSlot;
    public DeliveryPerson(Contact contact) {
        super(contact);
        this.isAvailable = true;
    }

    public void assignDelivery(Slot slot){
        this.assignedSlot = slot;
        this.makeUnavailable();
    }
    public void makeUnavailable(){
        this.isAvailable = false;
    };

    public boolean isAvailable(){
        return isAvailable;
    };

}
