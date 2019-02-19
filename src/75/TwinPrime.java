import java.math.BigInteger;
import java.util.ArrayList;

public class TwinPrime {
    private BigInteger Prime = new BigInteger("0");

    private static TwinPrime instance = new TwinPrime();
    public Port port;


    private TwinPrime()
    {
        port = new Port();
    }

    public static TwinPrime getInstance()
    {
        return instance;
    }

    public class Port implements IComponent{
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo)
        {
            return innerMethodExecute(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> innerMethodExecute(BigInteger rangeFrom, BigInteger rangeTo)
    {
        ArrayList<BigInteger> bigIntegers = new ArrayList<>();

        for(BigInteger i = rangeFrom; i.compareTo(rangeTo) <= 0; i = i.add(BigInteger.ONE))
        {
            if(TwinPrimes(i))
            {
                bigIntegers.add(i);
            }
        }
        return bigIntegers;
    }

    private boolean TwinPrimes(BigInteger n)
    {
        boolean isTwinPrime = false;
        if (isPrime(n)) {
            if (isPrime(n.add(new BigInteger("2"))))
            {
                isTwinPrime = true;
            } else if(isPrime(n.subtract(new BigInteger("2"))))
            {
                isTwinPrime = true;
            }
        }
        return isTwinPrime;
    }

    private boolean isPrime(BigInteger testNumber){
        boolean isPrime = true;
        if (testNumber.compareTo(BigInteger.ONE) <= 0)
        {
            isPrime = false;
        }
        for(BigInteger divisor = new BigInteger("2"); divisor.compareTo(testNumber.divide(new BigInteger("2"))) <= 0; divisor = divisor.add(BigInteger.ONE)) {
            if (testNumber.mod(divisor).intValue() == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
