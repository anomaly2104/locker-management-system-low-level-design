package com.uditagarwal.strategies;

import com.uditagarwal.model.DeliveryPerson;
import lombok.NonNull;

import java.util.List;

public interface IDeliveryAssignmentStrategy {
    DeliveryPerson pickDeliveryPerson(@NonNull List<DeliveryPerson> list);
}
