import java.math.BigInteger;
import java.util.ArrayList;

public class StrongPrime {

    private static StrongPrime instance = new StrongPrime();

    public static StrongPrime getInstance() {
        return instance;
    }

    public Port port;

    private StrongPrime() {
        port = new Port();
    }

    public class Port implements IStrongPrime {

        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerMethodExecute(rangeFrom, rangeTo);
        }

    }

    public ArrayList<BigInteger> innerMethodExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> strongPrimes = new ArrayList<BigInteger>();
        BigInteger currentPrime2 = null;
        BigInteger currentPrime1 = null;
        BigInteger currentPrime = BigInteger.TWO;
        do {
            currentPrime2 = currentPrime1;
            currentPrime1 = currentPrime;
            currentPrime = getNextPrime(currentPrime);
            if (currentPrime2 != null && currentPrime1.compareTo(rangeFrom) >= 0 && currentPrime1.compareTo(rangeTo) <= 0)
                if (isStrongPrime(currentPrime2, currentPrime1, currentPrime))
                    strongPrimes.add(currentPrime1);
        } while (currentPrime1.compareTo(rangeTo) <= 0);
        return strongPrimes;
    }

    private BigInteger getNextPrime(BigInteger currentPrime) {
        boolean isPrimeNumber = false;
        BigInteger prime = new BigInteger(currentPrime.toString());
        do {
            prime = prime.add(BigInteger.ONE);
            isPrimeNumber = isPrime(prime);
        } while (isPrimeNumber == false);
        return prime;
    }

    private boolean isStrongPrime(BigInteger lowerPrime, BigInteger primeToCheck, BigInteger higherPrime) {
        BigInteger compare = lowerPrime.add(higherPrime);
        compare = compare.divide(BigInteger.TWO);
        return (primeToCheck.compareTo(compare) == 1);
    }

    private boolean isPrime(BigInteger n) {
        if (n.compareTo(BigInteger.TWO) == -1)
            return false;

        if ((n.compareTo(new BigInteger("2")) == 1) && n.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0)
            return false;

        BigInteger maximum = new BigInteger("1").add(n.sqrt());

        for (BigInteger i = new BigInteger("3"); i.compareTo(maximum) == -1; i = i.add(BigInteger.TWO))
            if (n.mod(i).compareTo(BigInteger.ZERO) == 0)
                return false;

        return true;
    }
}
