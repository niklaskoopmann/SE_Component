import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class PermutablePrime {
    private static PermutablePrime instance = new PermutablePrime();
    public Port port;

    private PermutablePrime() {
        port = new Port();
    }

    public static PermutablePrime getInstance() {
        return instance;
    }

    public class Port implements IPermutablePrime {
        private Method[] methods = getClass().getMethods();

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return InnerExecute(rangeFrom,rangeTo);
        }
    }

    public ArrayList<BigInteger> InnerExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> permutablePrime = new ArrayList<>();
        for(BigInteger f = rangeFrom; f.compareTo(rangeTo)<=0;f=f.add(BigInteger.ONE)){
            if (returnPrime(f) && returnPrime(reverseNumber(f))){
                permutablePrime.add(f);
            }
        }
        return permutablePrime;
    }

    public boolean returnPrime(BigInteger number) {
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

    private BigInteger reverseNumber (BigInteger toReverse){
        String reverseString = new StringBuilder(toReverse.toString()).reverse().toString();
        BigInteger output = new BigInteger(reverseString);
        return output;
    }

}
