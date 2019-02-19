import java.math.BigInteger;
import java.util.ArrayList;

public class FactorialPrime {

    // static instance

    private static FactorialPrime instance = new FactorialPrime();

    public static FactorialPrime getInstance() {
        return instance;
    }

    // define port

    public Port port;

    private FactorialPrime() {
        port = new Port();
    }

    private ArrayList<BigInteger> calculateFactorialPrime(BigInteger rangeFrom, BigInteger rangeTo)
    {
        ArrayList<BigInteger> factorialNumbers = new ArrayList<>();


        for(;rangeFrom.compareTo(rangeTo)<=0; rangeFrom = rangeFrom.add(BigInteger.ONE))
        {

            BigInteger temp = new BigInteger("1");
            for (BigInteger i = new BigInteger("2"); i.compareTo(rangeFrom)<=0 ; i = i.add(BigInteger.ONE)) {
                temp = temp.multiply(i);
            }
            temp = temp.subtract(BigInteger.ONE);
            if (checkPrime(temp) && !factorialNumbers.contains(temp))
            {
                factorialNumbers.add(temp);
            }
            temp = temp.add(BigInteger.TWO);
            if(checkPrime(temp) && !factorialNumbers.contains(temp)) {
                factorialNumbers.add(temp);
            }

        }
        return factorialNumbers;
    }

    private boolean checkPrime(BigInteger number){
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

    public class Port implements IFactorialPrime {


        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {

            return calculateFactorialPrime(rangeFrom, rangeTo);
        }
    }
}
