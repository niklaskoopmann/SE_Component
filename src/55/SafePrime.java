import java.math.BigInteger;
import java.util.ArrayList;

public class SafePrime {
    private static SafePrime instance = new SafePrime();
    public Port port;

    public static SafePrime getInstance() {
        return instance;
    }

    private ArrayList<BigInteger> safePrimeList;

    private SafePrime() {
        port = new Port();
        safePrimeList = new ArrayList<>();
    }

    public class Port implements ISafePrime {
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerMethodExecute(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> innerMethodExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        if (!isPrime(rangeFrom)) rangeFrom = nextPrime(rangeFrom);
        for (BigInteger i = rangeFrom; i.compareTo(rangeTo) <= 0; i = nextPrime(i))
            if (isSafePrime(i)) safePrimeList.add(i);

        return safePrimeList;
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

    private boolean isSafePrime(BigInteger n) {
        return isSophieGermainPrime((n.subtract(BigInteger.ONE)).divide(BigInteger.TWO));
    }

    private boolean isSophieGermainPrime(BigInteger n) {
        return isPrime(n) && isPrime(BigInteger.TWO.multiply(n).add(BigInteger.ONE));
    }
}
