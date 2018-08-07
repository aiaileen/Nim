/** COMP90041 Project C
 *  Author: Ailin Zhang
 *  StudentID: 874810
 *  Username: ailinz1
 */

/** This NimGame is the Class implements the gamming details of Nim.
 */

public class NimGame {
    private static int leftStone;
    private static int upperBound;


    public NimGame(int leftStone,int upperBound,NimPlayer player_1,NimPlayer player_2) {
        this.leftStone=leftStone;
        this.upperBound=upperBound;


        /**initialize the game and user details
         */
        System.out.println();
        System.out.println("Initial stone count: "+leftStone);
        System.out.println("Maximum stone removal: "+upperBound);
        System.out.println("Player 1: "+ player_1.getGivenName()+" "+
                                                                player_1.getFamilyName());
        System.out.println("Player 2: "+ player_2.getGivenName()+" "+
                                                                player_2.getFamilyName());
        int winner = 0;
        player_1.addPlayedGames();
        player_2.addPlayedGames();

        while (this.leftStone>0) {
            /**Call the method in NimPlayer Class,and decrease the number of left stones.
             */
            player_1.removeStone();
            if (this.leftStone==0) {//if there is no stone left, then player_2 wins.
                winner = 2;
                break;
            }
            player_2.removeStone();
            winner = 1;//winner variable remains as player_1 unless player_2 wins.
        }

        System.out.println("\nGame Over");
        if (winner == 1){
            player_1.addWonGames();
            System.out.println(player_1.getGivenName()+" "+player_1.getFamilyName()+" wins!");
        }
        else if (winner == 2){
            player_2.addWonGames();
            System.out.println(player_2.getGivenName()+" "+player_2.getFamilyName()+" wins!");
        }
        return;
    }


    /**
     * This method to get upperBound argument of this NimGame
     */
    public static int getUpperBound() {
        return upperBound;
    }


    /**
     * This method to get leftStone argument of this NimGame
     */
    public static int getLeftStone() {
        return leftStone;
    }


    /**
     * This method to set the value of leftStone argument
     */
    public static void setLeftStone(int removeNumber) {
        NimGame.leftStone -= removeNumber;
    }
}