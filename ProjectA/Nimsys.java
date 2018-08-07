/** COMP90041 Project A
 *  Author: Ailin Zhang
 *  StudentID: 874810
 *  Username: ailinz1
 */

import java.util.Scanner;

/** This Nimsys is the Class for a simple variant of the game of Nim.
 */
public class Nimsys {
    public static Scanner keyboard = new Scanner(System.in);
    public int leftStone;

    /**
     * This main Method is for the rules of the Nim game.
     */
    public static void main(String[] args){
        System.out.println("Welcome to Nim\n");
        System.out.println("Please enter Player 1's name:");
        String player1Name = keyboard.next();
        NimPlayer player_1 = new NimPlayer(player1Name);
        System.out.println("\nPlease enter Player 2's name:");
        String player2Name = keyboard.next();
        NimPlayer player_2 = new NimPlayer(player2Name);
        /** This loop is designed for multiple times of playing.
         */
        while (true){
            playOneGame();
//            /** initializing the game. */
//            System.out.println("\nPlease enter upper bound of stone removal:");
//            int upperBound = keyboard.nextInt();
//            System.out.println("\nPlease enter initial number of stones:");
//            leftStone = keyboard.nextInt();
//            String winner = "";

//            while (leftStone>0) {
//                printLeftStone();//Call the method.
//                player_1.removeStone();
//                /**Call the method in NimPlayer Class,and decrease the number of left stones.
//                 */
//                if (leftStone == 0) {
//                    //if there is no stone left, then player_2 wins.
//                    winner = player_2.name;
//                    break;
//                }
//                printLeftStone();
//                player_2.removeStone();//Same with player_1 above, player_2 removes the stone.
//                winner = player_1.name;//winner variable remains as player_1 unless player_2 wins.
//            }
//            System.out.println("\nGame Over\n"+ winner+" wins!\n");
//            System.out.print("Do you want to play again (Y/N):");
//            /* if the input is not "Y", then quit the game. */
//            if (!keyboard.next().equals("Y")) break;

        }
    }
    private static void playOneGame(){
        /** initializing the game. */
        System.out.println("\nPlease enter upper bound of stone removal:");
        int upperBound = keyboard.nextInt();
        System.out.println("\nPlease enter initial number of stones:");
        leftStone = keyboard.nextInt();
        String winner = "";

        while (leftStone>0) {
            printLeftStone();//Call the method.
            player_1.removeStone();
            /**Call the method in NimPlayer Class,and decrease the number of left stones.
             */
            if (leftStone == 0) {
                //if there is no stone left, then player_2 wins.
                winner = player_2.name;
                break;
            }
            printLeftStone();
            player_2.removeStone();//Same with player_1 above, player_2 removes the stone.
            winner = player_1.name;//winner variable remains as player_1 unless player_2 wins.
        }
        System.out.println("\nGame Over\n"+ winner+" wins!\n");
        System.out.print("Do you want to play again (Y/N):");
            /* if the input is not "Y", then quit the game. */
        if (!keyboard.next().equals("Y")) break;
    }

    private static void displayTheWinner(){

    }

    /**
     * This printLeftStone() Method is for: printing out the number of left stones and
     *  displaying them as '*'.
     */
    private static void printLeftStone(){
        System.out.print("\n"+leftStone+" stones left:");
        for (int i=0;i<leftStone;i++){
            System.out.print(" *");
        }
        System.out.println();
    }
}
