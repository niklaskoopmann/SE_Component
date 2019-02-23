import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class SmithNumber {
    private static SmithNumber instance = new SmithNumber();
    public Port port;

    private SmithNumber() {
        port = new Port();
    }

    public class Port implements ISmithNumber {
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
        ArrayList<BigInteger> arrayList = new ArrayList<>();
        BigInteger i = rangeFrom;
        for (BigInteger bi = i; bi.compareTo(rangeTo) < 0; bi = bi.add(BigInteger.ONE)) {
            if (returnPrime(bi) == false) {
                if (sumDigit(bi).equals(sumPrimeFact(bi))) {
                    arrayList.add(bi);
                }
            }
        }
            return arrayList;
    }
        static BigInteger sumDigit(BigInteger n) {
            BigInteger s = new BigInteger("0");
            BigInteger t;
            while (n.compareTo(BigInteger.ZERO) > 0) {
                if (n.compareTo(BigInteger.TEN) >0) {
                    t = n.mod(BigInteger.valueOf(10));
                    s = s.add(t);
                    n = n.divide(BigInteger.valueOf(10));
                }
                else{ s =s.add(n);
                    n = n.divide(BigInteger.valueOf(10));
                }}
            return s;
        }

        static BigInteger sumPrimeFact(BigInteger n) {
            BigInteger i =new BigInteger("2");
            BigInteger sum = new BigInteger("0");
            while (n.compareTo(BigInteger.ONE)>0){
                if (n.mod(i).compareTo(BigInteger.ZERO) == 0) {
                    sum = sum.add(sumDigit(i));
                    n = n.divide(i);
                } else {
                    i = i.add(BigInteger.valueOf(1));
                }
            }
            return sum;
        }
    static boolean returnPrime(BigInteger number) {
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
