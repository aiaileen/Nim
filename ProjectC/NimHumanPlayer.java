/** COMP90041 Project C
 *  Author: Ailin Zhang
 *  StudentID: 874810
 *  Username: ailinz1
 */

/**
 * This NimHumanPlayer Class is to set up player objects for human players,
 */
public class NimHumanPlayer extends NimPlayer{
    /**
     * Inherit from NimPlayer class
     */
    public NimHumanPlayer(String username, String givenName, String familyName) {
        super(username,givenName,familyName);
    }

    /**
     * The removeStone() is the method for printing out the promotion of removal,and
     * get the input as the number of stones removed, and decrease the number of left stones.
     */
    public void removeStone() {
        printLeftStone();
        System.out.println(this.getGivenName()+"'s turn - remove how many?");

        int limit = NimGame.getLeftStone() > NimGame.getUpperBound() ?
                NimGame.getUpperBound() : NimGame.getLeftStone();

        try {
            int removeNumber = Nimsys.keyboard.nextInt();
            /**
             * when removeNumber is not an Interger, throw exception.
             */
            if (removeNumber >= 1 && removeNumber <= limit) {
                NimGame.setLeftStone(removeNumber);
                return;
            }
            else {
                throw new InvalidMoveException(limit);
            }
        }catch (InvalidMoveException e){
            System.out.println(e.getMessage());
            removeStone();
        }
    }
}

/**
 * InvalidMoveException message is output when removeNumber is invalid.
 */
class InvalidMoveException extends Exception{
    public InvalidMoveException(int limit){
        super("Invalid move. You must remove between 1 and "+limit+" stones.");
    }
}






