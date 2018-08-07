/** COMP90041 Project C
 *  Author: Ailin Zhang
 *  StudentID: 874810
 *  Username: ailinz1
 */

/**
 * This NimAIPlayer Class is to set up player objects for AI players,
 */
public class NimAIPlayer extends NimPlayer implements Testable {
    /**
     * Inherit from NimPlayer class
     */
	public NimAIPlayer(String username,String givenName,String familyName) {
		super(username,givenName,familyName);
	}

    /**
     * The removeStone() is the method for printing out the promotion of removal,and
     * get the input as the number of stones removed, and decrease the number of left stones.
     */
    public void removeStone(){
        int removeNumber=1;
        printLeftStone();
        System.out.println(this.getGivenName()+"'s turn - remove how many?");
        if(NimGame.getLeftStone()%(NimGame.getUpperBound()+1)!=1) {
            removeNumber=(NimGame.getLeftStone()-1)%(NimGame.getUpperBound()+1);
        }
        NimGame.setLeftStone(removeNumber);

    }

    /**
     * This method is the implementation of victory guaranteed strategy.
     */
	public String advancedMove (boolean[] available, String lastMove) {
		String move = "";
		return move;
	}
}
