package connectfour;

import java.util.Scanner;

/**
 * Main Class for interacting with the user
 * @author daniellakonert
 */
public class TextUI{
    //Init Scanner
    private static final Scanner IO = new Scanner(System.in);

    //Outputs Menu
    static int mainMenu(){
        System.out.println("**************MAIN MENU***************");
        System.out.println("1. Start a new game");
        System.out.println("2. Load game from file");
        System.out.println("3. EXIT");
        System.out.println("**************************************");
        //Takes user's choice
        System.out.println("Please enter your option: ");
        int choice = IO.nextInt();
        IO.nextLine();

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
        int choice = -2;

        System.out.println(board); //outputs board
        System.out.println("It is player " + player + "'s turn");

        //tells program to save and quit

        //gets players choice, loops until valid
        while((choice < -1) || (choice > 6)) {

            System.out.println("Enter a number between 0 and 6 to place your piece or -1 to save and exit: ");
            choice = IO.nextInt();

            if (choice == -1) {
                IO.nextLine();
                return -1; //save and quit game
            }

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
        System.out.println("PLAYER" + player + " IS THE WINNER!!!");

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
            filename = IO.nextLine();
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

    /**
     * Tie Game message
     */
    static void tie() {
        System.out.println("TIE GAME");
    }


}