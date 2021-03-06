package com.uditagarwal.service;

import com.uditagarwal.model.LockerUser;
import com.uditagarwal.model.Slot;
import lombok.NonNull;

public class NotificationService {

    public void notifyUser(@NonNull final LockerUser user, @NonNull final String otp, @NonNull final Slot slot) {
        // Use third party api to send actual notification like sms, email etc.
        System.out.println("Sending notification of otp: " + otp + " to: " + user + " for slot: " + slot);
    }
}
