package com.uditagarwal.utils;

import com.uditagarwal.model.Buyer;
import com.uditagarwal.model.Contact;

import static com.uditagarwal.utils.RandomUtils.randomEmail;
import static com.uditagarwal.utils.RandomUtils.randomString;

public class BuyerUtils {

    public static Buyer randomBuyer() {
        return new Buyer(new Contact(randomString(), randomEmail()));
    }
}
