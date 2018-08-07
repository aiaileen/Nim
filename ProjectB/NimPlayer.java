/** COMP90041 Project B
 *  Author: Ailin Zhang
 *  StudentID: 874810
 *  Username: ailinz1
 */

/** This NimPlayer is the Class for setting up different player objects.
 */
public class NimPlayer {
    private String username;
    private String givenName;
    private String familyName;
    private int playedGames;
    private int wonGames;
    private double winningRatio;

    /**
     * NimPlayer is the Constructor for setting up the player object's name.
     */
    public  NimPlayer(String username,String givenName,String familyName) {
    	this.username=username;
        this.givenName=givenName;
        this.familyName=familyName;
    }

    /**
     * The removeStone() is the method for printing out the promotion of removal,and
     * get the input as the number of stones removed, and decrease the number of left stones.
     */
    public void removeStone() {
        System.out.println(this.givenName+"'s turn - remove how many?");
        int removeNumber = Nimsys.keyboard.nextInt();
        //the limit of remove stone number the smaller one of either leftStone or upperBound
        int limit = NimGame.getLeftStone() > NimGame.getUpperBound() ?
                                            NimGame.getUpperBound() : NimGame.getLeftStone();

//        if (removeNumber > limit || removeNumber < 1) {
//            System.out.println();
//        	System.out.println("Invalid move. You must remove between 1 and "+limit+" stones.");
//        	removeStone();
//        }
        if (removeNumber > 0 && removeNumber <= limit) {
            NimGame.setLeftStone(removeNumber);
            return;
        }
        else {
            System.out.println();
            System.out.println("Invalid move. You must remove between 1 and "+limit+" stones.");
            removeStone();
        }

    }

    public String getUsername() {
        return username;
    }

    public String getGivenName(){
        return givenName;
    }

    public String getFamilyName(){
        return familyName;
    }

    public void editName(String newGivenName, String newFamilyName){
        givenName = newGivenName;
        familyName = newFamilyName;
    }

    public void resetStatus(){
        playedGames = 0;
        wonGames = 0;
    }

    public int getPlayedGames(){
        return playedGames;
    }

    public int getWonGames(){
        return wonGames;
    }

    public double getWinningRatio(){
        if (wonGames == 0){
            winningRatio = 0;
        }
        else {
            winningRatio = (double)wonGames / (double)playedGames;
        }
        return winningRatio;
    }

    public void addPlayedGames(){
        playedGames+=1;
    }
    public void addWonGames(){
        wonGames+=1;
    }

}
