package com.example.backendjavaprojectemployee.service;

import java.util.Random;

public class UUIDGenerator {
    public static String generate() {
        String uuid = "SK";
        Random random = new Random();
        int randomNumber = random.nextInt(99) + 1;
        String hexadecimalValue = Integer.toHexString(randomNumber);
        uuid += hexadecimalValue;
        return uuid;
    }
}
