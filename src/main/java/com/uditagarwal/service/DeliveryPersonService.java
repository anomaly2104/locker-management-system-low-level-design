package com.uditagarwal.service;

import com.uditagarwal.model.DeliveryPerson;
import com.uditagarwal.model.Slot;
import lombok.NonNull;

public class DeliveryPersonService {

    @NonNull
    public DeliveryPerson getDeliveryPerson(@NonNull final Slot slot) {
        // TODO: Use some strategy here to pick a delivery person.
        return null;
    }
}
