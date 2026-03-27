package com.example.v12t1;

import java.util.Random;

public class Player {
    private int damage;
    private int score;
    public Player() {
        this.damage = new Random().nextInt(5) + 8;
        this.score = 0;
     }
    public void attack(Monster monster) {
        monster.takeDamage(this.damage);
        this.score = this.score + this.damage;
    }

    public int getScore() {
        return score;
    }
}
