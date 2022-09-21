/**
 * lab 3 package
 */
package ki36.derevianko.lab3;
import java.io.*;
/**
 * GasMask class demonstration app
 * @author Stanislav Derevianko KI-36
 * @version 1.0
 */
public class GasMaskApp {
    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args)throws FileNotFoundException
    {
        GasMask maskPrototype = new GasMask(1.8f,80);
        System.out.println(maskPrototype);
        maskPrototype.connectWaterAdapter();
        maskPrototype.dispose();
        for(var i = 0;i<5;i++){
            maskPrototype.activateFilter();
            maskPrototype.connectAmplifier();
        }
    }
}
