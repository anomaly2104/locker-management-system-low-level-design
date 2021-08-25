package com.uditagarwal.controller;

import com.uditagarwal.model.Locker;
import com.uditagarwal.model.Size;
import com.uditagarwal.model.Slot;
import com.uditagarwal.service.LockerService;
import com.uditagarwal.service.OtpService;
import lombok.NonNull;

import java.util.List;

public class LockerController {

    private final LockerService lockerService;
    private final OtpService otpService;

    public LockerController(@NonNull final LockerService lockerService,
                            @NonNull final OtpService otpService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
    }

    public Locker createLocker(@NonNull final String lockerId) {
        return lockerService.createLocker(lockerId);
    }

    public Slot createSlot(@NonNull final Locker locker, @NonNull final Size slotSize) {
        return lockerService.createSlot(locker, slotSize);
    }

    public List<Slot> getAvailableSlots() {
        return lockerService.getAllAvailableSlots();
    }

    public boolean unlockSlot(@NonNull final Slot slot, @NonNull final String otp) {
        return otpService.validateOtp(slot, otp);
        // Post validation of otp, some physical entity will open the actual slot.
    }

    public void deallocateSlot(@NonNull final Slot slot) {
        lockerService.deallocateSlot(slot);
    }
}
