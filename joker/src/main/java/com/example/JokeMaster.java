package com.example;

import java.util.Random;

public class JokeMaster {
    private static String[] jokes = {
            "Programmer (noun.)\nA machine that turns coffee into code.",
            "Programmer (noun.)\nA person who fixes a problem that you don't know you have, in a way you don't understand.",
            "Algorithm (noun.)\nWord used by programmers when...\nthey do not want to explain what they did.",
            "Hardware (noun.)\nThe part of a computer that you can kick."
    };

    private final Random rnd = new Random();

    public String getJoke() {
        return jokes[rnd.nextInt(jokes.length)];
    }
}
