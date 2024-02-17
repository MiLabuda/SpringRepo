package com.example.demo.property;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/property")
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping("/user/{name}")
    String getProperty(@PathVariable String name){
        return propertyService.getPropertyByName(name);
    }
}
