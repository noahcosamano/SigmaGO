-- Create the table to store characters
CREATE TABLE Characters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    level INT DEFAULT 1,
    xp INT DEFAULT 0,
    attack BIGINT DEFAULT 100,
    defense BIGINT DEFAULT 50,
    health BIGINT DEFAULT 250,
    neededXP INT DEFAULT 100
);

-- Insert a new character into the table
INSERT INTO Characters (name, level, xp, attack, defense, health, neededXP)
VALUES ('Unnamed Sigma', 1, 0, 100, 50, 250, 100);

-- Update the character's stats after leveling up
UPDATE Characters
SET level = 2, xp = 50, attack = 115, defense = 56, health = 280, neededXP = 400
WHERE id = 1;

-- Retrieve the character by ID
SELECT * FROM Characters WHERE id = 1;
