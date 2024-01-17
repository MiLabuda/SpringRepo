package com.example.demo.property;

import org.springframework.stereotype.Service;

@Service
public interface PropertyService {

    String getPropertyByName(String name);
}
