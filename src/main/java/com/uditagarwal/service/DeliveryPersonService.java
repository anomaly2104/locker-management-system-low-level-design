package com.uditagarwal.service;

import com.uditagarwal.model.DeliveryPerson;
import com.uditagarwal.model.Slot;
import com.uditagarwal.repository.IDeliveryPersonRepository;
import com.uditagarwal.strategies.IDeliveryAssignmentStrategy;
import lombok.NonNull;

import java.util.List;

public class DeliveryPersonService {
    private final IDeliveryAssignmentStrategy assignmentStrategy;
    private final IDeliveryPersonRepository deliveryRepository;

    public DeliveryPersonService(final IDeliveryAssignmentStrategy assignmentStrategy, final IDeliveryPersonRepository deliveryRepository) {
        this.assignmentStrategy = assignmentStrategy;
        this.deliveryRepository = deliveryRepository;
    }

    @NonNull
    public DeliveryPerson getDeliveryPerson(@NonNull final Slot slot) {

        final List<DeliveryPerson> availableDeliveryPersons = deliveryRepository.getAvailableDeliveryPersons();
        final DeliveryPerson  deliveryPerson = assignmentStrategy.pickDeliveryPerson(availableDeliveryPersons);
        deliveryPerson.assignDelivery(slot);
        return deliveryPerson;
    }
}
