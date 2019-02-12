import java.math.BigInteger;
import java.util.ArrayList;

public class SumOfNPrimes {
    private BigInteger lastSum = new BigInteger("0");
    private BigInteger lastCounter = new BigInteger("0");
    private BigInteger lastNumber = new BigInteger("2");

    private static SumOfNPrimes instance = new SumOfNPrimes();
    public Port port;

    private SumOfNPrimes () {
        port = new Port();
    }

    public static SumOfNPrimes getInstance() {
        return instance;
    }

    public class Port implements IComponent {
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerMethodExecute(rangeFrom, rangeTo);
        }
    }


    public ArrayList<BigInteger> innerMethodExecute (BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> bigIntegers = new ArrayList<>();

        for (BigInteger i = rangeFrom; i.compareTo(rangeTo) <= 0; i = i.add(BigInteger.ONE)) {
            if (i.equals(checksum(nextSumOfFirstNPrimes(i)))) {
                bigIntegers.add(i);
            }
        }

        return bigIntegers;
    }

    private BigInteger sumOfFirstNPrimes(BigInteger n) {
        //long startTime = System.nanoTime();

        BigInteger counter = new BigInteger("0");
        BigInteger sum = new BigInteger("0");

        for (BigInteger i = new BigInteger("2"); counter.compareTo(n) == -1; i = i.add(BigInteger.ONE)) {
            if (isPrime(i)) {
                sum = sum.add(i);
                counter = counter.add(BigInteger.ONE);
            }
        }

        //long estimatedTime = System.nanoTime() - startTime;

        //System.out.println("Standard: " + estimatedTime);

        return sum;
    }

    private BigInteger nextSumOfFirstNPrimes(BigInteger n) {
        //long startTime = System.nanoTime();

        while (lastCounter.compareTo(n) == -1) {
            if (isPrime(lastNumber)) {
                lastSum = lastSum.add(lastNumber);
                lastCounter = lastCounter.add(BigInteger.ONE);
            }
            lastNumber = lastNumber.add(BigInteger.ONE);
        }

        //long estimatedTime = System.nanoTime() - startTime;
        //System.out.println("Next: " + estimatedTime);

        return lastSum;
    }

    private BigInteger checksum(BigInteger num) {

        if (num.compareTo(new BigInteger("9")) <= 0) {
            return num;
        }

        return num.mod(BigInteger.TEN).add(checksum(num.divide(BigInteger.TEN)));
    }

    private boolean isPrime(BigInteger testNumber){
        boolean isPrime = true;

        for(BigInteger divisor = new BigInteger("2"); divisor.compareTo(testNumber.divide(BigInteger.TWO)) <= 0; divisor = divisor.add(BigInteger.ONE)) {
            if (testNumber.mod(divisor).intValue() == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
