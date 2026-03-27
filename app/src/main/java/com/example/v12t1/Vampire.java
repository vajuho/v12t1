package com.example.v12t1;

import java.util.Random;

public class Vampire extends Monster{
    private static final String[] NAMES = {
            "Örkki",
            "Verihammas",
            "Lepakkomies",
            "Vamppis"
    };
    public Vampire() {
        super(
                new Random().nextInt(30) + 20,
                NAMES[new Random().nextInt(NAMES.length)]
        );
    }
}
