package com.uditagarwal.strategies;

import com.uditagarwal.model.Size;
import com.uditagarwal.model.Slot;
import lombok.NonNull;

import java.util.List;

public interface ISlotAssignmentStrategy {

    Slot pickSlot(@NonNull List<Slot> slots);
}
