import java.math.BigInteger;
import java.util.ArrayList;

public class AdditivePrime {
    /*  Primes such that the sum of digits ia a prime is a prime. First additive primes are:
        2, 3, 5, 7, 11, 23, 29, 41, 43, 47, 61, 67, 83, 89, 101, 113, 131, 137, 139, 151
    */

    // static instance
    private static AdditivePrime instance = new AdditivePrime();
    public static AdditivePrime getInstance() {
        return instance;
    }

    // define port
    public AdditivePrime.Port port;
    // constructor
    private AdditivePrime() {
        port = new Port();
    }

    public class Port implements IAdditivePrime {
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            // get prime numbers
            ArrayList<BigInteger> additivePrimeNumbers = getPrimeNumbers(rangeFrom, rangeTo);

            // check prime numbers for additive prime
            getAdditivePrimes(additivePrimeNumbers);

            // return the numbers which accomplish the additive prime 
            return additivePrimeNumbers;
        }
    }

    private void getAdditivePrimes(ArrayList<BigInteger> primeNumbers) {
        ArrayList<BigInteger> valuesToRemove = new ArrayList<>();

        for (BigInteger bigInteger: primeNumbers) {
            if (!getDigits(bigInteger)) {
                valuesToRemove.add(bigInteger);
            }
        }

        // remove elements
        primeNumbers.removeAll(valuesToRemove);
    }

    private boolean getDigits(BigInteger currentNumber) {
        String digits = currentNumber.toString();
        int sumOfDigits = 0;

        // sum the digits
        for (int i = 0; i < digits.length(); i++) {
            int digit = (digits.charAt(i) - '0');
            sumOfDigits += digit;
        }

        BigInteger bigInteger = BigInteger.valueOf(sumOfDigits);

        // check if sum is a prime number
        return returnPrime(bigInteger);
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
