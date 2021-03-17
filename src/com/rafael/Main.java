package com.rafael;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        game.gameLoop();
        System.out.println("\n » Thanks for playing! See you...\n");
    }
}
