package ki36.derevianko.lab5;

/**
 * Class <code>CalcException</code> more precises ArithmeticException
 * @author Stanislav Derevianko
 * @version 1.0
 */
public class CalculationException extends ArithmeticException
{
    public CalculationException(){}
    public CalculationException(String cause)
    {
        super(cause);
    }
}