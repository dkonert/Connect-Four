package connectfour;

import java.util.Scanner;

public class TextUI{
    private static Scanner io = new Scanner(System.in);

    static int mainMenu(){
        System.out.println("**************MAIN MENU***************");
        System.out.println("1. Start a new game");
        System.out.println("2. Load game from file");
        System.out.println("3. EXIT");
        System.out.println("**************************************");

        int choice = io.nextInt();
        io.nextLine();

        return choice;

    }

    static int turn(int player, String board){
        int choice = -1;
        int save = -1;

        System.out.println(board);
        System.out.println("It is player " + player + "'s turn");

        while ((save != 1) && (save != 0)) {
            System.out.println("Enter 1 to save and quit game and 0 to continue: ");
            save = io.nextInt();
        }

        if (save == 1) {
            io.nextLine();
            return -1; //save and quit game
        }

        while((choice < 0) || (choice > 6)) {

            System.out.println("Enter a number between 0 and 6 to place your piece: ");
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

    static String filename() {

        String filename = "";

        //checks if filename is less than 3 characters otherwise not valid
        while (filename.length() < 3) {
            System.out.println("Enter your file name: ");
            filename = io.nextLine();
        }

        return filename;

    }

    static void failToLoad(){

        System.out.println("ERROR FAIL TO LOAD FILE");

    }

    static void failToSave(){

        System.out.println("ERROR FAIL TO SAVE FILE");

    }


}