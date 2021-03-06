package com.uditagarwal.controller;

import com.uditagarwal.repository.ILockerRepository;
import com.uditagarwal.repository.LockerRepositoryInMemory;
import com.uditagarwal.repository.SlotOtpRepositoryInMemory;
import com.uditagarwal.service.LockerService;
import com.uditagarwal.service.NotificationService;
import com.uditagarwal.service.OtpService;
import com.uditagarwal.strategies.*;
import org.junit.Before;
import org.mockito.Mock;

public class BaseTest {

    protected LockerController lockerController;
    protected OrderController orderController;
    protected OtpService otpService;
    protected LockerService lockerService;

    @Mock
    protected NotificationService notificationService;

    @Before
    public void setup() {

        final RandomGeneratorDefault randomGeneratorDefault = new RandomGeneratorDefault();
        final ISlotAssignmentStrategy lockerAssignmentStrategy = new SlotAssignmentStrategyRandom(randomGeneratorDefault);
        final ILockerRepository lockerRepository = new LockerRepositoryInMemory();
        final ISlotFilteringStrategy slotFilteringStrategy = new SlotFilteringStrategySizeBased();
        final SlotOtpRepositoryInMemory slotOtpRepository = new SlotOtpRepositoryInMemory();
        final OtpGeneratorRandom otpGeneratorRandom = new OtpGeneratorRandom(5, randomGeneratorDefault);

        this.lockerService = new LockerService(lockerAssignmentStrategy, lockerRepository, slotFilteringStrategy);
        this.otpService = new OtpService(otpGeneratorRandom, slotOtpRepository);

        this.lockerController = new LockerController(lockerService, otpService);
        this.orderController = new OrderController(notificationService, otpService, lockerService);
    }
}
