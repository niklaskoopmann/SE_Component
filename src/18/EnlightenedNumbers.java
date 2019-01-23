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

    // todo: hinzufügen bei allen anderen Komponenten
    public static EnlightenedNumbers getInstance() {
        return instance;
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
        while(i.compareTo(rangeTo) < 0){
            ArrayList<BigInteger> primeFactors = tdFactors(i);
            if ((checkFirstDigits(primeFactors,i)) != null && (checkFirstDigits(primeFactors,i)).compareTo(new BigInteger("8")) > 0){
                enlightenedNumbers.add(checkFirstDigits(primeFactors, i));
            }
            // i++
            i = i.add(new BigInteger("1"));
        }
        return enlightenedNumbers;
    }

// get prime factors -- works
    public static ArrayList<BigInteger> tdFactors(BigInteger n)
    {
        BigInteger two = BigInteger.valueOf(2);
        ArrayList<BigInteger> fs = new ArrayList<>();

        while (n.mod(two).equals(BigInteger.ZERO))
        {
            if(!fs.contains(two)) {
                fs.add(two);
            }
            n = n.divide(two);
        }

        if (n.compareTo(BigInteger.ONE) > 0)
        {
            BigInteger f = BigInteger.valueOf(3);
            while (f.multiply(f).compareTo(n) <= 0)
            {
                if (n.mod(f).equals(BigInteger.ZERO))
                {
                    if (!fs.contains(f)) {
                        fs.add(f);
                    }
                    n = n.divide(f);
                }
                else
                {
                    f = f.add(two);
                }
            }
            if (!fs.contains(n)) {
                fs.add(n);
            }
        }
        return fs;
    }


// static entfernt
    // number n is enlightened if it begins with the concatenation of its distinct prime factors
    private BigInteger checkFirstDigits(ArrayList<BigInteger> primeFactors, BigInteger initialValue){
        // for each prime factor
        ArrayList<String> digitList = getDigits(initialValue);
        int index = 0;


        for (BigInteger factor : primeFactors) {
            if (factor.toString().length() == 1) {
                if ((index < 2) && (factor.equals(new BigInteger(digitList.get(index))))) {
                    return null;
                }
                index++;
            } else {
                String number = "";
                for (int i = index; i <= factor.toString().length(); i++) {
                    number += digitList.get(i);
                }
                if ((index < 2) && (factor.equals(new BigInteger(number)))) {
                    return null;
                }
                index += factor.toString().length();
            }
        }

        return initialValue;
        /*// for each prime factor
        for (BigInteger step : primeFactors) {

            // todo: change this for e.g. 2176
            if ((index < 2) && (step.equals(new BigInteger(digitList.get(index)))))
            {
                return null;
            }

           // if(step.compareTo(new BigInteger(digitList.get(index))) != 0) {
           //     return null;
           // }
            index++;
        }
        return initialValue;*/
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
