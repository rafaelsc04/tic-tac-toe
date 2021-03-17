package com.rafael;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public boolean isRunning;

    char currentPlayer;
    Board board = new Board();
    Scanner sc = new Scanner(System.in);

    Game() {
    }

    // init method
    public void init() {
        System.out.println("\n  -= Tic-Tac-Toe =-\n -= Rafael Camargo =- ");
        board.buildClean();
        System.out.println("\n > Type enter to start.");
        isRunning = true;
        sc.nextLine();
        System.out.print("\033[H\033[2J");
    }

    // check if X is winner
    private boolean checkWinnerX() {
        if (board.pos1 == 'X' && board.pos2 == 'X' && board.pos3 == 'X') return true;
        if (board.pos4 == 'X' && board.pos5 == 'X' && board.pos6 == 'X') return true;
        if (board.pos7 == 'X' && board.pos8 == 'X' && board.pos9 == 'X') return true;
        if (board.pos1 == 'X' && board.pos4 == 'X' && board.pos7 == 'X') return true;
        if (board.pos2 == 'X' && board.pos5 == 'X' && board.pos8 == 'X') return true;
        if (board.pos3 == 'X' && board.pos6 == 'X' && board.pos9 == 'X') return true;
        if (board.pos1 == 'X' && board.pos5 == 'X' && board.pos9 == 'X') return true;
        if (board.pos3 == 'X' && board.pos5 == 'X' && board.pos7 == 'X') return true;
        return false;
    }

    // check if circle is winner
    private boolean checkWinnerCircle() {
        if (board.pos1 == 'O' && board.pos2 == 'O' && board.pos3 == 'O') return true;
        if (board.pos4 == 'O' && board.pos5 == 'O' && board.pos6 == 'O') return true;
        if (board.pos7 == 'O' && board.pos8 == 'O' && board.pos9 == 'O') return true;
        if (board.pos1 == 'O' && board.pos4 == 'O' && board.pos7 == 'O') return true;
        if (board.pos2 == 'O' && board.pos5 == 'O' && board.pos8 == 'O') return true;
        if (board.pos3 == 'O' && board.pos6 == 'O' && board.pos9 == 'O') return true;
        if (board.pos1 == 'O' && board.pos5 == 'O' && board.pos9 == 'O') return true;
        if (board.pos3 == 'O' && board.pos5 == 'O' && board.pos7 == 'O') return true;
        return false;
    }

    // allow player to select the placement of it's symbol
    private void play(char currentPlayer) {
        boolean[] positions = new boolean[9];
        System.out.print("\n > Waiting: " + currentPlayer);
        System.out.print("\n > Choose a position to play: ");
        int position = sc.nextInt();
        switch (position) {
            case 1:
                board.pos1 = currentPlayer;
                positions[position - 1] = false;
                break;
            case 2:
                board.pos2 = currentPlayer;
                positions[position - 1] = false;
                break;
            case 3:
                board.pos3 = currentPlayer;
                positions[position - 1] = false;
                break;
            case 4:
                board.pos4 = currentPlayer;
                positions[position - 1] = false;
                break;
            case 5:
                board.pos5 = currentPlayer;
                positions[position - 1] = false;
                break;
            case 6:
                board.pos6 = currentPlayer;
                positions[position - 1] = false;
                break;
            case 7:
                board.pos7 = currentPlayer;
                positions[position - 1] = false;
                break;
            case 8:
                board.pos8 = currentPlayer;
                positions[position - 1] = false;
                break;
            case 9:
                board.pos9 = currentPlayer;
                positions[position - 1] = false;
                break;
            default:
                System.out.println("The position must be a integer between 1 and 9.");
        }
        if (checkWinnerCircle()) {
            board.update();
            System.out.println("\n Circle won!");
        } else if (checkWinnerX()) {
            board.update();
            System.out.println("\n X won!");
        }
    }


    // game loop until a player wins
    public void gameLoop() {
        currentPlayer = 'X';
        int rounds = 0;
        if (isRunning) {
            while (!(checkWinnerX() || checkWinnerCircle()) && rounds < 8) {
                rounds++;
                board.update();
                play(currentPlayer);
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else if (currentPlayer == 'O') {
                    currentPlayer = 'X';
                }
            }
            if (rounds >= 8) {
                System.out.println("\n > Draw!\n");
            }

        }
    }

}
