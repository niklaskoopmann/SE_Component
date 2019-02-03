import java.math.BigInteger;
import java.util.ArrayList;

public class PerniciousNumber {

    private static PerniciousNumber instance = new PerniciousNumber();

    public static PerniciousNumber getInstance() {
        return instance;
    }

    public Port port;

    private PerniciousNumber() {
        port = new Port();
    }

    public class Port implements IPerniciousNumber {

        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerMethodExecute(rangeFrom, rangeTo);
        }

    }

    public ArrayList<BigInteger> innerMethodExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> returnList = new ArrayList<BigInteger>();
        BigInteger startValue = rangeFrom;

        while (startValue.compareTo(rangeTo) <= 0) {
            int posBits = startValue.bitCount();


            if (isPrime(posBits)) {
                returnList.add(new BigInteger(startValue.toString()));
            }

            startValue = startValue.add(BigInteger.ONE);
        }

        return returnList;
    }

    public boolean isPrime(int n) {
        if (n < 2)
            return false;

        if (n > 2 && n % 2 == 0)
            return false;

        int maximum = (int) Math.sqrt(n) + 1;

        for (int i = 3; i < maximum; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }

}
