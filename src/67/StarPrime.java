import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;

public class StarPrime
{

    private StarPrime instance = new StarPrime();
    public Port port;

    public StarPrime getInstance()
    {
        return instance;
    }

    private StarPrime()
    {
        port = new Port();
    }

    public class Port implements IStarPrime
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
                BigDecimal bigDecimal = new BigDecimal(rangeFrom).subtract(new BigDecimal(1));
                bigDecimal = bigDecimal.divide(new BigDecimal(6)).add(new BigDecimal(0.25)).sqrt(new MathContext(100000));
                BigDecimal n1 = BigDecimal.valueOf(-0.5).add(bigDecimal);
                BigDecimal n2 = BigDecimal.valueOf(-0.5).add(bigDecimal);
                if (BigMath.isIntegerValue(n1))
                {
                    primes.add(rangeFrom);
                    continue;
                }
                if (BigMath.isIntegerValue(n2))
                {
                    primes.add(rangeFrom);
                    continue;
                }
            }
            rangeFrom = rangeFrom.add(BigInteger.ONE);

        }
        return primes;
    }

}
