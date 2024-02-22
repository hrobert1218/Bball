package com.example.bball.DTOs;

public class ResponseDTO {

    private final long id;

    private final String playerName;

    private final double ppg;

    public ResponseDTO(long id, String playerName, double ppg) {
        this.id = id;
        this.playerName = playerName;
        this.ppg = ppg;
    }

    public long getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public double getPpg() {
        return ppg;
    }
}
