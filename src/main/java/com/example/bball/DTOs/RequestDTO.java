package com.example.bball.DTOs;

public class RequestDTO {

    private final String playerName;

    public RequestDTO(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
