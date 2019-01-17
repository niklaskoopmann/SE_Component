import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.math.BigInteger;

public class EnlightenedNumbers {
    private static EnlightenedNumbers instance = new EnlightenedNumbers();
    public Port port;

    private EnlightenedNumbers() {
        port = new Port();
    }

    public class Port implements IEnlightenedNumbers {
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
        ArrayList<BigInteger> enlightenedNumbers = new ArrayList<>();
        BigInteger i = rangeFrom;
        while(i != rangeTo.add(new BigInteger("1"))){
            ArrayList<BigInteger> primeFactors = primeFactors(new BigInteger("24"));
            if ((checkFirstDigits(primeFactors,i)) != null){
                enlightenedNumbers.add(checkFirstDigits(primeFactors, i));
            }
            // i++
            i = i.add(new BigInteger("1"));
        }
        return enlightenedNumbers;
    }

    // get prime factors
    private ArrayList<BigInteger> primeFactors(BigInteger number){


        ArrayList<BigInteger> primeFactors = new ArrayList<>();
        BigInteger i = new BigInteger("2");

        while(BigInteger.ZERO.equals(number.mod(i))){
            number = number.divide(i);
            if (!primeFactors.contains(number)) {
                primeFactors.add(number);
            }
            i = i.add(new BigInteger("1"));
        }

        return primeFactors;
    }
    private BigInteger checkFirstDigits(ArrayList<BigInteger> primeFactors, BigInteger initialValue){
        // for each prime factor
        for (BigInteger temp : primeFactors){
            ArrayList<String>digitList = getDigits(initialValue);
            for (String digit : digitList){
               if (temp != (new BigInteger(digit))){
                   // one prime factor not part of initial value
                   return null;
               }
            }
        }
        return initialValue;
    }


    public ArrayList<String> getDigits(BigInteger input) {
        ArrayList<String> output = new ArrayList<>();
        String number = input.toString();

        for (int i = 0; i < number.length(); i++)
            output.add(number.substring(i, Math.min(i + 1, number.length())));

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
