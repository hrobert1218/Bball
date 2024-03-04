package com.example.bball.DTOs;

public class PlayerResponseDTO {

    private final long id;

    private final String playerName;

    private final double ppg;

    private final double height;

    private final String teamName;

    private int jerseyNumber;

    public PlayerResponseDTO(long id, String playerName, double ppg, double height, String teamName, int jerseyNumber) {
        this.id = id;
        this.playerName = playerName;
        this.ppg = ppg;
        this.height = height;
        this.teamName = teamName;
        this.jerseyNumber = jerseyNumber;
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

    public double getHeight() {
        return height;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
}
