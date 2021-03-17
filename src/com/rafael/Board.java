package com.rafael;

public class Board {

    private char[][] positions = new char[3][3];

    public char pos1 = positions[0][0] = '1';
    public char pos2 = positions[0][1] = '2';
    public char pos3 = positions[0][2] = '3';
    public char pos4 = positions[1][0] = '4';
    public char pos5 = positions[1][1] = '5';
    public char pos6 = positions[1][2] = '6';
    public char pos7 = positions[2][0] = '7';
    public char pos8 = positions[2][1] = '8';
    public char pos9 = positions[2][2] = '9';

    // constructor
    public void Board() {
    }

    // builds a clean board
    public void buildClean() {
        System.out.println("\n");
        for (int i = 0; i < 3; i++) {
            if (i == 1 || i == 2) {
                System.out.println(" ---+---+--- ");
            }
            System.out.println("    |   |    ");
        }
    }

    // updates the board with the values from positions variables above.
    public void update() {
        System.out.println("\n\n Board: \n");
        System.out.println("  " + pos1 + " | " + pos2 + " | " + pos3 + "  ");
        System.out.println(" ---+---+--- ");
        System.out.println("  " + pos4 + " | " + pos5 + " | " + pos6 + "  ");
        System.out.println(" ---+---+--- ");
        System.out.println("  " + pos7 + " | " + pos8 + " | " + pos9 + "  ");
    }
}
