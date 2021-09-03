package com.uditagarwal.strategies;

import com.uditagarwal.model.DeliveryPerson;
import lombok.NonNull;

import java.util.List;

public class DeliveryAssignmentStrategyRandom implements IDeliveryAssignmentStrategy{

    private final IRandomGenerator randomGenerator;

    public DeliveryAssignmentStrategyRandom(@NonNull final IRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public DeliveryPerson pickDeliveryPerson(@NonNull List<DeliveryPerson> list) {
        if(list.isEmpty()){
            return null;
        }
        int deliveryAgentIdx = randomGenerator.getRandomNumber(list.size());
        return list.get(deliveryAgentIdx);
    }
}
