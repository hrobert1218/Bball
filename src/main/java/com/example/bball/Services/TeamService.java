package com.example.bball.Services;

import com.example.bball.Models.Team;
import com.example.bball.Repositories.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
