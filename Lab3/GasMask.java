/**
 * lab 3 package
 */
package ki36.derevianko.lab3;
import java.io.*;
/**
 * Class <code>GasMask</code> implements a gas mask
 * @author Stanislav Derevianko KI-36
 * @version 1.0
 */
public class GasMask {
    private FilterCartridge filter;
    private VoiceAmplifier amplifier;
    private AssembledDrinkingDevice tube;
    private PrintWriter fout;
    private float weightInKilos;
    /**
     * Constructor
     * @throws FileNotFoundException
     */
    public GasMask()throws FileNotFoundException
    {
        filter = new FilterCartridge();
        amplifier = new VoiceAmplifier();
        tube = new AssembledDrinkingDevice();
        fout = new PrintWriter(new File("Log.txt"));
        weightInKilos = 1.250f;

    }
    /**
     * Constructor
     * @param weight  Gas mask weight
     * @param charge Amplifier`s charge
     * @throws FileNotFoundException
     */
    public GasMask(float weight, int charge)throws FileNotFoundException
    {
        filter = new FilterCartridge();
        filter.setFilterTypeToAX();
        amplifier = new VoiceAmplifier(charge);
        tube = new AssembledDrinkingDevice();
        weightInKilos = weight;
        fout = new PrintWriter(new File("Log.txt"));
        //char[][] art = { {████████████████      ░░░░██████████████████},
                         //{████████████▓▓▓▓▒▒▒▒▒▒░░░░░░░░██████████████},
                         //{████████▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░░░░░░░██████████},
                         //{██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░░░░░░░████████},
                         //{████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░░░░░██████},
                         //{██████████▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓░░░░░░░░██████},
                         //{████░░▓▓████▓▓▓▓██░░▓▓████▓▓▓▓▓▓░░░░░░░░████},
                         //{████░░░░████▓▓▓▓██░░░░████▓▓▓▓▓▓██▓▓▓▓██████},
                         //{██████░░░░██▓▓▓▓████░░░░██▓▓▓▓▓▓██▓▓▓▓██████},
                         //{████████░░██▓▓▓▓██████░░██▓▓▓▓▓▓██▓▓▓▓██████},
                         //{██▓▓██████▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓██▓▓▓▓██████},
                         //{██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░░░░░████},
                         //{██░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░░░░░░░████},
                         //{██░░▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓░░░░░░░░░░████},
                         //{██████▓▓██▓▓██▓▓██▒▒▓▓████▓▓░░░░░░░░░░░░████},
                         //{████    ██▓▓██▓▓██▒▒  ████░░░░░░░░░░░░░░████},
                         //{████    ██▓▓██▓▓██▒▒  ████░░░░░░░░░░░░░░████},
                         //{████▓▓░░██▓▓██▓▓██▒▒░░████░░░░░░░░░░░░░░████},
                         //{██░░░░░░░░▓▓██▓▓░░░░░░░░░░░░░░░░░░░░░░░░████},
                         //{██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░████},
                         //{██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░████},
                         //{██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░████},
        //}
        //System.out.println(art);
        System.out.println(" ┌───────────────────────────┐");
        System.out.println("┎┤ You create a new gas mask │");
        System.out.println("┃└───────────────────────────┘");
        fout.print("You Create a new gas mask\n");

    
    }
    /**
     * Method returns current filter`s type
     * @return Filter`s current type
     */
    public FilterCartridge.FilterType getFilter() {
        return filter.getFilterType();
    }
    /**
     * Method simulates external drinking system
     */
    public void connectWaterAdapter()
    {
        if(tube.isValved()){
            System.out.println("🮱 First, you need to squeeze the valve. Now it is closed!");
            fout.print("🮱 First, you need to squeeze the valve. Now it is closed!\n");
            fout.flush();
            tube.squeezeValve();
        }
        else{
            tube.squeezeValve();
            System.out.println("\n🮱 Connection with water bottle adapter (drinking device) is finished");
            fout.print("\n🮱 Connection with water bottle adapter (drinking device) is finished\n");
            fout.flush();
        }

    }
    /**
     * Method simulates external voice amplifier system
     */
    public void connectAmplifier(){
        if(amplifier.getAmplifierCharge() <= 0){
            System.out.println("\n\nFirst, you need to recharge the amplifier!");
            fout.print("\n\nFirst, you need to recharge the amplifier!\n");
            fout.flush();
        }
        else{
            amplifier.activateAmplifier();
            System.out.println("\nConnection with voice amplifier is finished.\nCurrent charge level: "
                    +amplifier.getAmplifierCharge());
            fout.print("\nConnection with voice amplifier is finished.\nCurrent charge level: "
                    +amplifier.getAmplifierCharge());
            fout.flush();
        }
    }
    /**
     * Method simulates filter system
     */
    public void activateFilter() {
        if(filter.getFilterType() == FilterCartridge.FilterType.NONE){
            System.out.println("\nThe filter needs to be replaced because breakthrough time is off!");
            fout.print("\nThe filter needs to be replaced because breakthrough time is off!\n");
            fout.flush();
        }
        else{
            filter.purifyAir();
            System.out.print("\n\n🮥 Filter is being used. Current filter breakthrough time is "
                    +filter.getBreakthroughTime());
            fout.print("\n🮥 Filter is being used. Current filter breakthrough time is "
                    +filter.getBreakthroughTime());
            //fout.print("\n");
            fout.flush();
        }
    }
    @Override
    public String toString() {
        fout.print("┠─Weight of a gas mask: " + this.weightInKilos
                + this.filter.toString() + this.amplifier.toString() + this.tube.toString());
        fout.print("\n");
        fout.flush();
        return "┠─Weight of a gas mask: " + this.weightInKilos
                + this.filter.toString() + this.amplifier.toString() + this.tube.toString();
    }
    /**
     * Method releases used recourses
     */
    public void dispose()
    {
        fout.close();
    }


}
class FilterCartridge{
    enum FilterType {AX,A,NONE};
    private FilterType filterType;
    private float breakthroughTime;
    /**
     * Constructor
     */
    public FilterCartridge(){
        // By default, filter type is NONE, thus it`s breakthrough time is 0
        this.filterType = FilterType.NONE;
        this.breakthroughTime = 0f;
    }
    /**
     * Method sets filter`s type to AX
     */
    public void setFilterTypeToAX(){
        this.filterType = FilterType.AX;
        this.breakthroughTime = 50.0f;
    }
    /**
     * Method sets filter`s type to A
     */
    public void setFilterTypeToA(){
        this.filterType = FilterType.A;
        this.breakthroughTime = 70.0f;
    }
    /**
     * Method sets filter`s type to NONE.
     */
    public void setFilterTypeToNONE(){
        this.filterType = FilterType.NONE;
        this.breakthroughTime = 0.f;
        System.out.println("The filter needs to be replaced!");
    }
    /**
     * Method simulates purifying chemical gases and possibly particles
     */
    public void purifyAir(){
        if(this.breakthroughTime > 0) this.breakthroughTime = this.breakthroughTime - 0.1f;
        else {
            this.breakthroughTime = 0f;
            this.filterType = FilterType.NONE;
            System.out.println("The filter needs to be replaced because breakthrough time is off!");
        }
    }
    /**
     * Method returns current filter`s type
     * @return Filter`s current type
     */
    public FilterType getFilterType(){
        return this.filterType;
    }
    /**
     * Method returns current filter`s breakthrough time
     * @return Filter`s current breakthrough time
     */
    public float getBreakthroughTime() {
        return this.breakthroughTime;
    }

    @Override
    public String toString() {
        return "\n┠─Filter type: " + this.filterType +
                "\n┠─Breakthrough time (in minutes): " + this.breakthroughTime;

    }
}

class AssembledDrinkingDevice{
    private boolean isValved;
    /**
     * Constructor
     */
    public AssembledDrinkingDevice()
    {
        // In primary position the valve is closed.
        isValved = true;
    }
    /**
     * Method simulates squeezing the valve, otherwise the tube is closed.
     */
    public void squeezeValve()
    {
        this.isValved = false;
    }
    /**
     * Method returns current state of drinking device
     * @return Drinking device`s current state
     */
    public boolean isValved() {
        return isValved;
    }

    @Override
    public String toString() {
        return "\n🮱 Connection with water bottle adapter (drinking device): " + this.isValved;

    }
}

class VoiceAmplifier{
    private static final int voiceAmplifierRadius = 2;
    private int amplifierCharge;
    /**
     * Constructor
     */
    public VoiceAmplifier()
    {
        amplifierCharge = 0;
    }
    /**
     * Method sets charge
     */
    public VoiceAmplifier(int amplifierCharge)
    {
        this.amplifierCharge = amplifierCharge;
    }
    /**
     * Method simulates voice amplifier
     */
    public void activateAmplifier()
    {
        if(amplifierCharge > 0) amplifierCharge = amplifierCharge - 2;
        else {
            amplifierCharge = 0;
            System.out.println("The amplifier needs to be recharged!");
        }
    }
    /**
     * Method returns charge resource available
     * @return Amplifier charge resource available
     */
    public int getAmplifierCharge()
    {
        return amplifierCharge;
    }

    @Override
    public String toString() {
        return "\n┖─The amplifier`s charge: " + this.amplifierCharge;

    }
}
