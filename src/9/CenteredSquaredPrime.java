import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class CenteredSquaredPrime {
    private static CenteredSquaredPrime instance = new CenteredSquaredPrime();
    public Port port;

    private CenteredSquaredPrime() {
        port = new Port();
    }

    public static CenteredSquaredPrime getInstance() {
        return instance;
    }

    public class Port implements ICenteredSquaredPrime {
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

    public ArrayList<BigInteger> InnerExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> numbers = new ArrayList<>();
        ArrayList<BigInteger> output = new ArrayList<>();

        BigInteger counter = rangeFrom;

        do {
            numbers.add((counter.multiply(counter)).add(((counter.add(BigInteger.valueOf(1))).multiply((counter.add(BigInteger.valueOf(1)))))));
            counter = counter.add(BigInteger.valueOf(1));
        } while (counter.compareTo(rangeTo) < 0);

        for (BigInteger temp : numbers) {
            if (returnPrime(temp)) {
                output.add(temp);
            }
            if (temp.compareTo(rangeTo) > 0){
                break;
            }
        }

        return output;
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
}
