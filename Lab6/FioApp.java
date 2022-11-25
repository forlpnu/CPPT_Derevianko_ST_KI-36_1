package ki36.derevianko.lab6;

import ki36.derevianko.lab5.CalculationException;
import ki36.derevianko.lab5.Equations;

import java.io.*;
import java.util.*;

import static java.lang.System.out;
/**
 * Class <code>FioApp</code> Implements driver for Fio class
 * @author Stanislav Derevianko
 * @version 1.0
 */
public class FioApp {
    /**
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {

        Fio obj = new Fio();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter X: ");
        int data = s.nextInt();
        double res = 0;
        try {
            Equations eq = new Equations();
            res = eq.calculate(data);
        }
        catch (CalculationException ex)
        {
            out.print(ex.getMessage());
        }
        obj.setResult(res);
        System.out.println("Result is: " + obj.getResult());
        obj.writeResTxt("textRes_6.txt");
        obj.writeResBin("BinRes_6.bin");
        obj.readResBin("BinRes_6.bin");
        System.out.println("Result is: " + obj.getResult());
        obj.readResTxt("textRes_6.txt");
        System.out.println("Result is: " + obj.getResult());
    }
}
/**
 * Class <code>Fio</code> implements methods for writing and reading into txt, bin formats
 * @author Stanislav Derevianko
 * @version 1.0
 */
class Fio
{
    public void writeResTxt(String fName) throws FileNotFoundException
    {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%.18f ",result);
        f.close();
    }
    public void readResTxt(String fName)
    {
        try
        {
            File f = new File (fName);
            if (f.exists())
            {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            }
            else
                throw new FileNotFoundException("File " + fName + "not found");
        }
        catch (FileNotFoundException ex)
        {
            System.out.print(ex.getMessage());
        }
    }
    public void writeResBin(String fName) throws FileNotFoundException, IOException
    {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }
    public void readResBin(String fName) throws FileNotFoundException, IOException
    {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }
    public double getResult()
    {
        return result;
    }
    public void setResult(double result) { this.result = result;}
    private double result;
}