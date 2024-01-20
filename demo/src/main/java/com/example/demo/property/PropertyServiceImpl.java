package com.example.demo.property;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService{

    private final Environment environment;

    @Override
    public String getPropertyByName(String name) {
        return environment.getProperty(name);
    }
}
