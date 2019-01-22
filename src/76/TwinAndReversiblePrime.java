import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class TwinAndReversiblePrime {
    private static TwinAndReversiblePrime instance = new TwinAndReversiblePrime();
    public Port port;

    private TwinAndReversiblePrime() {
        port = new Port();
    }

    public static TwinAndReversiblePrime getInstance() {
        return instance;
    }

    public String getVersion() {
        return "T&RP V1";
    }

    public class Port implements ITwinAndReversiblePrime {
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
            return twinAndReversiblePrime(rangeFrom, rangeTo);
        }

    }

    public ArrayList<BigInteger> twinAndReversiblePrime(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> results = new ArrayList<>();

        BigInteger a,b,c,d; //Original TwinPair and Reverse Pair
        String x,y; //String to construct the Reverse Pair

        for(BigInteger i = rangeFrom; i.compareTo(rangeTo) <= 0;i = i.add(BigInteger.ONE)) {
            //Phase 1: Get Twin Pair
            if(returnPrime(i) && returnPrime(i.add(BigInteger.TWO))) {
                //Pair found, save
                a = i;
                b = i.add(BigInteger.valueOf(2));

                //Phase 2: Build Reverse Pair
                x = a.toString();
                y = b.toString();
                x = new StringBuffer(x).reverse().toString();
                y = new StringBuffer(y).reverse().toString();
                c = new BigInteger(x);
                d = new BigInteger(y);

                //Phase 3: Check if Reverse Pair isPrime and add it to result list

                if(returnPrime(c) && returnPrime(d)) {
                    results.add(a);
                    results.add(b);
                    results.add(c);
                    results.add(d);
                }

            }
        }
        return results;
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
