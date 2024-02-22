package com.example.bball.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Player {
    @Id
    private long id;

    private String playerName;

    private double height;

    private double PPG;

    private int jerseyNumber;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {
    }

    public Player(String playerName, double height, double PPG, int jerseyNumber, Team team) {
        this.playerName = playerName;
        this.height = height;
        this.PPG = PPG;
        this.jerseyNumber = jerseyNumber;
        this.team = team;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getPPG() {
        return PPG;
    }

    public void setPPG(int PPG) {
        this.PPG = PPG;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public long getId() {
        return id;
    }
}
