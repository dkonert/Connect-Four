package connectfour;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main class for managing the state of the board
 * @author daniellakonert
 */
public class Board{
    //init variables
    private int[][] board= new int[6][7];

    /**
     * Creates new board
     */
    public Board(){}

    /**
     * Places the piece in the first available spot chosen by the player
     * @param position column the player has chosen
     * @param player who is placing their piece
     * @return 0 if it was able to place a piece false otherwise
     */
    public int placePieceOnBoard(int position, int player) {

        for (int i = 5; i >= 0; i--) {
            if (board[i][position] == 0) { //first available position in col
                board[i][position] = player; //places player

                return 0; //Valid
            }
        }

        return -1; //Invalid
    }

    /**
     * Keeps track if a player placed 4 pieces diagonally indicating winner
     * @return 0 if no one won and match representing the winner
     */
    public int checkForWinnerDiagonal(){
        int match = 0;

        //Diagonal Check Left
        for(int i = 5; i >=3; i--) { //Row Loop
            columnLoop: //Left Side of Board
            for (int j = 0; j < 4; j++){
                match = board[i][j];
                if (match == 0) { //if there is an empty space continue to next column
                    continue columnLoop;
                }
                for (int k = 1; k < 4; k++){ //Loop that checks if 4 matched diagonal right
                    if (match != board[i-k][j+k]) { //if piece doesn't match piece upright of it continue to next column
                        continue columnLoop;
                    }
                }
                return match; //return winner
            }
        }
        //Diagonal Check Left
        for(int i = 5; i >=3; i--) { //Row Loop
            columnLoop: //Right Side of Board
            for (int j = 3; j < 7; j++){
                match = board[i][j];
                if (match == 0) { //if there is an empty space continue to next column
                    continue columnLoop;
                }
                for (int k = 1; k < 4; k++){ //Loop that checks if 4 matched diagonal left
                    if (match != board[i-k][j-k]) {
                        //if piece doesn't match piece up and to the left of it continue to next column
                        continue columnLoop;
                    }
                }
                return match; //return winner
            }
        }
        return 0; //returns if no one won
    }

    /**
     * Keeps track if a player got 4 in a row Horizontally or Vertically indicating a winner
     * @return 0 if no one won and match representing the winner
     */
    public int checkForWinnerVerticalHorizontal(){
        int match = 0;
        //Vertical Check
        for (int i = 5; i >= 3; i--){ //Row Loop
            columnLoop:
            for (int j = 0; j < 7; j++){
                match = board[i][j];
                if (match == 0) { //if there is an empty space continue to next column
                    continue columnLoop;
                }
                for (int k = 1; k < 4; k++){ //Loop that checks if 4 matched vertically
                    if (match != board[i-k][j]) { //if piece doesn't match piece above it continue to next column
                        continue columnLoop;
                    }
                }
                return match; //return winner
            }
        }
        //Horizontal Check
        for (int i = 5; i >=0; i--){ //Row Loop
            columnLoop:
            for (int j = 0; j < 4; j++){
                match = board[i][j];
                if (match == 0) { //if there is an empty space continue to next column
                    continue columnLoop;
                }
                for (int k = 1; k < 4; k++){ //Loop that checks if 4 matched horizontally
                    if (match != board[i][j+k]) { //if piece doesn't match piece left of it continue to next column
                        continue columnLoop;
                    }
                }
                return match; //return winner
            }
        }
        return 0; //returns if no one won
    }

    /**
     * Calls both winnerVH and winnerDiagonal indicating if a winner has won in either
     * @return the winner of VH or D indicating who won or if no one won
     */
    public int checkForWinner(){
        int winnerVH = checkForWinnerVerticalHorizontal();
        int winnerD = checkForWinnerDiagonal();

        if (winnerVH != 0) {
            return winnerVH;
        }

        return winnerD;
    }

    /**
     * Created the board as a string to print the state of the board
     * @return the board
     */
    public String toString() {

        String boardString = "";

        for (int i = 0; i < 6; i++) { //Row Loop
            for (int j = 0; j < 7; j++){ //Column Loop
                boardString = boardString + Integer.toString(board[i][j]);
            }
            boardString = boardString + "\n";
        }

        return boardString;
    }

    /**
     * Saves the board to a file of the user's choosing
     * @param filename the user wants the file saved to
     * @return 0 if file saved -1 if it failed
     */
    public int save(String filename) {

        String boardString = "";

        for (int i = 0; i < 6; i++) { //Row Loop
            for (int j = 0; j < 7; j++){ //Column Loop
                boardString = boardString + Integer.toString(board[i][j]) + ",";
            }
            //removes comma at the end of each line
            boardString = boardString.substring(0, boardString.length() - 1);
            boardString = boardString + "\n";
        }
        //remove line break from end of file
        boardString = boardString.substring(0, boardString.length() - 1);


        File file = new File(filename);

        FileWriter fw = null; //file writer object

        try {
            //create file writer for saving files - set to overwrite
            fw = new FileWriter(file, false);
            fw.write(boardString);
        } catch (IOException e) { //Handle file exceptions
            e.printStackTrace();
            return -1; //failed to save
        } finally { //close file writer after save
            try {
                if (fw != null) {
                    fw.flush();
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * Loads a saved file to continue the game
     * @param filename the file the user wants to open
     * @return 0 if it loaded -1 if it failed to do so
     */
    public int load(String filename) {

        try {
            File file = new File(filename);
            Scanner io = new Scanner(file);

            String line;
            String[] splitLine;

            //Goes through board until it's found everything
            for (int i = 0; i < 6; i++){ //Loops through rows
                if (!io.hasNextLine()){
                    return -1; //error if there is not enough rows
                }
                line = io.nextLine();
                splitLine = line.split(",");
                if (splitLine.length != 7) {
                    return -1; //error if there is a wrong # of columns
                }
                for(int j = 0; j < 7; j++){ //Loops through columns
                    try {
                        board[i][j] = Integer.parseInt(splitLine[j]); //splits each number
                    } catch (Exception e) {
                        return -1; //Invalid format
                    }
                    if ((board[i][j] < 0) || (board[i][j] > 2)) {
                        return -1; //Invalid
                    }

                }
            }
        } catch (FileNotFoundException e) {
            return -1; //Invalid
        }

        return 0; //Valid

    }

    /**
     * Calculates whose turn it is on a game
     * @return which player's turn it is
     */
    public int calcTurn() {
        //Init variables
        int moveP1 = 0;
        int moveP2 = 0;

        for (int i = 0; i < 6; i++){ //Row Loop
            for (int j = 0; j < 7; j++){ //Column Loop
                if (board[i][j] == 1){
                    moveP1++; //amount of times P1 placed a piece
                } else if (board[i][j] == 2) {
                    moveP2++; //amount of times P2 placed a piece
                }
            }
        }

        if (moveP2 >= moveP1) {
            return 1; //P1's turn
        } else {
            return 2; //P2's turn
        }

    }

    /**
     * Checks for tie game
     * @return 1 if there is a tie game and 0 if there isn't
     */
    public int checkForTie(){
        for (int i = 0; i < 6; i++) { //row loop
            for (int j = 0; j < 7; j++) { //column loop
                if (board[i][j] == 0) {
                    return 0; //there is an empty space
                }
            }
        }
        return 1; //returns 1 if there is no empty space - tie
    }
}