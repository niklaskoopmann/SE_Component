import java.math.BigInteger;
import java.util.ArrayList;

public class CenteredHeptagonalPrime {

    private static CenteredHeptagonalPrime instance = new CenteredHeptagonalPrime();

    public static CenteredHeptagonalPrime getInstance() {
        return instance;
    }

    public Port port;

    private CenteredHeptagonalPrime(){
        port =  new Port();
    }

    public class Port implements ICenteredHeptagonalPrime {

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return execute(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo)
    {
        ArrayList<BigInteger> list = new ArrayList<>();
        for (BigInteger i = new BigInteger("0") ;i.compareTo(rangeTo) <= 0;i = i.add(BigInteger.ONE)) {
            BigInteger num = i;
            BigInteger seven = new BigInteger("7");
            BigInteger result = (seven.multiply(num.multiply(num)).subtract(seven.multiply(num)).add(new BigInteger("2"))).divide(new BigInteger("2"));
            if (result.compareTo(rangeTo)<=0 && result.compareTo(rangeFrom)>=0) {
                if (isPrime(result)) {
                    list.add(result);
                }
            }
        }
        return list;
    }
    private static boolean isPrime(BigInteger number) {
        //check via BigInteger.isProbablePrime(certainty)
        if (!number.isProbablePrime(5))
            return false;

        //check if even
        BigInteger two = new BigInteger("2");
        if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
            return false;

        //find divisor if any from 3 to 'number'
        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) { //start from 3, 5, etc. the odd number, and look for a divisor if any
            if (BigInteger.ZERO.equals(number.mod(i))) //check if 'i' is divisor of 'number'
                return false;
        }
        return true;
    }
}
