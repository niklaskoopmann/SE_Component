import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class CenteredTriangularPrime {
    private static CenteredTriangularPrime instance = new CenteredTriangularPrime();
    public Port port;

    private CenteredTriangularPrime() {
        port = new Port();
    }

    public static CenteredTriangularPrime getInstance() {
        return instance;
    }

    public String getVersion() {
        return "CTP V1";
    }

    public static class Port implements ICenteredTriangularPrime {
        private Method[] methods = getClass().getMethods();

        public void listMethods() {
            System.out.println("---public methods for " +getClass().getName());
            for(int i = 0; i< methods.length;i++) {
                if(!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
                System.out.println("---");
            }
        }

        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return centeredTriangularPrime(rangeFrom, rangeTo);
        }

    }

    public static ArrayList<BigInteger> centeredTriangularPrime(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> results = new ArrayList<>();
        BigInteger a,b,c;
        for(BigInteger i = rangeFrom; (i.compareTo(rangeTo)) <=0 ;i = i.add(BigInteger.ONE)) {
            c = i;
            a = c.multiply(c);
            a = a.multiply(BigInteger.valueOf(3));
            b = c.multiply(BigInteger.valueOf(3));
            c = a.add(b);
            c = c.add(BigInteger.valueOf(2));
            c = c.divide(BigInteger.valueOf(2));
            if(returnPrime(c))
                results.add(c);
        }



        return results;
    }

    public static boolean returnPrime(BigInteger number) {
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
