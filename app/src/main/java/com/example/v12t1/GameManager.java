package com.example.v12t1;

import java.util.Random;

public class GameManager {
    private static GameManager instance;
    private Player player;
    private Monster latestMonster;
    private GameManager() {
        this.player = new Player();
        this.latestMonster = null;
    }
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public Monster generateMonster() {
        int monsterRandom = new Random().nextInt(2);
        if (monsterRandom == 0) {
            latestMonster = new Skeleton();
        } else {
            latestMonster = new Vampire();
        }
        return latestMonster;
    }

    public Monster getLatestMonster() {
        return latestMonster;
    }

    public Player getPlayer() {
        return player;
    }
}