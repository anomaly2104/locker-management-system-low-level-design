package com.uditagarwal.utils;

import java.util.UUID;

public class RandomUtils {

    public static String randomString() {
        return UUID.randomUUID().toString();
    }

    public static String randomOtp() {
        return randomString();
    }

    public static String randomEmail() {
        return randomString() + "@uditagarwal.com";
    }
}
