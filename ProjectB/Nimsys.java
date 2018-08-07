/** COMP90041 Project B
 *  Author: Ailin Zhang
 *  StudentID: 874810
 *  Username: ailinz1
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/** This Nimsys is the Class for the second variant of the game of Nim.
 */


public class Nimsys {
    public static Scanner keyboard = new Scanner(System.in);
    public NimPlayer[] players=new NimPlayer[99];
    public static int playerNumber=0;


    /**
     * This main Method is for the rules of the Nim game.
     */
    public static void main(String[] args){
        System.out.println("Welcome to Nim");
        format();
        Nimsys nimsys = new Nimsys();

        while(true) {
            String command=keyboard.next();

            /**
             * when the system status is idle:
             */
            if(command.equals("addplayer")) {
                String input=keyboard.next();
                String[] name=input.split(",");
                nimsys.addPlayer(name[0],name[1],name[2]);//call the addPlayer method
            }

            if(command.equals("removeplayer")) {
                String input=keyboard.nextLine();
                nimsys.removePlayer(input);//call the removePlayer method
            }

            if(command.equals("editplayer")) {
                String input=keyboard.next();
                String[] name=input.split(",");
                nimsys.editPlayer(name[0],name[1],name[2]);
            }

            if(command.equals("resetstats")) {
                String input = keyboard.nextLine();
                nimsys.resetStats(input);//call the resetstats method
            }

            if(command.equals("displayplayer")) {
                String input = keyboard.nextLine();
                nimsys.displayPlayer(input);//call the displayPlayer method
            }

            if(command.equals("rankings")) {
                String input = keyboard.nextLine();
                nimsys.rankings(input);//call the rankings method
            }


            /**
             * when the system status is gaming:
            */
            if(command.equals("startgame")) {
                String input=keyboard.next();
                input=input.trim();
                String[] arg=input.split(",");
                int leftStone=Integer.parseInt(arg[0]);
                int upperBound=Integer.parseInt(arg[1]);
                int i,j;
                for(i=0;i<playerNumber;i++) {//find player i with the username of player 1
                    if(nimsys.players[i].getUsername().equals(arg[2])) {
                        break;
                    }
                }
                for(j=0;j<playerNumber;j++) {//find player j with the username of player 2
                    if(nimsys.players[j].getUsername().equals(arg[3])) {
                        break;
                    }
                }
                if(i==playerNumber|| j==playerNumber) {//didn't find usernames
                    System.out.println("One of the players does not exist.");
                    format();
                    //break;
                }
                else{
                    NimGame newGame = new NimGame(leftStone,upperBound,
                            nimsys.players[i],nimsys.players[j]);
                    format();
                }
            }

            /**
             *  exit the Nim Game, when the command "exit" is given
             */
            if(command.equals("exit")) {
                System.out.println();
                System.exit(0);
            }
        }
    }


    /**
     * This format Method is used to display the regular format after the program output
     */
    public static void format() {
        System.out.println();
        System.out.print("$");
    }


    /**
     * This addPlayer Method is used when the command "addplayer" is given
     * Create and add a new NimPlayer object to the array players[], when the user is not in array
     * @param username is the first substring after the command from keyboard
     * @param familyName is the second substring after the command from keyboard
     * @param givenName is the third substring after the command from keyboard
     */
    public void addPlayer(String username,String familyName,String givenName) {
    	for(int i=0;i<playerNumber;i++) {
    		if(players[i].getUsername().equals(username)) {
    			System.out.println("The player already exists.");
    			format();
    			return;
    		}
    	}
        players[playerNumber]=new NimPlayer(username,givenName,familyName);
        playerNumber++;
        format();
    }


    /**
     * This removePlayer Method is used when the command "removerpalyer" is input
     * @param removeUsername is the string after the command from the keyboard input
     * if the removeUsername is "", then remove all users
     * if the removeUsername is one of the players[],
     *                      move each players behind it in players[] one position forward
     * if the removeUsername is not in the players[], print "The player does not exist."
     */
    public void removePlayer(String removeUsername) {
        /**remove all users
         */
        if (removeUsername.equals("")){
            System.out.println("Are you sure you want to remove all players? (y/n)");
            if (keyboard.nextLine().equals("y")){
                playerNumber=0;
                //players=null;
                format();
            }
            return;
        }

        /**remove an exist user
         */
        removeUsername = removeUsername.trim();//remove the space between command and uername
    	for(int i=0;i<playerNumber;i++) {
    		if(players[i].getUsername().equals(removeUsername)) {
    		    for(int j=i;j<playerNumber-1;j++){
    		        players[j]=players[j+1];
                }
                players[playerNumber-1]=null;
                playerNumber--;
                format();
    			return;
    		}
    	}

        /**didn't find the removeName in the players[]:
         * remove a nonexistent user
         */
        System.out.println("The player does not exist.");
        format();
        return;
    }


    /**
     * This editPlayer Method is used to update the player's name details, when the command
     *                                                                  "editplayer" is input.
     * @param username is the first substring after the command.
     * @param newFamilyName is the second substring after the command.
     * @param newGivenName is the third substring after the command.
     * These are given by the ketboard input
     */
    public void editPlayer(String username, String newFamilyName, String newGivenName){
        username = username.trim();//remove the space after command
        for (int i=0; i<playerNumber; i++){
            if (players[i].getUsername().equals(username)){
                players[i].editName(newGivenName, newFamilyName);
                format();
                return;
            }
        }
        System.out.println("The player does not exist.");
        format();
        return;
    }


    /**
     * This resetStats Method is used when the command "resetstats" is given
     * @param resetUsername is the string after the command given by the keyboard input.
     * If the resetUsername is "", then reset all users' status,
     *                      that is, replace all players' playedGame and wonGames into 0.
     * If the resetUsername is a username of players[], then only reset this user's status.
     * If the resetUsername is not in the players[], then output this user is not exist.
     */
    public void resetStats(String resetUsername){
        /**reset all users status
         */
        if (resetUsername.equals("")){
            System.out.println("Are you sure you want to reset all player statistics? (y/n)");
            if (keyboard.nextLine().equals("y")){
                for (int i=0; i<playerNumber; i++){
                    players[i].resetStatus();
                }
            }
            format();
            return;
        }

        /**reset an exist user status
         */
        resetUsername = resetUsername.trim();
        for (int i=0; i<playerNumber; i++){
            if (players[i].getUsername().equals(resetUsername)){
                players[i].resetStatus();
                format();
                return;
            }
        }

        /**didn't find the resetUsername
         * reset a non-existent user
         */
        System.out.println("The player does not exist.");
        format();
        return;
    }


    /**
     * This displayPlayer Method is called when the command "displayplayer" is given
     * @param displayUsername is the input string after the command from keyboard.
     * Similarly, if the displayUsername is "", then display all players' details,
     *                       and sorting the username alphabetically.
     * If the displayUsername is a username of players[], then only display this player's details.
     * If the displayerUsername is not exist in players[], then output "The player does not exist."
     */
    public void displayPlayer(String displayUsername){
        if (displayUsername.equals("")){
            Arrays.sort(players,0,playerNumber,cmp);
            for (int i=0;i<playerNumber;i++){
                System.out.print(players[i].getUsername()+","+players[i].getGivenName()+","
                        +players[i].getFamilyName()+","+players[i].getPlayedGames()+" games,"
                        +players[i].getWonGames()+" wins\n");
            }
            format();
            return;
        }

        /**display an given user
         */
        int i;
        displayUsername=displayUsername.trim();
        for (i=0;i<playerNumber;i++){
            if (players[i].getUsername().equals(displayUsername)){
                break;
            }
        }
        if(i==playerNumber){//didn't find the resetUsername
            System.out.println("The player does not exist.");
            format();
            return;
        }
        else {
            System.out.print(players[i].getUsername()+","+players[i].getGivenName()+","
                        +players[i].getFamilyName()+","+players[i].getPlayedGames()+" games,"
                        +players[i].getWonGames()+" wins\n");
            format();
            return;
        }
    }


    /**
     * This rankings Method is called when the command "rankings" is input
     * @param order is the string after the command from keyboard.
     *              a valid order is whether "" or " desc" or " asc"
     * If the order is "" or "desc", then sort the players descendingly according to the ratio.
     * If the order is "asc", sort the players[] ascendingly according to the ratio.
     * if the ratio is same. then sort the username alphabetically.
     */
    public void rankings(String order){
        int displayNumber = (playerNumber>10)?10:playerNumber;
        if (order.equals("") || order.equals(" desc")){
            Arrays.sort(players,0,playerNumber,desc);
        }
        else{
            Arrays.sort(players,0,playerNumber,asc);
        }
        for (int i=0;i<displayNumber;i++){
            int displayRatio = (int)Math.round(players[i].getWinningRatio()*100);
            System.out.printf("%-4s",(String)(displayRatio+"%"));
            System.out.printf(" | %02d games | ",players[i].getPlayedGames());
            System.out.println(players[i].getGivenName()+" "+players[i].getFamilyName());
        }
        format();
        return;
    }



    /**
     * use player's username as comparator
     */
private static Comparator<NimPlayer> cmp = new Comparator<NimPlayer>() {
    public int compare(NimPlayer player1,NimPlayer player2) {
        return player1.getUsername().compareTo(player2.getUsername());
    }
};


    /**
     * use player's winningRatio as comparator, sorting from biggest one to the smallest.
     * if the ratio is same. then sort the username alphabetically.
     */
private static Comparator<NimPlayer>desc=new Comparator<NimPlayer>(){
    public int compare(NimPlayer player1,NimPlayer player2) {
        double ratio1 = player1.getWinningRatio();
        double ratio2 = player2.getWinningRatio();
        if(ratio1==ratio2) {
            return player1.getUsername().compareTo(player2.getUsername());
        }
        else {
            return ratio2 - ratio1>0?1:-1;
        }
    }
};


    /**
     * use player's winningRatio as comparator, sorting from smallest one to the biggest.
     */
private static Comparator<NimPlayer>asc=new Comparator<NimPlayer>(){
    public int compare(NimPlayer player1,NimPlayer player2) {
        double ratio1 = player1.getWinningRatio();
        double ratio2 = player2.getWinningRatio();
        if(ratio1 == ratio2) {
            return player1.getUsername().compareTo(player2.getUsername());
        }
        else {
            return ratio1 - ratio2 >0? 1:-1;
        }
    }
};
}