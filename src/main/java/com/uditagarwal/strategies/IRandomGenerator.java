package com.uditagarwal.strategies;

import lombok.NonNull;

public interface IRandomGenerator {

    @NonNull
    Integer getRandomNumber(@NonNull Integer lessThanThis);
}
