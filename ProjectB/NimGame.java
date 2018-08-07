/** COMP90041 Project B
 *  Author: Ailin Zhang
 *  StudentID: 874810
 *  Username: ailinz1
 */

/** This NimGame is the Class implements the gamming details of Nim.
 */

public class NimGame {
    private static int leftStone;
    private static int upperBound;
    //private NimPlayer player_1;
    //private NimPlayer player_2;

    public NimGame(int leftStone,int upperBound,NimPlayer player_1,NimPlayer player_2) {
        this.leftStone=leftStone;
        this.upperBound=upperBound;
        //this.player_1=player_1;
        //this.player_2=player_2;

        /**initialize the game and user details
         */
        System.out.println();
        System.out.println("Initial stone count: "+leftStone);
        System.out.println("Maximum stone removal: "+upperBound);
        System.out.println("Player 1: "+ player_1.getGivenName()+" "+
                                                                player_1.getFamilyName());
        System.out.println("Player 2: "+ player_2.getGivenName()+" "+
                                                                player_2.getFamilyName());
        //NimPlayer winner = null;
        int winner = 0;
        player_1.addPlayedGames();
        player_2.addPlayedGames();

        while (this.leftStone>0) {
            printLeftStone();//Call the method.

            /**Call the method in NimPlayer Class,and decrease the number of left stones.
             */

            player_1.removeStone();
            if (this.leftStone==0) {//if there is no stone left, then player_2 wins.
                winner = 2;
                break;
            }

            printLeftStone();
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
     * The printLeftStone() Method is to display the left stones as "*"
     */
    private void printLeftStone(){
        //System.out.println();
        System.out.print("\n"+leftStone+" stones left:");
        for (int i=0;i<leftStone;i++){
            System.out.print(" *");
        }
        System.out.println();
    }

    public static int getUpperBound() {
        return upperBound;
    }

    public static int getLeftStone() {
        return leftStone;
    }

    public static void setLeftStone(int removeNumber) {
        NimGame.leftStone -= removeNumber;
    }
}