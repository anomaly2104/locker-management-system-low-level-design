package com.uditagarwal.controller;

import com.uditagarwal.exceptions.NoSlotAvailableException;
import com.uditagarwal.model.Buyer;
import com.uditagarwal.model.LockerItem;
import com.uditagarwal.model.Size;
import com.uditagarwal.model.Slot;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.uditagarwal.utils.BuyerUtils.randomBuyer;
import static com.uditagarwal.utils.LockerUtils.createTestLockerWithSlots;
import static com.uditagarwal.utils.LockerUtils.randomLockerItem;

@RunWith(MockitoJUnitRunner.class)
public class SlotAllocationTests extends BaseTest {

    @Test
    public void testSlotAllocationToUser() {

        // Arrange
        createTestLockerWithSlots(lockerController, 2, new Size(10.0, 10.0));
        createTestLockerWithSlots(lockerController, 2, new Size(5.0, 5.0));
        final Buyer buyer1 = randomBuyer();
        final LockerItem item1 = randomLockerItem(new Size(7.5, 5.0));
        final LockerItem item2 = randomLockerItem(new Size(7.5, 5.0));

        // Act
        final List<Slot> allSlots = lockerController.getAvailableSlots();

        final Slot slot1 = orderController.allocateLocker(buyer1, item1);
        List<Slot> availbleSlotsPost1 = lockerController.getAvailableSlots();

        final Slot slot2 = orderController.allocateLocker(buyer1, item2);
        List<Slot> availbleSlotsPost2 = lockerController.getAvailableSlots();

        // Assert

        // Slot1 should be available only initially.
        Assertions.assertTrue(allSlots.contains(slot1));
        Assertions.assertFalse(availbleSlotsPost1.contains(slot1));
        Assertions.assertFalse(availbleSlotsPost2.contains(slot1));

        // Slot2 should be available till item 2 is not alloted.
        Assertions.assertTrue(allSlots.contains(slot2));
        Assertions.assertTrue(availbleSlotsPost1.contains(slot2));
        Assertions.assertFalse(availbleSlotsPost2.contains(slot2));

        // After unallocating slot1, it should get available. Slot2 should still be occupied.
        lockerController.unallocateSlot(slot1);
        Assertions.assertTrue(lockerController.getAvailableSlots().contains(slot1));
        Assertions.assertFalse(lockerController.getAvailableSlots().contains(slot2));

        // After unallocating slot2 also now, both should be availble now;
        lockerController.unallocateSlot(slot2);
        Assertions.assertTrue(lockerController.getAvailableSlots().contains(slot1));
        Assertions.assertTrue(lockerController.getAvailableSlots().contains(slot2));
    }

    @Test(expected = NoSlotAvailableException.class)
    public void testSlotAllocationWithoutAddingSlotsThrowsException() {
        orderController.allocateLocker(randomBuyer(), randomLockerItem(new Size(10.0, 10.0)));
    }
}