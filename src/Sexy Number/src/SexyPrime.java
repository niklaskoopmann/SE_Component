import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class SexyPrime {
    private static SexyPrime instance = new SexyPrime();
    public Port port;

    private SexyPrime() {
        port = new Port();
    }

    public class Port implements ISexyPrime {
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
        ArrayList<BigInteger> list = new ArrayList<>();

        for (BigInteger bi = rangeFrom;
             bi.compareTo(rangeTo) < 0;
             bi = bi.add(BigInteger.ONE)) {
            // wenn zahl und zahl + 6 = prime in die Liste schreiben
             if (returnPrime(bi) && returnPrime(bi.add(BigInteger.valueOf(6)))){
                list.add(bi);
            }
        }


        return (list);

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
