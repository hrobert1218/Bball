package com.example.bball.Controllers;

import com.example.bball.DTOs.ErrorDTO;
import com.example.bball.DTOs.PlayerRequestDTO;
import com.example.bball.DTOs.PlayerResponseDTO;
import com.example.bball.Services.PlayerService;
import com.example.bball.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<PlayerResponseDTO> index(){
        List<PlayerResponseDTO> players = playerService.index();
        return ResponseEntity.status(200).body(players).getBody();
    }

    @PostMapping("/add")
    public ResponseEntity store(@RequestBody PlayerRequestDTO playerRequestDTO){
        try {
            PlayerResponseDTO playerResponseDTO = playerService.store(playerRequestDTO);
            return ResponseEntity.status(200).body(playerResponseDTO);
        }catch (IllegalArgumentException i){
            ErrorDTO errorDTO = new ErrorDTO("Data is missing");
            return ResponseEntity.status(400).body(errorDTO);
        }catch (Exception e){
            ErrorDTO errorDTO = new ErrorDTO("Player already exists");
            return ResponseEntity.status(404).body(errorDTO);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable Long id){
        try {
            PlayerResponseDTO playerResponseDTO = playerService.find(id);
            return ResponseEntity.status(200).body(playerResponseDTO);
        }catch (IndexOutOfBoundsException i){
            ErrorDTO errorDTO = new ErrorDTO("Invalid id");
            return ResponseEntity.status(400).body(errorDTO);
        }catch (IllegalArgumentException e){
            ErrorDTO errorDTO = new ErrorDTO("Player not found");
            return ResponseEntity.status(404).body(errorDTO);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity destroy(@PathVariable Long id){
        try {
            playerService.destroy(id);
            return ResponseEntity.status(200).body("");
        }catch (IndexOutOfBoundsException i){
            ErrorDTO errorDTO = new ErrorDTO("Invalid id");
            return ResponseEntity.status(400).body(errorDTO);
        }catch (IllegalArgumentException e){
            ErrorDTO errorDTO = new ErrorDTO("Player not found");
            return ResponseEntity.status(404).body(errorDTO);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody PlayerRequestDTO playerRequestDTO){
        try {
            PlayerResponseDTO playerResponseDTO = playerService.update(id, playerRequestDTO);
            return ResponseEntity.status(200).body(playerResponseDTO);
        }catch (IndexOutOfBoundsException i){
            ErrorDTO errorDTO = new ErrorDTO("Invalid id");
            return ResponseEntity.status(400).body(errorDTO);

        }catch (Exception e){
            ErrorDTO errorDTO = new ErrorDTO("PLayer not found");
            return ResponseEntity.status(404).body(errorDTO);
        }
    }
}
