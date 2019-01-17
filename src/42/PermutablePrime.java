import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class PermutablePrime {
    private static PermutablePrime instance = new PermutablePrime();
    public Port port;

    private PermutablePrime() {
        port = new Port();
    }

    public class Port implements IPermutablePrime {
        private Method[] methods = getClass().getMethods();

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return InnerExecute(rangeFrom,rangeTo);
        }

        public void listMethods() {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
                if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
            System.out.println("---");
        }
    }
// todo: hier code
    // todo: hier testen
    public ArrayList<BigInteger> InnerExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> permutablePrime = new ArrayList<>();
        BigInteger i = rangeFrom;
        while(i != rangeTo.add(new BigInteger("1"))){
            // check if prime
            if (returnPrime(i) && returnPrime(reverseNumber(i))){
                permutablePrime.add(i);
            }
            // i++
            i = i.add(new BigInteger("1"));
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
    // todo: test
    private BigInteger reverseNumber (BigInteger number){
        BigInteger reversedNum = new BigInteger("0");
        BigInteger input = number;

        while (input != new BigInteger("0")) {
            reversedNum = reversedNum.multiply(new BigInteger("10")).add(input.mod(new BigInteger("10")));
            input = input.divide(new BigInteger("10"));
        }

        return (BigInteger) reversedNum;
    }

}
