package com.uditagarwal.repository;

import com.uditagarwal.exceptions.LockerAlreadyExistsException;
import com.uditagarwal.model.Locker;
import com.uditagarwal.model.Slot;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class LockerRepositoryInMemory implements ILockerRepository {
    private final List<Locker> allLockers;

    public LockerRepositoryInMemory() {
        this.allLockers = new ArrayList<>();
    }

    public Locker getLocker(@NonNull final String id) {
        for (Locker locker : this.allLockers) {
            if (locker.getId().equals(id)) {
                return locker;
            }
        }
        return null;
    }

    @NonNull
    public Locker createLocker(@NonNull final String id) {
        if (getLocker(id) != null) {
            throw new LockerAlreadyExistsException();
        }
        final Locker newLocker = new Locker(id);
        allLockers.add(newLocker);
        return newLocker;
    }

    @NonNull
    public List<Slot> getAllAvailableSlots() {
        final List<Slot> result = new ArrayList<>();
        for (Locker locker : allLockers) {
            result.addAll(locker.getAvailableSlots());
        }
        return result;
    }

}
