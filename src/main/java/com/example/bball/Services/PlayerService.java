package com.example.bball.Services;

import com.example.bball.DTOs.PlayerRequestDTO;
import com.example.bball.DTOs.PlayerResponseDTO;
import com.example.bball.Models.Player;
import com.example.bball.Repositories.PlayerRepo;
import com.example.bball.Repositories.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepo playerRepo;

    private final TeamService teamService;
    private final MapPlayerToDTO mapPlayerToDTO;

    @Autowired
    public PlayerService(PlayerRepo playerRepo, TeamRepo teamRepo, TeamService teamService, MapPlayerToDTO mapPlayerToDTO) {
        this.playerRepo = playerRepo;
        this.teamService = teamService;
        this.mapPlayerToDTO = mapPlayerToDTO;
    }

    public List<Player> showAll(){
        return playerRepo.findAll();
    }


    public List<PlayerResponseDTO>index(){
        return mapPlayerToDTO.playerListToDTO(playerRepo.findAll());
    }

    public PlayerResponseDTO store(PlayerRequestDTO playerRequestDTO) throws Exception {
        Optional<Player> foundPlayer = playerRepo.findByPlayerName(playerRequestDTO.getPlayerName());
        if (playerRequestDTO.getHeight() <= 0 || playerRequestDTO.getPlayerName().isEmpty() || playerRequestDTO.getPPG() <= 0 || playerRequestDTO.getJerseyNumber() < 0 || playerRequestDTO.getTeamName().isEmpty()) {
            throw new IllegalArgumentException("data missing");
        }
        if (foundPlayer.isPresent()) {
            throw new Exception("Player already present in the database");
        } else {
            Player tryplayer = new Player(playerRequestDTO.getPlayerName(), playerRequestDTO.getHeight(), playerRequestDTO.getPPG(), playerRequestDTO.getJerseyNumber(), teamService.check(playerRequestDTO.getTeamName()));
            playerRepo.save(tryplayer);
            return mapPlayerToDTO.converter(tryplayer);
        }
    }

    public PlayerResponseDTO find(Long id){
        Optional<Player> foundPlayer = playerRepo.findById(id);
        if(id <= 0){
            throw new IndexOutOfBoundsException("invalid id");
        }
        if (foundPlayer.isEmpty()){
            throw new IllegalArgumentException("player not found");
        }
        return mapPlayerToDTO.converter(foundPlayer.get());
    }

    public void destroy(Long id){
        Optional<Player> foundPlayer = playerRepo.findById(id);
        if (id <= 0){
            throw new IndexOutOfBoundsException("invalid id");
        }
        if (foundPlayer.isEmpty()){
            throw new IllegalArgumentException("Player not found");
        }
        playerRepo.delete(foundPlayer.get());
    }

    public PlayerResponseDTO update(Long id, PlayerRequestDTO playerRequestDTO) throws Exception {
        Optional<Player> foundPlayer = playerRepo.findById(id);
        if (id <= 0){
            throw new IndexOutOfBoundsException("Invalid id");
        }
        if (foundPlayer.isEmpty()){
            throw new IllegalArgumentException("Player not found");
        }

        Player savedPlayer = foundPlayer.get();
        savedPlayer.setPlayerName(playerRequestDTO.getPlayerName());
        savedPlayer.setHeight(playerRequestDTO.getHeight());
        savedPlayer.setPPG(playerRequestDTO.getPPG());
        savedPlayer.setJerseyNumber(playerRequestDTO.getJerseyNumber());
        savedPlayer.setTeam(teamService.check(playerRequestDTO.getTeamName()));
        playerRepo.save(savedPlayer);
        return mapPlayerToDTO.converter(savedPlayer);
    }
}
