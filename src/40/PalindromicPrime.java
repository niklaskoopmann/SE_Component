import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class PalindromicPrime {
    private static PalindromicPrime instance = new PalindromicPrime();
    public Port port;

    public static PalindromicPrime getInstance() {
        return instance;
    }

    private PalindromicPrime() {
        port = new Port();
    }

    public class Port implements IPalindromicPrime {
        private Method[] methods = getClass().getMethods();

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return InnerExecute(rangeFrom,rangeTo);
        }
    }

    public ArrayList<BigInteger> InnerExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> palindromicPrime = new ArrayList<>();
        for (BigInteger f = rangeFrom; f.compareTo(rangeTo)<=0;f.add(BigInteger.ONE)){
            f= getNextPrime(f);
            if (f.compareTo(getPalindrome(f))==0 && returnPrime(getPalindrome(f)))
            {
                palindromicPrime.add(f);
            }
        }
        return palindromicPrime;
    }

    public BigInteger getNextPrime(BigInteger number){
        if(number.intValue() < 2) return BigInteger.TWO;
        if(number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) number = number.subtract(BigInteger.ONE);
        do{
            number = number.add(BigInteger.TWO);
        }while(!returnPrime(number));

        return number;
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

    public static BigInteger getPalindrome(BigInteger number) {
        String reverseString = new StringBuilder(number.toString()).reverse().toString();
        BigInteger palindrome = new BigInteger(reverseString);
        return palindrome;
    }

}
