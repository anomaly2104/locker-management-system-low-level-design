package com.uditagarwal.strategies;

import com.uditagarwal.model.LockerItem;
import com.uditagarwal.model.Slot;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class SlotFilteringStrategySizeBased implements ISlotFilteringStrategy {

    @NonNull
    @Override
    public List<Slot> filterSlots(@NonNull final List<Slot> slots, @NonNull final LockerItem lockerItem) {
        return slots.stream()
                .filter(slot -> slot.getSize().canAccomodate(lockerItem.getSize()))
                .collect(Collectors.toList());
    }
}
