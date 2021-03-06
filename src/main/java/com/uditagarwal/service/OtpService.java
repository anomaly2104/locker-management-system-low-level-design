package com.uditagarwal.service;

import com.uditagarwal.model.Slot;
import com.uditagarwal.repository.SlotOtpRepositoryInMemory;
import com.uditagarwal.strategies.IOtpGenerator;
import lombok.NonNull;

public class OtpService {

    private final IOtpGenerator otpGenerator;
    private final SlotOtpRepositoryInMemory slotOtpRepository;

    public OtpService(IOtpGenerator otpGenerator, SlotOtpRepositoryInMemory slotOtpRepository) {
        this.otpGenerator = otpGenerator;
        this.slotOtpRepository = slotOtpRepository;
    }

    @NonNull
    public String generateOtp(@NonNull final Slot slot) {
        final String otp = otpGenerator.generateOtp();
        slotOtpRepository.addOtp(otp, slot.getSlotId());
        return otp;
    }

    public boolean validateOtp(@NonNull final Slot slot, @NonNull final String otp) {
        final String savedOtp = slotOtpRepository.getOtp(slot.getSlotId());
        return savedOtp != null && savedOtp.equals(otp);
    }
}
