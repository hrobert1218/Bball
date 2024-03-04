package com.example.bball.Services;

import com.example.bball.DTOs.PlayerResponseDTO;
import com.example.bball.Models.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapPlayerToDTO {

    public PlayerResponseDTO converter(Player player){
        PlayerResponseDTO playerResponseDTO = new PlayerResponseDTO(player.getId(), player.getPlayerName(), player.getPPG(), player.getHeight(), player.getTeam().getTeamName() , player.getJerseyNumber());
        return playerResponseDTO;
    }

    public List<PlayerResponseDTO> playerListToDTO (List<Player> players){
        List<PlayerResponseDTO> dtos =new ArrayList<>();
        for (Player player : players){
            dtos.add(converter(player));
        }
        return dtos;
    }
}
