package io.learn.javacore.grasp;

import java.util.Random;

class Player {
    private String name;
}

class Die {
    private int value;
    private Random random;

    public Die(Random random) {
        this.random = random;
    }

    public int roll() {
        this.value = random.nextInt(6) + 1;
        return this.value;
    }
}

public class DiceGame {
    private Player player;
    private Die die1;
    private Die die2;

    public DiceGame(Die dice1, Die dice2) {
        this.die1 = dice1;
        this.die2 = dice2;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Die die1 = new Die(random);
        Die die2 = new Die(random);
        DiceGame game = new DiceGame(die1, die2);
        for (int i = 0; i < 10; i++) {
            game.play();
        }
    }

    public void play() {

        int die1Result = die1.roll();
        int die2Result = die2.roll();
        int total = die1Result + die2Result;

        if (total >= 7) {
            System.out.println(String.format("Result is %s. You win", total));
        } else {
            System.out.println(String.format("Result is %s. You lose", total));
        }

    }
}
