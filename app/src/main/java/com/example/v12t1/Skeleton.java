package com.example.v12t1;

import java.util.Random;

public class Skeleton extends Monster {
    private static final String[] NAMES = {
            "Heikki",
            "Luuranko",
            "Mörkö",
            "Kallo"
    };
    public Skeleton() {
        super(
                new Random().nextInt(25) + 10,
                NAMES[new Random().nextInt(NAMES.length)]
        );
    }
}
