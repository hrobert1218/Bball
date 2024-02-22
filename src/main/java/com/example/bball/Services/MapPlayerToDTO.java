package com.example.bball.Services;

import com.example.bball.DTOs.RequestDTO;
import com.example.bball.DTOs.ResponseDTO;
import com.example.bball.Models.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapPlayerToDTO {

    public ResponseDTO converter(Player player){
        ResponseDTO responseDTO = new ResponseDTO(player.getId(), player.getPlayerName(), player.getPPG());
        return responseDTO;
    }

    public List<ResponseDTO> playerListToDTO (List<Player> players){
        List<ResponseDTO> dtos =new ArrayList<>();
        for (Player player : players){
            dtos.add(converter(player));
        }
        return dtos;
    }
}
