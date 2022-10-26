package ki36.derevianko.lab5;
/**
 * Class <code>Equations</code> implements method for sin(x) / (x + tg(x)) expression
 * calculation
 * @author Stanislav Derevianko
 * @version 1.0
 */
public class Equations
{
    /**
     * Method calculates the sin(x) / (x + tg(x)) expression
     * Method calculates the sin(x) / (x + tg(x)) expression
     * @param x Angle in degrees
     * @throws CalculationException
     */
    public double calculate(int x) throws CalculationException
    {
        double y, rad;
        rad = x * Math.PI / 180.0;
        try
        {
            y = Math.sin(rad)/(x+Math.tan(rad));
            // Якщо результат не є числом, то генеруємо виключення
            if (y == Double.NaN || y == Double.NEGATIVE_INFINITY || y == Double.POSITIVE_INFINITY ||   (x % 90 == 0 ) )
                throw new ArithmeticException();
        }
        catch (ArithmeticException ex)
        {
            // створимо виключення вищого рівня з поясненням причини виникнення помилки
            if (rad % Math.PI/2.0 != 0) throw new CalculationException("Exception reason: Illegal value of X for tangent calculation");
            else if (x==0) throw new CalculationException("Exception reason: X = 0");
            else throw new CalculationException("Unknown reason of the exception during exception calculation");
        }
        return y;
    }
}