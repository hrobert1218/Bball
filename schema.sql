CREATE TABLE IF NOT EXISTS player (
    'id' INT NOT NULL AUTO_INCREMENT,
    'ppg' DECIMAL(5, 2),
    'height' INT,
    'jersey_number' INT,
    'player_name' VARCHAR(255),
    'team_id' INT,
    PRIMARY KEY (id),
    FOREIGN KEY (team_id) REFERENCES teams(id)
    );

CREATE TABLE IF NOT EXISTS team (
    'id' INT NOT NULL AUTO_INCREMENT,
    'owner' VARCHAR(255),
    'team_name' VARCHAR(255),
    PRIMARY KEY (id)
    );

SELECT
    player.id,
    player.ppg,
    player.height,
    player.jersey_number,
    player.player_name,
    player.team_id,
    team.id AS team_id,
    team.owner,
    team.team_name
FROM
    players p
        LEFT JOIN
    teams t ON p.team_id = t.id;