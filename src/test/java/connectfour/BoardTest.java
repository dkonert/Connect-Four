package connectfour;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/* you will need to add test methods and likely change the
setup method as well.  The samples that are here are just so that
you can see how junit works.

Tests are run on build unless specifically excluded with -x test.
The test results are reported in the reports subfolder of the build directory */


public class BoardTest{
    private Board tester;

    @Before
    public void setup(){
        //set up for the test
        tester = new Board();

    }

    @Test
    public void testPlace(){
        /* place 6 pieces in one column and confirm they are valid
        * place 7th pieve in the same column confirming invalid move
        */
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(tester.placePieceOnBoard(0, 1), 0);
        }
        Assert.assertEquals(tester.placePieceOnBoard(0, 1), -1);
    }

    @Test
    public void testWinnerDiagonalNone(){
        // winnerDiagonal returns 0 when no one has a winning diagonal
        Assert.assertEquals(tester.checkForWinnerDiagonal(),0);
    }
    @Test
    public void testWinnerDiagonalRightP1(){
        // winnerDiagonal returns 1 when player 1 has a winning diagonal to the right line
        tester.placePieceOnBoard(0,1);
        tester.placePieceOnBoard(1,2);
        tester.placePieceOnBoard(1,1);
        tester.placePieceOnBoard(2,2);
        tester.placePieceOnBoard(2,2);
        tester.placePieceOnBoard(2,1);
        tester.placePieceOnBoard(3,2);
        tester.placePieceOnBoard(3,2);
        tester.placePieceOnBoard(3,2);
        tester.placePieceOnBoard(3,1);
        Assert.assertEquals(tester.checkForWinnerDiagonal(),1);
    }
    @Test
    public void testWinnerDiagonalLeftP2(){
        // winnerDiagonal returns 2 when player 2 has a winning diagonal to the left line
        tester.placePieceOnBoard(3,2);
        tester.placePieceOnBoard(2,1);
        tester.placePieceOnBoard(2,2);
        tester.placePieceOnBoard(1,1);
        tester.placePieceOnBoard(1,1);
        tester.placePieceOnBoard(1,2);
        tester.placePieceOnBoard(0,1);
        tester.placePieceOnBoard(0,1);
        tester.placePieceOnBoard(0,1);
        tester.placePieceOnBoard(0,2);
        Assert.assertEquals(tester.checkForWinnerDiagonal(),2);
    }
    @Test
    public void testWinnerVHNone(){
        // winnerVH returns 0 when no one has a winning vertical or horizontal line
        Assert.assertEquals(tester.checkForWinnerVerticalHorizontal(),0);
    }
    @Test
    public void testWinnerVHP1Horizontal(){
        //returns 1 when p1 wins a horizontal line
        tester.placePieceOnBoard(0,1);
        tester.placePieceOnBoard(1,1);
        tester.placePieceOnBoard(2,1);
        tester.placePieceOnBoard(3,1);
        Assert.assertEquals(tester.checkForWinnerVerticalHorizontal(),1);
    }
    @Test
    public void testWinnerVHP2Vertical(){
        //returns 2 when p2 wins a vertical line
        tester.placePieceOnBoard(0,2);
        tester.placePieceOnBoard(0,2);
        tester.placePieceOnBoard(0,2);
        tester.placePieceOnBoard(0,2);
        Assert.assertEquals(tester.checkForWinnerVerticalHorizontal(),2);
    }
    @Test
    public void testCalcTurnEqual(){
        /* If each player has placed the same number
         * returns 1 because its player 1's turn
         */
        tester.placePieceOnBoard(0,1);
        tester.placePieceOnBoard(0,2);
        Assert.assertEquals(tester.calcTurn(),1);
    }
    @Test
    public void testCalcTurnMoreP1(){
        /* If each player 1 has placed more than player 2
         * returns 2 because its player 2's turn
         */
        tester.placePieceOnBoard(0,1);
        tester.placePieceOnBoard(0,1);
        tester.placePieceOnBoard(0,2);
        Assert.assertEquals(tester.calcTurn(),2);
    }
    @Test
    public void testCalcTurnMoreP2(){
        /* If each player 2 has placed more than player 1
         * returns 1 because its player 1's turn
         */
        tester.placePieceOnBoard(0,2);
        tester.placePieceOnBoard(0,2);
        tester.placePieceOnBoard(0,1);
        Assert.assertEquals(tester.calcTurn(),1);
    }

    @Test
    public void testToString() {
        //tests that a string is successfully generated
        tester.placePieceOnBoard(3,2);
        tester.placePieceOnBoard(2,1);
        tester.placePieceOnBoard(2,2);
        tester.placePieceOnBoard(1,1);
        tester.placePieceOnBoard(1,1);
        tester.placePieceOnBoard(1,2);
        tester.placePieceOnBoard(0,1);
        tester.placePieceOnBoard(0,1);
        tester.placePieceOnBoard(0,1);
        tester.placePieceOnBoard(0,2);
        System.out.println(tester.toString());
    }
}
