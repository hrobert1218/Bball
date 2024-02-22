package com.example.bball.Services;

import com.example.bball.DTOs.ResponseDTO;
import com.example.bball.Models.Player;
import com.example.bball.Repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepo playerRepo;

    private final MapPlayerToDTO mapPlayerToDTO;

    @Autowired
    public PlayerService(PlayerRepo playerRepo, MapPlayerToDTO mapPlayerToDTO) {
        this.playerRepo = playerRepo;
        this.mapPlayerToDTO = mapPlayerToDTO;
    }

    public List<Player> showAll(){
        return playerRepo.findAll();
    }


    public List<ResponseDTO>index(){
        return mapPlayerToDTO.playerListToDTO(playerRepo.findAll());
    }


}
