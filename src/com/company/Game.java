package com.company;

import java.util.Scanner;

public class Game {

    Scanner sc = new Scanner(System.in);

    public boolean isRunning;
    public char winner;

    char currentPlayer;

    Board board = new Board();


    Game() {
    }

    public void init() {
        board.buildClean();
        System.out.println("\n> Type enter to start.");
        isRunning = true;
        sc.nextLine();
        System.out.print("\033[H\033[2J");
    }

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

    private void play(char currentPlayer) {
        System.out.print("\n " + currentPlayer + " > Choose a position to play: ");
        int position = sc.nextInt();
        switch (position) {
            case 1:
                board.pos1 = currentPlayer;
                break;
            case 2:
                board.pos2 = currentPlayer;
                break;
            case 3:
                board.pos3 = currentPlayer;
                break;
            case 4:
                board.pos4 = currentPlayer;
                break;
            case 5:
                board.pos5 = currentPlayer;
                break;
            case 6:
                board.pos6 = currentPlayer;
                break;
            case 7:
                board.pos7 = currentPlayer;
                break;
            case 8:
                board.pos8 = currentPlayer;
                break;
            case 9:
                board.pos9 = currentPlayer;
                break;
            default:
                System.out.println("Wasn't possível to assign position to current player. (" + currentPlayer + ")");
        }
        if (checkWinnerCircle()) {
            System.out.println("\n Circle wins!");
        } else if (checkWinnerX()) {
            System.out.println("\n X wins!");
        }
    }

    public void gameLoop() {
        currentPlayer = 'X';
        if (isRunning) {
            while (!(checkWinnerX() || checkWinnerCircle())) {
                board.update();
                play(currentPlayer);
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else if (currentPlayer == 'O') {
                    currentPlayer = 'X';
                }
            }

        }
    }

}
