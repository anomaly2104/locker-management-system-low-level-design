package com.uditagarwal.utils;

import com.uditagarwal.controller.LockerController;
import com.uditagarwal.model.*;
import com.uditagarwal.model.Package;

import static com.uditagarwal.utils.RandomUtils.randomString;

public class LockerUtils {

    public static Locker createTestLockerWithSlots(LockerController lockerController, Integer numSlots, Size slotSize) {
        final Locker locker = lockerController.createLocker(randomString());
        for (int i = 0; i < numSlots; i++) {
            final Slot slot1 = lockerController.createSlot(locker, slotSize);
        }
        return locker;
    }

    public static LockerItem randomLockerItem(Size itemSize) {
        return new Package(randomString(), itemSize);
    }
}
