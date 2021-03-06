package com.uditagarwal.repository;

import lombok.NonNull;

public interface ISlotOtpRepository {
    void addOtp(@NonNull String otp, @NonNull String slotId);

    String getOtp(@NonNull String slotId);
}
