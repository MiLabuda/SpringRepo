package com.example.demo.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class ErrorResponse {

    private List<Violation> violations = new ArrayList<>();


}
