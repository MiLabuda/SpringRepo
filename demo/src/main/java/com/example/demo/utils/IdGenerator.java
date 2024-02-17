package com.example.demo.utils;

import java.util.Random;

public class IdGenerator {

    private IdGenerator() {
        throw new IllegalStateException("Utility class");
    }

    public static Long generateId() {
        Random random = new Random();
        int randomSixDigit = random.nextInt(900000) + 100000;
        return Long.valueOf(randomSixDigit);
    }
}
