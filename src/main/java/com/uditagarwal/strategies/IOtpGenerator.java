package com.uditagarwal.strategies;

import lombok.NonNull;

public interface IOtpGenerator {

    @NonNull
    String generateOtp();
}
