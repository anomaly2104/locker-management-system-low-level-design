package com.uditagarwal.strategies;

import com.uditagarwal.model.Slot;
import lombok.NonNull;

import java.util.List;

public class SlotAssignmentStrategyRandom implements ISlotAssignmentStrategy {

    private final IRandomGenerator randomGenerator;

    public SlotAssignmentStrategyRandom(@NonNull final IRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public Slot pickSlot(@NonNull final List<Slot> slots) {
        if (slots.isEmpty()) {
            return null;
        }
        int slotNum = randomGenerator.getRandomNumber(slots.size());
        return slots.get(slotNum);
    }
}
