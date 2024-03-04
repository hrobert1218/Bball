package com.example.bball.Services;

import com.example.bball.Models.Player;
import com.example.bball.Models.Team;
import com.example.bball.Repositories.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepo teamRepo;

    @Autowired
    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    public List<Team> showAll(){
        return teamRepo.findAll();
    }

    public Team check(String teamName){
        Optional<Team> foundTeam = teamRepo.findByTeamName(teamName);
        if (foundTeam.isPresent()){
            return foundTeam.get();
        }else {
            Team team = new Team(teamName, "no owner", new ArrayList<Player>());
            teamRepo.save(team);
            return team;
        }
    }

}
