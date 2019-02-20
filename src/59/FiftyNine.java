import java.math.BigInteger;
import java.util.ArrayList;

public class FiftyNine {
    // static instance

    private static FiftyNine instance = new FiftyNine();

    private FiftyNine() {
        port = new Port();
    }

    // define port

    public Port port;

    public static FiftyNine getInstance() {
        return instance;
    }

    public String getVersion() {
        return "FiftyNine 1.0";
    }

    private ArrayList<BigInteger> innerExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> primeList = getPrimeNumbers(rangeFrom, rangeTo);
        return getQuadruples(primeList);
    }

    private ArrayList<BigInteger> getQuadruples(ArrayList<BigInteger> primeList) {
        ArrayList<BigInteger> quadruplesList = new ArrayList<>();
        //Iterate through all prime numbers in range
        for (BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.valueOf(primeList.size())) < 0;
             i = i.add(BigInteger.ONE)) {
            BigInteger currentPrimeNumber = primeList.get(i.intValue());
            BigInteger six = new BigInteger("6");
            BigInteger q1 = currentPrimeNumber.add(six);
            BigInteger q2 = q1.add(six);
            BigInteger q3 = q2.add(six);

            if (checkIfPrimeNumber(q1) && checkIfPrimeNumber(q2) && checkIfPrimeNumber(q3)) {
                quadruplesList.add(primeList.get(i.intValue()));
            }

        }
        System.out.println(quadruplesList);
        return quadruplesList;

    }

    private Boolean checkIfPrimeNumber(BigInteger bigInteger) {
        for (int i = 2; i < bigInteger.intValue(); i++) {
            if (bigInteger.intValue() % i == 0)
                return false;
        }
        return true;
    }

    public class Port implements IFiftyNine {

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerExecute(rangeFrom, rangeTo);
        }
    }

    private ArrayList<BigInteger> getPrimeNumbers(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> primes = new ArrayList<>();

        for (BigInteger i = rangeFrom; i.compareTo(rangeTo) <= 0; i = i.add(BigInteger.ONE)) {
            if (i.compareTo(BigInteger.ONE) == 0) { continue; }
            boolean isPrimeNumber = true;

            for (BigInteger j = BigInteger.TWO; j.compareTo(i) < 0; j = j.add(BigInteger.ONE)) {
                BigInteger modulo = i.mod(j);
                if (modulo.compareTo(BigInteger.ZERO) == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) {
                primes.add(i);
            }
        }
        return primes;
    }
}
