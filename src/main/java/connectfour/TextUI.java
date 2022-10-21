package connectfour;

import java.util.Scanner;

/**
 * Main Class for interacting with the user
 */
public class TextUI{
    //Init Scanner
    private static Scanner io = new Scanner(System.in);

    //Outputs Menu
    static int mainMenu(){
        System.out.println("**************MAIN MENU***************");
        System.out.println("1. Start a new game");
        System.out.println("2. Load game from file");
        System.out.println("3. EXIT");
        System.out.println("**************************************");
        //Takes user's choice
        System.out.println("Please enter your option: ");
        int choice = io.nextInt();
        io.nextLine();

        return choice;

    }

    /**
     * Prints board, outputs player turn, checks if they want to save/continue, and position player chooses
     * @param player which player's turn it is
     * @param board outputs board
     * @return -1 if they want to save and quit, choice of next player if they chose to continue
     */
    static int turn(int player, String board){
        //Init variables
        int choice = -1;
        int save = -1;

        System.out.println(board); //outputs board
        System.out.println("It is player " + player + "'s turn");

        while ((save != 1) && (save != 0)) { //checks to see if they want to save/continue
            System.out.println("Enter 1 to save and quit game and 0 to continue: ");
            save = io.nextInt();
        }
        //tells program to save and quit
        if (save == 1) {
            io.nextLine();
            return -1; //save and quit game
        }
        //gets players choice, loops until valid
        while((choice < 0) || (choice > 6)) {

            System.out.println("Enter a number between 0 and 6 to place your piece: ");
            choice = io.nextInt();

        }

        return choice; //choice of player
    }

    /**
     * Winner message
     * @param player that one
     * @param board outputs board
     */
    static void winner(int player, String board) {

        System.out.println(board);
        System.out.println("PLAYER" + player + "IS THE WINNER!!!");

    }

    /**
     * Invalid choice error message
     */
    static void invalidChoice(){

        System.out.println("ERROR INVALID CHOICE");

    }

    /**
     * Invalid move error message
     */
    static void invalidMove(){

        System.out.println("ERROR INVALID MOVE");

    }

    /**
     * Gets filename the user wants to load/save
     * @return the filename
     */
    static String filename() {

        String filename = "";

        //checks if filename is less than 3 characters otherwise not valid
        while (filename.length() < 3) {
            System.out.println("Enter your file name: ");
            filename = io.nextLine();
        }

        return filename;

    }

    /**
     * Error message fail to load
     */
    static void failToLoad(){

        System.out.println("ERROR FAIL TO LOAD FILE");

    }

    /**
     * Error message failed to save
     */
    static void failToSave(){

        System.out.println("ERROR FAIL TO SAVE FILE");

    }


}