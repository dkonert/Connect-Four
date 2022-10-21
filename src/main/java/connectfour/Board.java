package connectfour;

public class Board{

    private int board[][] = new int [6][7];

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

    public int winner(){
        int match = 0;

        //Vertical Check
        for (int i = 5; i >= 3; i--){ //Row Loop
            columnLoop:
            for (int j = 0; j < 7; j++){
                match = board[i][j];
                //if there is an empty space continue to next column
                if (match == 0) {
                    continue columnLoop;
                }
                for (int k = 1; k < 4; k++){ //Loop that checks if 4 matched vertically
                    //if piece doesn't match piece above it continue to next column
                    if (match != board[i-k][j]) {
                        continue columnLoop;
                    }
                }
                return match; //return winner
            }
        }

        //Horizontal Check
        for (int i = 5; i >=0; i--){ //Row Loop
            columnLoop:
            for (int j = 0; j < 4; j++ ){
                match = board[i][j];
                //if there is an empty space continue to next column
                if (match == 0) {
                    continue columnLoop;
                }
                for (int k = 1; k < 4; k++){ //Loop that checks if 4 matched horizontally
                    //if piece doesn't match piece left of it continue to next column
                    if (match != board[i][j+k]) {
                        continue columnLoop;
                    }
                }
                return match; //return winner
            }
        }

        //Diagonal Check Left
        for(int i = 5; i >=3; i--) { //Row Loop
            columnLoop: //Left Side of Board
            for (int j = 0; j < 4; j++){
                match = board[i][j];
                //if there is an empty space continue to next column
                if (match == 0) {
                    continue columnLoop;
                }
                for (int k = 1; k < 4; k++){ //Loop that checks if 4 matched diagonal right
                    //if piece doesn't match piece upright of it continue to next column
                    if (match != board[i-k][j+k]) {
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
                //if there is an empty space continue to next column
                if (match == 0) {
                    continue columnLoop;
                }
                for (int k = 1; k < 4; k++){ //Loop that checks if 4 matched diagonal left
                    //if piece doesn't match piece up and to the left of it continue to next column
                    if (match != board[i-k][j-k]) {
                        continue columnLoop;
                    }
                }
                return match; //return winner
            }
        }

        return 0; //returns if no one won
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
/* this is a do-nothing method that was put here only so 
you could have an example of junit testing.  Once you have other
methods in the Board class and other tests you should delete
this method and this comment */
    public int returnSomething(){
        return 1;
    }

}