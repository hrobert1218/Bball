package com.example.bball.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Team {
    @Id
    private long id;

    private String teamName;

    private String owner;
    @OneToMany
    private List<Player> playerList;

    public Team() {
    }

    public Team(String teamName, String owner, List<Player> playerList) {
        this.teamName = teamName;
        this.owner = owner;
        this.playerList = playerList;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
    public long getId() {
        return id;
    }
}
