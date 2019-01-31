import java.math.BigInteger;
import java.util.ArrayList;

public class WagstaffPrime {
    private static WagstaffPrime instance = new WagstaffPrime();
    public Port port;

    private ArrayList<BigInteger> wagstaffPrimeList;

    public static WagstaffPrime getInstance() {
        return instance;
    }

    private WagstaffPrime() {
        port = new Port();
        wagstaffPrimeList = new ArrayList<>();
    }

    public class Port implements IWagstaffPrime {
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerMethodExecute(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> innerMethodExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        if (!isPrime(rangeFrom)) rangeFrom = nextPrime(rangeFrom);
        for (BigInteger i = rangeFrom; i.compareTo(rangeTo) <= 0; i = nextPrime(i))
            if (isWagstaffPrime(i)) wagstaffPrimeList.add(i);

        return wagstaffPrimeList;
    }

    private boolean isPrime(BigInteger n) {
        if (n.compareTo(BigInteger.TWO) < 0) return false;
        if (n.compareTo(BigInteger.TWO) > 0 && (n.mod(BigInteger.TWO)).compareTo(BigInteger.ZERO) == 0) return false;
        BigInteger maximum = (n.sqrt()).add(BigInteger.ONE);
        for (BigInteger i = BigInteger.valueOf(3);
             i.compareTo(maximum) < 0;
             i = i.add(BigInteger.TWO))
            if ((n.mod(i)).compareTo(BigInteger.ZERO) == 0)
                return false;

        return true;
    }

    private BigInteger nextPrime(BigInteger currentNumber) {
        BigInteger i;
        for (i = currentNumber.add(BigInteger.ONE); !isPrime(i); i = i.add(BigInteger.ONE)) {
        }
        return i;
    }

    private boolean isWagstaffPrime(BigInteger n) {
        return (isPrime(n) && (isPowerOfTwo((n.multiply(BigInteger.valueOf(3))).subtract(BigInteger.ONE))));
    }

    private boolean isPowerOfTwo(BigInteger n) {
        return (n.compareTo(BigInteger.ZERO) != 0) && ((n.and((n.subtract(BigInteger.ONE)))).compareTo(BigInteger.ZERO) == 0);
    }
}
