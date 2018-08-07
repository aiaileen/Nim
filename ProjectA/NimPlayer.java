/** COMP90041 Project A
 *  Author: Ailin Zhang
 *  StudentID: 874810
 *  Username: ailinz1
 */

/** This NimPlayer is the Class for setting up different player objects.
 */
public class NimPlayer {
    public String name;

    /**
     * NimPlayer is the Constructor for setting up the player object's name.
     */
    public NimPlayer(String name) {
        this.name=name;
    }

    /**
     * The removeStone() is the method for printing out the promotion of removal,and
     * get the input as the number of stones removed, and decrease the number of left stones.
     */
    public void removeStone() {
        System.out.println(this.name+"'s turn - remove how many?");
        int removeNumber = Nimsys.keyboard.nextInt();
        Nimsys.leftStone -= removeNumber;
    }
}
