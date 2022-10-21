/**
 * lab 3 package
 */
package ki36.derevianko.lab3;

import java.io.*;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

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
        GasMask mask1 = new GasMask(1.8f, 79);
        GasMask mask2 = new GasMask(1.8f, 45);
        GasMask mask3 = new GasMask(1.8f, 89);
        GasMask mask4 = new GasMask(1.8f, 24);
        GasMask mask5 = new GasMask(1.8f, 72);

        Optional<GasMask> minimal = Stream.of(mask1, mask2, mask3, mask4, mask5)
                .min(Comparator.comparingInt(m -> m.getAmplifier().getAmplifierCharge()));

        if(minimal.isPresent()){
            System.out.print("Quantity of masks with minimal charge: ");
            System.out.println(Stream.of(mask1, mask2, mask3, mask4, mask5)
                    .filter(m -> m.equals(minimal.get()))
                    .count());
        }

        System.out.println();
        System.out.print("Quantity of masks with minimal charge: " + GasMask.getMasksWithMinimalCharge());

        //System.out.println(mask1.amplifier.getAmplifierCharge());
        //GasMask maskPrototype = new GasMask(1.8f,80);
        //System.out.println(maskPrototype);
        //maskPrototype.connectWaterAdapter();
        //maskPrototype.dispose();
        //for(var i = 0;i<5;i++){
        //maskPrototype.activateFilter();
        //maskPrototype.connectAmplifier();
        //}
    }
}
