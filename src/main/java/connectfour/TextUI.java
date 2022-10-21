package connectfour;

import java.util.Scanner;

public class TextUI{
    static Scanner io = new Scanner(System.in);

    static int mainMenu(){
        System.out.println("**************MAIN MENU***************");
        System.out.println("1. Start a new game");
        System.out.println("2. Load game from file");
        System.out.println("3. EXIT");
        System.out.println("**************************************");

        return io.nextInt();

    }

    static int turn(int player, String board){
        int choice = -1;

        System.out.println(board);
        System.out.println("It is player " + player + "'s turn");

        while((choice < 0) || (choice > 6)) {

            System.out.println("Enter a number between 0 and 6: ");
            choice = io.nextInt();

        }
        return choice;
    }

    static void winner(int player, String board) {

        System.out.println(board);
        System.out.println("PLAYER" + player + "IS THE WINNER!!!");

    }

    static void invalidChoice(){

        System.out.println("ERROR INVALID CHOICE");

    }

    static void invalidMove(){

        System.out.println("ERROR INVALID MOVE");

    }

}