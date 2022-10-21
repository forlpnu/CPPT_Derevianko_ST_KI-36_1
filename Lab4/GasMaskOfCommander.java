/**
 * lab 4 package
 */
package ki36.derevianko.lab4;

import java.io.*;

/**
 * Class <code>GasMaskOfCommander</code> implements a gas mask of commander by extending the
 * GasMask and implementing interface
 * @author Derevianko Stanislav KI-36
 * @version 1.0
 */
public class GasMaskOfCommander extends GasMaskAbstract implements Mask {
    public static int isChargedCount;
    private SelfContainedBreathingApparatus breatheApparatus;
    /**
     * Constructor
     * @throws FileNotFoundException
     */
    public GasMaskOfCommander() throws java.io.FileNotFoundException
    {
        filter = new FilterCartridge();
        amplifier = new VoiceAmplifier();
        tube = new AssembledDrinkingDevice();
        breatheApparatus = new SelfContainedBreathingApparatus();
        fout = new PrintWriter(new File("Log.txt"));
        weightInKilos = 1.250f;
    }
    /**
     * Constructor
     * @param weight  Gas mask weight
     * @param voiceCharge Amplifier`s charge
     * @param breathingSource SCBA`s source
     * @throws FileNotFoundException
     */
    public GasMaskOfCommander(float weight, int voiceCharge,int breathingSource) throws java.io.FileNotFoundException
    {
        if(voiceCharge !=0) isChargedCount++;
        filter = new FilterCartridge();
        filter.setFilterTypeToB();
        amplifier = new VoiceAmplifier(voiceCharge);
        tube = new AssembledDrinkingDevice();
        breatheApparatus = new SelfContainedBreathingApparatus(breathingSource);
        fout = new PrintWriter(new File("Log.txt"));
        weightInKilos = 1.250f;
    }
    /**
     * Method simulates Self-Contained Breathing Apparatus system
     */
    public void activateBreathingSystem(int expenses) {
        if(breatheApparatus.getBreathingSource() == 0){
            System.out.println("\nThe Self-Contained Breathing Apparatus (SCBA) needs to be replaced because breathing source is off!");
            fout.print("\nThe Self-Contained Breathing Apparatus (SCBA) needs to be replaced because breathing source is off!\n");
            fout.flush();
        }
        else{
            breatheApparatus.supplyCleanAir(expenses);
            System.out.println("\n\nCurrent SCBA`s source is "
                    +breatheApparatus.getBreathingSource());
            fout.print("\nCurrent SCBA`s source is "
                    +breatheApparatus.getBreathingSource());
            fout.print("\n");
            fout.flush();
        }
    }
    @Override
    public boolean isChemicallyEfficient() {
        if (HAZARD_CONCENTRATION-this.filter.getBreakthroughTime()>=20) {
            System.out.println("\nThe mask is chemically efficient!");
            fout.print("\nThe mask is chemically efficient!\n");
            return true;
        }
        System.out.println("\nThe mask is not chemically efficient!");
        fout.print("\nThe mask is not chemically efficient!\n");
        return false;
    }
    @Override
    public String toString() {
        fout.print("Weight of a gas mask: " + this.weightInKilos
                + this.filter.toString() + this.amplifier.toString() + this.tube.toString() + this.breatheApparatus.toString());
        fout.print("\n");
        fout.flush();
        return "Weight of a gas mask: " + this.weightInKilos
                + this.filter.toString() + this.amplifier.toString() + this.tube.toString() + this.breatheApparatus.toString();
    }

}
class SelfContainedBreathingApparatus{
    private int breathingSource;
    private boolean isConnected;
    /**
     * Constructor
     */
    public SelfContainedBreathingApparatus(){
        isConnected = false;
        breathingSource = 1_000_000;
    }
    /**
     * Constructor
     * @param breathingSource Self Contained Breathing Apparatus`s charge
     */
    public SelfContainedBreathingApparatus(int breathingSource){
        isConnected = false;
        this.breathingSource = breathingSource;
    }
    /**
     * Method simulates connecting to the SCBA, otherwise is closed.
     */
    public void connectSCBA() {this.isConnected = true;}
    /**
     * Method returns current state of SCBA
     * @return SCBA`s current state
     */
    public boolean isConnected() {
        return this.isConnected;
    }
    /**
     * Method returns current source of SCBA
     * @return SCBA`s current source
     */
    public int getBreathingSource(){return this.breathingSource;}
    /**
     * Method simulates the supply of clean air
     */
    public void supplyCleanAir(int expenses){
        if(this.breathingSource > 0) breathingSource = breathingSource - expenses;
        else {
            breathingSource = 0;
            System.out.println("The SCBA needs to be recharged!");
        }
    }
    @Override
    public String toString() {
        return "\nThe SCBA`S current source: " + this.getBreathingSource();
    }
}

