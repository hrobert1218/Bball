package com.example.bball.Controllers;

import com.example.bball.Services.PlayerService;
import com.example.bball.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayerController {

    private final PlayerService playerService;

    private final TeamService teamService;

    @Autowired
    public PlayerController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("players", playerService.showAll());
        model.addAttribute("teams", teamService.showAll());
        return "index";
    }

}
