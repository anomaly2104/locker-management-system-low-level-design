package com.uditagarwal.controller;

import com.uditagarwal.model.Buyer;
import com.uditagarwal.model.LockerItem;
import com.uditagarwal.model.Size;
import com.uditagarwal.model.Slot;
import com.uditagarwal.utils.LockerUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.runners.MockitoJUnitRunner;

import static com.uditagarwal.utils.BuyerUtils.randomBuyer;
import static com.uditagarwal.utils.RandomUtils.randomOtp;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OtpVerificationTests extends BaseTest {

    @Test
    public void testOtpWorksCorrectly() {

        // Arrange
        LockerUtils.createTestLockerWithSlots(lockerController, 2, new Size(10.0, 10.0));
        final Buyer buyer = randomBuyer();
        final LockerItem item = LockerUtils.randomLockerItem(new Size(5.0, 5.0));

        // Act
        final Slot slot = orderController.allocateLocker(buyer, item);

        // Assert
        ArgumentCaptor<String> otpCaptor = ArgumentCaptor.forClass(String.class);
        verify(notificationService).notifyUser(eq(buyer), otpCaptor.capture(), eq(slot));
        final String otp = otpCaptor.getValue();
        assertNotNull(otp);
        boolean isSuccess = lockerController.unlockSlot(slot, otp);

        assertTrue(isSuccess);
    }

    @Test
    public void testInvalidOtpDoesNotUnlocksSlot() {

        // Arrange
        LockerUtils.createTestLockerWithSlots(lockerController, 2, new Size(10.0, 10.0));
        final Buyer buyer = randomBuyer();
        final LockerItem item = LockerUtils.randomLockerItem(new Size(5.0, 5.0));

        // Act
        final Slot slot = orderController.allocateLocker(buyer, item);

        // Assert
        boolean isSuccess = lockerController.unlockSlot(slot, randomOtp());

        assertFalse(isSuccess);
    }
}