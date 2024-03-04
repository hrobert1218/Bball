package com.example.bball.Repositories;

import com.example.bball.DTOs.PlayerRequestDTO;
import com.example.bball.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {
    Optional<Player> findByPlayerName(String name);

    Optional<Player> findByIdAndPlayerName(Long id, String name);
}
