package com.uditagarwal.controller;

import com.uditagarwal.model.Buyer;
import com.uditagarwal.model.DeliveryPerson;
import com.uditagarwal.model.LockerItem;
import com.uditagarwal.model.Slot;
import com.uditagarwal.service.DeliveryPersonService;
import com.uditagarwal.service.LockerService;
import com.uditagarwal.service.NotificationService;
import com.uditagarwal.service.OtpService;
import lombok.NonNull;

public class ReturnController {

    private final OtpService otpService;
    private final NotificationService notificationService;
    private final LockerService lockerService;
    private final DeliveryPersonService deliveryPersonService;

    public ReturnController(@NonNull final NotificationService notificationService,
                            @NonNull final OtpService otpService,
                            @NonNull final LockerService lockerService,
                            @NonNull final DeliveryPersonService deliveryPersonService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
        this.notificationService = notificationService;
        this.deliveryPersonService = deliveryPersonService;
    }

    public void allocateLocker(@NonNull final Buyer buyer, @NonNull final LockerItem lockerItem) {
        final Slot slot = lockerService.allocateSlot(lockerItem);
        final String otp = otpService.generateOtp(slot);
        final DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPerson(slot);
        notificationService.notifyUser(deliveryPerson, otp, slot);
    }
}
