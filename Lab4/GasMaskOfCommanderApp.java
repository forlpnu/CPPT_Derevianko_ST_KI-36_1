/**
 * lab 4 package
 */
package ki36.derevianko.lab4;
import java.io.FileNotFoundException;

/**
 * Gas Mask Of Commander  Application class implements main method for GasMaskOfCommander class possibilities demonstration
 * @author Derevianko Stanislav KI-36
 * @version 1.0
 */
public class GasMaskOfCommanderApp {
    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args)throws FileNotFoundException
    {
        int nominalForBreathing = 5;
        GasMaskOfCommander [] masks = new GasMaskOfCommander[3];
        masks[0] = new GasMaskOfCommander();
        masks[1] = new GasMaskOfCommander(1.275f,30,100);
        masks[2] = new GasMaskOfCommander(4.5f,0,200);
        System.out.println(masks[1]);
        for(var i = 0;i<2;i++) {
            masks[1].activateBreathingSystem(nominalForBreathing);
            //masks[2].activateBreathingSystem(nominalForBreathing);
        }
        masks[1].isChemicallyEfficient();
        for(var object: masks)
            //if(object.getBreakthroughTime() > 1) System.out.println("Charged!");
            object.dispose();
    }
}
