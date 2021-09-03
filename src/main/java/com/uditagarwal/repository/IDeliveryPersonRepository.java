package com.uditagarwal.repository;

import com.uditagarwal.model.DeliveryPerson;
import lombok.NonNull;

import java.util.List;

public interface IDeliveryPersonRepository {

    @NonNull
    List<DeliveryPerson> getAvailableDeliveryPersons();
}
