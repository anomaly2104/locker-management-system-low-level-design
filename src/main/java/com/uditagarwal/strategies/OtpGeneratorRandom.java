package com.uditagarwal.strategies;

import lombok.NonNull;

public class OtpGeneratorRandom implements IOtpGenerator {
    private final int otpLength;
    private final IRandomGenerator randomGenerator;

    public OtpGeneratorRandom(@NonNull final Integer otpLength, @NonNull final IRandomGenerator randomGenerator) {
        this.otpLength = otpLength;
        this.randomGenerator = randomGenerator;
    }

    @NonNull
    @Override
    public String generateOtp() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            stringBuilder.append(randomGenerator.getRandomNumber(10));
        }
        return stringBuilder.toString();
    }
}
