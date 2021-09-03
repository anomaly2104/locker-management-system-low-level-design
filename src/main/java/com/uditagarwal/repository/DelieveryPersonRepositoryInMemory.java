package com.uditagarwal.repository;

import com.uditagarwal.exceptions.BadRequestException;
import com.uditagarwal.model.DeliveryPerson;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DelieveryPersonRepositoryInMemory implements IDeliveryPersonRepository{
    List<DeliveryPerson> deliveryPersonList;

    public DelieveryPersonRepositoryInMemory(){
        this.deliveryPersonList = new ArrayList<>();
    }

    @Override
    public @NonNull List<DeliveryPerson> getAvailableDeliveryPersons() {
        final List<DeliveryPerson> availableList = new ArrayList<>();

        for(DeliveryPerson d:deliveryPersonList){
            if(d.isAvailable()){
                availableList.add(d);
            }
        }
        return availableList;
    }
}
