package com.example.bball.Controllers;

import com.example.bball.DTOs.ResponseDTO;
import com.example.bball.Services.PlayerService;
import com.example.bball.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerRestController {
    private final PlayerService playerService;

    private final TeamService teamService;

    @Autowired
    public PlayerRestController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @GetMapping
    public List<ResponseDTO> index(){
        List<ResponseDTO> players = playerService.index();
        return ResponseEntity.status(200).body(players).getBody();
    }
}
