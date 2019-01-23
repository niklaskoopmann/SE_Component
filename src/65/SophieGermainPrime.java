import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class SophieGermainPrime {
    private static SophieGermainPrime instance = new SophieGermainPrime();
    public Port port;

    private SophieGermainPrime() {
        port = new Port();
    }

    public static SophieGermainPrime getInstance() {
        return instance;
    }

    public class Port implements ISophieGermainPrime {
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

    public ArrayList<BigInteger> InnerExecute(BigInteger min, BigInteger max) {
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger counter = min;
        ArrayList<BigInteger> Output = new ArrayList<>();

        do{
            if (returnPrime(counter) && returnPrime((two.multiply(counter)).add(one)))
            {
                Output.add(counter);
            }

            counter = counter.add(one);
        }while(counter.compareTo(max) < 0);
        return Output;
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
