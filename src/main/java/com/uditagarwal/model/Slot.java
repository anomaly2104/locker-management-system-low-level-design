package com.uditagarwal.model;

import com.uditagarwal.exceptions.BadRequestException;
import com.uditagarwal.exceptions.SlotAlreadyOccupiedException;
import lombok.Getter;
import lombok.NonNull;

import java.util.Date;

@Getter
public class Slot {

    private final String slotId;
    private final Size size;
    private final Locker locker;
    private LockerItem currentLockerItem;
    private Date allocationDate;

    public Slot(@NonNull final String slotId, @NonNull final Size size, @NonNull final Locker locker) {
        this.slotId = slotId;
        this.size = size;
        this.locker = locker;
        this.currentLockerItem = null;
    }

    synchronized public void allocatePackage(@NonNull final LockerItem newLockerItem) {
        if (this.currentLockerItem != null) {
            throw new SlotAlreadyOccupiedException();
        }
        this.allocationDate = new Date();
        this.currentLockerItem = newLockerItem;
    }

    synchronized public void deallocateSlot() {
        this.currentLockerItem = null;
    }

    synchronized public boolean isAvailable() {
        return this.currentLockerItem == null;
    }
}
