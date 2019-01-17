import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class MagnanimousNumber {
    private static MagnanimousNumber instance = new MagnanimousNumber();
    public Port port;

    private MagnanimousNumber() {
        port = new Port();
    }

    public static MagnanimousNumber getInstance() {
        return instance;
    }

    public String getVersion() {
        return "MN V1";
    }

    public class Port implements IMagnanimousNumber{
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
            return magnanimousNumber(rangeFrom, rangeTo);
        }

    }

    public ArrayList<BigInteger> magnanimousNumber(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> results = new ArrayList<>();
        String substring1;
        String substring2;
        BigInteger a,b,c;
        String iToString;
        for(BigInteger i = rangeFrom;(i.compareTo(rangeTo)) <=0;i = i.add(BigInteger.valueOf(1)))
            for (int j = 0; j <i.toString().length()-1; j++) {

                //divide into 2 Strings
                iToString = String.valueOf(i);
                substring1 = iToString.substring(0, j + 1);
                substring2 = iToString.substring(j + 1);

                //converting back into BigInteger
                a = new BigInteger(substring1);
                if(substring2.equals(""))
                    b = BigInteger.valueOf(0);
                else
                    b = new BigInteger(substring2);

                //Check if MAgnanimousNumber is Prime
                c = b.add(a);
                if (returnPrime(c)) {
                    results.add(i);
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
