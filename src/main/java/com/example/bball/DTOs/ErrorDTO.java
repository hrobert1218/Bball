package com.example.bball.DTOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ErrorDTO {

    private final String error;


    public ErrorDTO(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
