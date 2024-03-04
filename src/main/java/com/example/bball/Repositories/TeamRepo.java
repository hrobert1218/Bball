package com.example.bball.Repositories;

import com.example.bball.Models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {
    Optional<Team> findByTeamName(String teamName);

}
