package connectfour;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Board{

    private int[][] board= new int[6][7];

    public Board(){} //creates a new board

    //Functions
    public int place(int position, int player) {

        for (int i = 5; i >= 0; i--) {
            if (board[i][position] == 0) {
                board[i][position] = player;

                return 0;
            }
        }

        return -1;
    }

    public int winnerDiagonal(){
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
    public int winnerVH(){
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

    public int winner(){
        int winnerVH = winnerVH();
        int winnerD = winnerDiagonal();

        if (winnerVH != 0) {
            return winnerVH;
        }

        return winnerD;
    }
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
                    board[i][j] = Integer.parseInt(splitLine[j]);
                    if ((board[i][j] < 0) || (board[i][j] > 2)) {
                        return -1;
                    }

                }
            }
        } catch (FileNotFoundException e) {
            return -1;
        }

        return 0;

    }

    public int calcTurn() {
        int moveP1 = 0;
        int moveP2 = 0;

        for (int i = 0; i < 6; i++){ //Row Loop
            for (int j = 0; j < 7; j++){ //Column Loop
                if (board[i][j] == 1){
                    moveP1++;
                } else if (board[i][j] == 2) {
                    moveP2++;
                }
            }
        }

        if (moveP2 >= moveP1) {
            return 1;
        } else {
            return 2;
        }

    }

}