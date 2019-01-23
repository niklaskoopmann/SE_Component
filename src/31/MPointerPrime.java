import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class MPointerPrime {
    private static MPointerPrime instance = new MPointerPrime();
    public Port port;

    private MPointerPrime() {
        port = new Port();
    }

    public static MPointerPrime getInstance() {
        return instance;
    }

    public class Port implements IMPointerPrime {
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
        ArrayList<BigInteger> processing = new ArrayList<>();

        BigInteger counter = rangeFrom;

        do {
            if(returnPrime(counter) && returnPrime(calcPointer(counter)) && checkIfPrimeBetween(counter)) {
                output.add(counter);
            }
            counter = counter.add(BigInteger.valueOf(1));
        } while (counter.compareTo(rangeTo) < 0);

        return output;
    }

    public boolean checkIfPrimeBetween(BigInteger a) {
        BigInteger b = calcPointer(a);
        ArrayList<String> digits = getDigits(a);

        for (String s : digits) {
            if (Integer.parseInt(s) == 0) {
                return false;
            }
        }

        for (BigInteger c = a.add(BigInteger.valueOf(1)); c.compareTo(b) < 0; c = c.add(BigInteger.valueOf(1))){
            if (returnPrime(c)) {
                return false;
            }
        }

        return true;
    }

    public BigInteger calcPointer(BigInteger a){
        ArrayList<String> digits = getDigits(a);

        BigInteger multiplyPart = BigInteger.valueOf(1);

        for (String s : digits) {
            if (Integer.parseInt(s) != 0) {
                multiplyPart = multiplyPart.multiply(new BigInteger(s));
            }
        }
        return a.add(multiplyPart);
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

   public ArrayList<String> getDigits(BigInteger input) {
        ArrayList<String> output = new ArrayList<>();
        String number = input.toString();

        for (int i = 0; i < number.length(); i++)
            output.add(number.substring(i, Math.min(i + 1, number.length())));

        return output;
    }
}
