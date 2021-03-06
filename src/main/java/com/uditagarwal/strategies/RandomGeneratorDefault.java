package com.uditagarwal.strategies;

import lombok.NonNull;

public class RandomGeneratorDefault implements IRandomGenerator {

    @NonNull
    @Override
    public Integer getRandomNumber(Integer lessThanThis) {
        return (int) (Math.random() * lessThanThis);
    }
}
