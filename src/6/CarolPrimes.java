import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class CarolPrimes
{

    private CarolPrimes instance = new CarolPrimes();
    public Port port;

    public CarolPrimes getInstance()
    {
        return instance;
    }

    private CarolPrimes()
    {
        port = new Port();
    }

    public class Port implements ICarolPrimes
    {
        private Method[] methods = getClass().getMethods();

        public void listMethods()
        {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
            {

                System.out.println(methods[i]);
                System.out.println("---");
            }

        }

        public ArrayList<BigInteger> execute(BigInteger rangeFrom,
            BigInteger rangeTo)
        {
            return findprimes(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> findprimes(BigInteger rangeFrom,
        BigInteger rangeTo)
    {

        ArrayList<BigInteger> primes = new ArrayList<>();
        while (rangeTo.subtract(rangeFrom).signum() == 1)
        {
            if (BigMath.returnPrime(rangeFrom))
            {
                BigInteger curr = rangeFrom.add(new BigInteger("2"));
                BigInteger sqrtcurr = BigMath.sqrt(curr);
                if (curr.compareTo(sqrtcurr.multiply(sqrtcurr)) != 0)
                {
                    rangeFrom = rangeFrom.add(BigInteger.ONE);
                    continue;
                }
                curr = sqrtcurr.add(new BigInteger("1"));
                double logn = BigMath.logBigInteger(curr);
                double base = Math.log(2);
                double x = (logn / base) % 1;
                if (0.0 == x - (int) x)
                {
                    primes.add(rangeFrom);
                }
            }
            rangeFrom = rangeFrom.add(BigInteger.ONE);

        }
        return primes;
    }

}
