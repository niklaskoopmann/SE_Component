import java.math.BigInteger;
import java.util.ArrayList;

public class KyneaPrime {
    /*  Primes of the form ((2^n)+1)^2-2. 
        First kynea prime are 2,7,23,79,1087, 66047,263167 
    */

    // static instance
    private static KyneaPrime instance = new KyneaPrime();
    public static KyneaPrime getInstance() {
        return instance;
    }

    // define port
    public Port port;
    // constructor
    private KyneaPrime() {
        port = new Port();
    }

    public class Port implements IKyneaPrime {
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            // get numbers of range
            ArrayList<BigInteger> numbersOfRange = getNumbersOfRange(rangeFrom, rangeTo);
            ArrayList<BigInteger> kyneaPrimes;

            // check prime numbers for additive prime
            kyneaPrimes = getKyeanPrimes(numbersOfRange);

            return kyneaPrimes;
        }
    }

    private ArrayList<BigInteger> getKyeanPrimes(ArrayList<BigInteger> primeNumbers) {
        ArrayList<BigInteger> valuesToRemove = new ArrayList<>();

        for (BigInteger bigInteger: primeNumbers) {
            int currentNumberAsInt = bigInteger.intValue();
            int sum = (int) Math.pow((Math.pow(2, currentNumberAsInt) + 1),2) - 2;
            BigInteger sumAsBigInteger = BigInteger.valueOf(sum);

            // check if sum is a prime number
            if (returnPrime(sumAsBigInteger)) valuesToRemove.add(sumAsBigInteger);
        }
        return valuesToRemove;
    }

    private ArrayList<BigInteger> getNumbersOfRange(BigInteger rangeFrom, BigInteger rangeTo) {
        // list for numbers
        ArrayList<BigInteger> numbers = new ArrayList<>();

        // iterate from rangeFrom to rangeTo and add prime numbers to list
        for (BigInteger counter = rangeFrom; counter.compareTo(rangeTo) < 0; counter = counter.add(BigInteger.ONE)) {
                numbers.add(counter);
        }
        return numbers;
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
