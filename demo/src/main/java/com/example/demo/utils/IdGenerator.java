package com.example.demo.utils;

import java.util.UUID;


public class IdGenerator {

    private IdGenerator() {
        throw new IllegalStateException("Utility class");
    }

    public static Long generateId() {
        return Long.valueOf(UUID.randomUUID().toString());
    }
}
