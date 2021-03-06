package com.uditagarwal.repository;

import com.uditagarwal.model.Locker;
import com.uditagarwal.model.Slot;
import lombok.NonNull;

import java.util.List;

public interface ILockerRepository {

    @NonNull
    Locker createLocker(@NonNull String id);

    @NonNull
    List<Slot> getAllAvailableSlots();
}
