import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class PalindromicPrime {
    private static PalindromicPrime instance = new PalindromicPrime();
    public Port port;

    private PalindromicPrime() {
        port = new Port();
    }

    public class Port implements IPalindromicPrime {
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
        ArrayList<BigInteger> palindromicPrime = new ArrayList<>();
        BigInteger i = rangeFrom;
        while(i != rangeTo.add(new BigInteger("1"))){

            if (returnPrime(i) && getPalindrome(i) != null)
            {
                palindromicPrime.add(i);
            }
            // i++
            i = i.add(new BigInteger("1"));
        }
        return null;
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
        BigInteger palindrome = number;
        BigInteger reverse = new BigInteger("0");

        // Compute the reverse
        while (palindrome != new BigInteger("0")) {
            //int remainder = palindrome % 10;
            BigInteger remainder = palindrome.mod(new BigInteger("10"));
            reverse = reverse.multiply(new BigInteger("10")).add(remainder);
            palindrome = palindrome.divide(new BigInteger("10"));
        }

        // The integer is palindrome if integer and reverse are equal
        if(number == reverse){
            return number;
        }
        return null;
    }

}
