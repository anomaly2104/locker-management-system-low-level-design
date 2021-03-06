package com.uditagarwal.strategies;

import com.uditagarwal.model.LockerItem;
import com.uditagarwal.model.Slot;
import lombok.NonNull;

import java.util.List;

public interface ISlotFilteringStrategy {

    @NonNull
    List<Slot> filterSlots(@NonNull List<Slot> slots, @NonNull LockerItem lockerItem);
}
