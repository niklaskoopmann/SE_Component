import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

public class ChenPrime {
    /*  Prime number p is a chen prime if p+2 is either a prime or a semiprime.
        First chen primes are 2,3,5,7,11,13,17,19,23,29,31,37,41,47,53,59,67,71,83,89,101,107,109,113
    */

    // static instance
    private static ChenPrime instance = new ChenPrime();
    public static ChenPrime getInstance() {
        return instance;
    }

    // define port
    public Port port;
    // constructor
    private ChenPrime() {
        port = new Port();
    }

    public class Port implements IChenPrime {
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            // get all prime numbers from range
            ArrayList<BigInteger> allPrimes = getPrimeNumbers(rangeFrom, rangeTo);
            // chen primes
            ArrayList<BigInteger> chenPrimes;

            chenPrimes = getChenPrimes(allPrimes);

            return chenPrimes;
        }
    }

    private HashSet<BigInteger> getSemiPrimes(ArrayList<BigInteger> list) {
        // multiplies all prime numbers with each other to get semiprimes
        HashSet<BigInteger> productOfPrimes = new HashSet<>();

        for (BigInteger numberOne: list) {
            for (BigInteger numberTwo: list) {
                productOfPrimes.add(numberOne.multiply(numberTwo));
            }
        }
        return productOfPrimes;
    }

    private ArrayList<BigInteger> getChenPrimes(ArrayList<BigInteger> primeNumbers) {
        ArrayList<BigInteger> valuesToRemove = new ArrayList<>();
        ArrayList<BigInteger> valuesToRemove2 = new ArrayList<>();
        HashSet<BigInteger> semiPrimes = getSemiPrimes(primeNumbers);

        for (BigInteger bigInteger: primeNumbers) {
            if (returnPrime(bigInteger.add(BigInteger.TWO))) {
                valuesToRemove2.add(bigInteger);
            }
            if (returnSemiPrime(bigInteger.add(BigInteger.TWO), semiPrimes)) {
                valuesToRemove.add(bigInteger);
            }
        }

        valuesToRemove.addAll(valuesToRemove2);
        return valuesToRemove;
    }

    private boolean returnSemiPrime(BigInteger number, HashSet<BigInteger> semiPrimes) {
        return semiPrimes.contains(number);
    }

    private ArrayList<BigInteger> getPrimeNumbers(BigInteger rangeFrom, BigInteger rangeTo) {
        // list for prime numbers
        ArrayList<BigInteger> primeNumbersList = new ArrayList<>();

        // iterate from rangeFrom to rangeTo and add prime numbers to list
        for (BigInteger counter = rangeFrom; counter.compareTo(rangeTo) < 0; counter = counter.add(BigInteger.ONE)) {
            if (returnPrime(counter)) {
                primeNumbersList.add(counter);
            }
        }
        return primeNumbersList;
    }

    private boolean returnPrime(BigInteger number) {
        // check via BigInteger.isProbablePrime(certainty)
        if (!number.isProbablePrime(5)) return false;

        // check if even
        BigInteger two = new BigInteger("2");
        if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two))) return false;

        // find divisor if any from 3 to 'number'
        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) { // start from 3, 5, etc. the odd number, and look for a divisor if any
            if (BigInteger.ZERO.equals(number.mod(i))) // check if 'i' is divisor of 'number'
                return false;
        }
        return true;
    }
}
