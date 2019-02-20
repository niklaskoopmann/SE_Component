import java.math.BigInteger;
import java.util.ArrayList;

public class IsolatedPrime {
    // static instance

    private static IsolatedPrime instance = new IsolatedPrime();

    public static IsolatedPrime getInstance() {
        return instance;
    }

    // define port

    public Port port;

    private IsolatedPrime() {
        port = new Port();
    }

    public String getVersion() {
        return "IsolatedPrime 1.0";
    }

    public class Port implements IIsolatedPrime {

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerExecute(rangeFrom, rangeTo);
        }
    }
    private ArrayList<BigInteger> innerExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> primeList = getPrimeNumbers(rangeFrom, rangeTo);
        return checkIfIsolatedPrime(primeList);
    }

    private ArrayList<BigInteger> checkIfIsolatedPrime(ArrayList<BigInteger> primeList) {
        ArrayList<BigInteger> isolatedList = new ArrayList<>();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.valueOf(primeList.size())) < 0;
             i = i.add(BigInteger.ONE)) {
            if (i.compareTo(BigInteger.ONE) == 0) { continue; }

            BigInteger primeNumber = primeList.get(i.intValue());

            BigInteger primeMinusTwo = primeNumber.subtract(BigInteger.TWO);
            BigInteger primePlusTwo = primeNumber.add(BigInteger.TWO);

            if (!isPrime(primeMinusTwo) && !isPrime(primePlusTwo)) {
                isolatedList.add(primeList.get(i.intValue()));
            }
        }
        return isolatedList;
    }

    private ArrayList<BigInteger> getPrimeNumbers(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> primes = new ArrayList<>();

        for (BigInteger i = rangeFrom; i.compareTo(rangeTo) <= 0; i = i.add(BigInteger.ONE)) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private boolean isPrime(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) == 0) { return false; }
        boolean isPrimeNumber = true;

        for (BigInteger j = BigInteger.TWO; j.compareTo(number) < 0; j = j.add(BigInteger.ONE)) {
            BigInteger modulo = number.mod(j);
            if (modulo.compareTo(BigInteger.ZERO) == 0) {
                isPrimeNumber = false;
                break;
            }
        }

        return isPrimeNumber;
    }
}
