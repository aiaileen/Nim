/** COMP90041 Project C
 *  Author: Ailin Zhang
 *  StudentID: 874810
 *  Username: ailinz1
 */

import java.io.Serializable;

/** This NimPlayer is an abstract Class for setting up different player objects.
 */
public abstract class NimPlayer implements Serializable {
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
     * The printLeftStone() Method is to display the left stones as "*"
     */
    public final void printLeftStone(){
        System.out.print("\n"+NimGame.getLeftStone()+" stones left:");
        for (int i=0;i<NimGame.getLeftStone();i++){
            System.out.print(" *");
        }
        System.out.println();
    }


    /**
     * It is a common method both in NimHumanPlayer and NimAIPlayer
     */
    public abstract void removeStone();


    /**
     * These five methods are to get the value of username, givenName,
     * familyName, playedGames, wonGames from outside of this class.
     */
    public String getUsername() {
        return username;
    }

    public String getGivenName(){
        return givenName;
    }

    public String getFamilyName(){
        return familyName;
    }

    public int getPlayedGames(){
        return playedGames;
    }

    public int getWonGames(){
        return wonGames;
    }


    /**
     * This method is to set the value of givenName and familyName from outside the class.
     */
    public void editName(String newGivenName, String newFamilyName){
        givenName = newGivenName;
        familyName = newFamilyName;
    }

    /**
     * This method is to set the value of playedGames and wonGames from ouside the class.
     */
    public void resetStatus(){
        playedGames = 0;
        wonGames = 0;
    }

    /**
     * This method is to get the value of winningRatio fron outside of the class
     * @return
     */
    public double getWinningRatio(){
        if (wonGames == 0){
            winningRatio = 0;
        }
        else {
            winningRatio = (double)wonGames / (double)playedGames;
        }
        return winningRatio;
    }

    /**
     * These two methods are to add the value of playedGames or addWonGames.
     */
    public void addPlayedGames(){
        playedGames+=1;
    }

    public void addWonGames(){
        wonGames+=1;
    }

}
