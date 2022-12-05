import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        char[][] tictactoe = new char[3][3];
        char rows = 'A';
        int columns = 0;
        System.out.println("This is a game of Tic-Tac-Toe");
        System.out.println("     " + columns + "     " +(columns + 1) + "     "+ (columns + 2));
        for (int i = 0; i < tictactoe.length; i++) {
            for (int j = 0; j < tictactoe.length; j++) {
                if (j == 0) {
                    System.out.print(rows + "    ");
                }

                System.out.print(tictactoe[i][j]);
                if (j != 2) {
                    System.out.print("  |  ");
                }
            }
            System.out.println("");
            if (i / 2 != 1) {
                System.out.println("    -----------------");
            }
            rows++;
        }

        System.out.println("Player 1 will place X's while Player 2 will place O's");

        // First you need to figure out who is going by dividing moves by 2, then you need to figure put what place
        // they are talking about, And then print the new tic-tac-toe board
        int moves = 0;
        boolean winX = winX(tictactoe);
        boolean winO = winO(tictactoe);
        while (moves < 9 && !winO && !winX) {
            if (moves == 0) {
                XsTurn(tictactoe);
                moves++;
            } else if (moves % 2 != 0) {
                OsTurn(tictactoe);
                winO = winO(tictactoe);
                moves++;
            } else if (moves % 2 == 0) {
                XsTurn(tictactoe);
                winX = winX(tictactoe);
                moves++;
            } else {
                System.out.println("The code does not work here");
                moves++;
            }
        }

        if (winX == true) {
            System.out.println("3 in a row. Nice win player 1. Thanks for playing");
        } else if (winO == true) {
            System.out.println("3 in a row. Nice win player 2. Thanks for playing");
        } else {
            System.out.println("The game is over no one won. Thanks for playing");
        }
    }

    public static boolean winX(char[][] board) {
        boolean winCondition;
        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') {
            winCondition = true;
        } else if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') {
            winCondition = true;
        } else if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') {
            winCondition = true;
        } else if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') {
            winCondition = true;
        } else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
            winCondition = true;
        } else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
            winCondition = true;
        } else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            winCondition = true;
        } else if (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') {
            winCondition = true;
        } else {
            winCondition = false;
        }

        return winCondition;
    }

    public static boolean winO(char[][] board) {
        boolean winCondition;
        if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') {
            winCondition = true;
        } else if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') {
            winCondition = true;
        } else if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') {
            winCondition = true;
        } else if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') {
            winCondition = true;
        } else if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
            winCondition = true;
        } else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
            winCondition = true;
        } else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            winCondition = true;
        } else if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O') {
            winCondition = true;
        } else {
            winCondition = false;
        }

        return winCondition;
    }

    public static void printBoard(char [][] board) {
        int columns = 0;
        char rows = 'A';
        System.out.println("     " + columns + "     " +(columns + 1) + "     "+ (columns + 2));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j == 0) {
                    System.out.print(rows + "    ");
                }

                System.out.print(board[i][j]);
                if (j != 2) {
                    System.out.print("  |  ");
                }
            }
            System.out.println("");
            if (i / 2 != 1) {
                System.out.println("    -----------------");
            }
            rows++;
        }
    }

    public static void XsTurn(char[][] board) {
        Scanner input = new Scanner(System.in);
        System.out.println("It is currently X's turn. Place row then column");
        System.out.println("Example: A2");
        String place = input.nextLine();
        char row = Character.toUpperCase(place.charAt(0));
        char column = place.charAt(1);

        int rowNum = 0;
        int columnNum = 0;

        if (row == 'A') {
            rowNum = 0;
        } else if (row == 'B') {
            rowNum = 1;
        } else {
            rowNum = 2;
        }

        if (column == '0') {
            columnNum = 0;
        } else if (column == '1') {
            columnNum = 1;
        } else {
            columnNum = 2;
        }

        board[rowNum][columnNum] = 'X';

        printBoard(board);
    }

    public static void OsTurn(char[][] board) {
        Scanner input = new Scanner(System.in);
        System.out.println("It is currently O's turn. Place row then column");
        System.out.println("Example: A2");
        String place = input.nextLine();
        char row = Character.toUpperCase(place.charAt(0));
        char column = place.charAt(1);

        int rowNum = 0;
        int columnNum = 0;

        if (row == 'A') {
            rowNum = 0;
        } else if (row == 'B') {
            rowNum = 1;
        } else {
            rowNum = 2;
        }

        if (column == '0') {
            columnNum = 0;
        } else if (column == '1') {
            columnNum = 1;
        } else {
            columnNum = 2;
        }

        board[rowNum][columnNum] = 'O';

        printBoard(board);
    }
}
