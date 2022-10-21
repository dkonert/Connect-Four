package connectfour;

public class ConnectFour{


    public static void main(String[] args) {
        Board board = new Board();
        boolean done = false;
        int response = -1;
        int position;
        int turn = 1;
        while (response == -1) {
            response = TextUI.mainMenu();
            switch (response) {
                case 1: //If they want to play
                    break;
                case 2:
                    //Get file name and try to load until valid file is found
                    while (board.load(TextUI.filename()) != 0) {
                        TextUI.failToLoad();
                    }
                    turn = board.calcTurn();
                    break;
                case 3:
                    done = true; //Quit Program
                    break;
                default:
                    TextUI.invalidChoice();
                    response = -1;
            }
        }
        while (!done) {
            position = TextUI.turn(turn, board.toString());
            if (position == -1) {
                while (board.save(TextUI.filename()) != 0) { //Get filename and tries to save file until valid
                    TextUI.failToSave();
                }
                return;
            }
            if (board.place(position, turn) == -1) {
                TextUI.invalidMove();
                continue;
            }
            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }
            int winner = board.winner();
            if (winner != 0) {
                TextUI.winner(winner, board.toString());
                done = true;
            }
        }
    }
}