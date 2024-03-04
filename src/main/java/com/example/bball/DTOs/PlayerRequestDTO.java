package com.example.bball.DTOs;

public class PlayerRequestDTO {

    private final String playerName;

    private final double height;

    private final double PPG;

    private final int jerseyNumber;

    private final String teamName;

    public PlayerRequestDTO(String playerName, double height, double PPG, int jerseyNumber, String teamName) {
        this.playerName = playerName;
        this.height = height;
        this.PPG = PPG;
        this.jerseyNumber = jerseyNumber;
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public double getHeight() {
        return height;
    }


    public double getPPG() {
        return PPG;
    }


    public int getJerseyNumber() {
        return jerseyNumber;
    }


    public String getTeamName() {
        return teamName;
    }


}
