import java.math.BigInteger;
import java.util.ArrayList;

public class NivenPrime {
    private static NivenPrime instance = new NivenPrime();
    public Port port;

    public static NivenPrime getInstance() {
        return instance;
    }

    private ArrayList<BigInteger> nivenPrimeList;

    private NivenPrime() {
        port = new Port();
        nivenPrimeList = new ArrayList<>();
    }

    public class Port implements INivenPrime {
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerMethodExecute(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> innerMethodExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        if (!isPrime(rangeFrom)) rangeFrom = nextPrime(rangeFrom);
        for (BigInteger i = rangeFrom; i.compareTo(rangeTo) <= 0; i = nextPrime(i))
            if ((i.mod(sumOfDigits(i))).compareTo(BigInteger.ZERO) == 0)
                nivenPrimeList.add(i);
        return nivenPrimeList;
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

    private BigInteger sumOfDigits(BigInteger n) {
        BigInteger sum = BigInteger.ZERO;
        while (BigInteger.ZERO.compareTo(n) != 0) {
            sum = (n.mod(BigInteger.TEN)).add(sum);
            n = n.divide(BigInteger.TEN);
        }
        return sum;
    }
}
