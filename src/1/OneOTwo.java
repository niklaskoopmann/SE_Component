import java.math.BigInteger;
import java.util.ArrayList;

public class OneOTwo {
    // static instance

    private static OneOTwo instance = new OneOTwo();

    public static OneOTwo getInstance() {
        return instance;
    }

    // define port

    public Port port;

    private OneOTwo() {
        port = new Port();
    }

    public String getVersion() {
        return "OneOTwo 1.0";
    }

    public class Port implements IOneOTwo {

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerExecute(rangeFrom, rangeTo);
        }
    }
    private ArrayList<BigInteger> innerExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> primeList = getPrimeNumbers(rangeFrom, rangeTo);
        ArrayList<BigInteger> inverseList = getInverse(primeList);
        ArrayList<BigInteger> productList = buildProduct(primeList, inverseList);
        return checkIfProductIsPalindrome(primeList, productList);
    }

    private ArrayList<BigInteger> checkIfProductIsPalindrome(ArrayList<BigInteger> primeList, ArrayList<BigInteger> productList) {
        ArrayList<BigInteger> palindromeList = new ArrayList<>();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.valueOf(productList.size())) < 0;
             i = i.add(BigInteger.ONE)) {
            BigInteger number = productList.get(i.intValue());
            int NumberLength = number.toString().length();
            BigInteger length = BigInteger.valueOf(NumberLength);
            BigInteger j, begin, end, middle;

            begin = BigInteger.ZERO;
            end = length.subtract(BigInteger.ONE);
            middle = begin.add(end).divide(BigInteger.TWO);

            for (j = begin; j.compareTo(middle) <= 0; j = j.add(BigInteger.ONE)) {
                String inputString = productList.get(i.intValue()).toString();
                if (inputString.charAt(begin.intValue()) == inputString.charAt(end.intValue())) {
                    begin =  begin.add(BigInteger.ONE);
                    end = end.subtract(BigInteger.ONE);
                } else {
                    break;
                }
            }
            if (j.compareTo(middle.add(BigInteger.ONE)) == 0) {
                //System.out.println(primeList.get(i.intValue())+" "+productList.get(i.intValue()));
                palindromeList.add(primeList.get(i.intValue()));
            }
        }
        return palindromeList;
    }

    private ArrayList<BigInteger> buildProduct(ArrayList<BigInteger> primeList, ArrayList<BigInteger> inverseList) {
        ArrayList<BigInteger> productList = new ArrayList<>();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.valueOf(primeList.size())) < 0;
             i = i.add(BigInteger.ONE)) {
             BigInteger result = primeList.get(i.intValue()).multiply(inverseList.get(i.intValue())) ;
             productList.add(result);
        }
        return productList;
    }

    private ArrayList<BigInteger> getInverse(ArrayList<BigInteger> primeList) {

        ArrayList<BigInteger> inverseList = new ArrayList<>();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.valueOf(primeList.size())) < 0;
             i = i.add(BigInteger.ONE)) {

            String invNumber = new StringBuilder(primeList.get(i.intValue()).toString()).reverse().toString();

            BigInteger inverseInt = new BigInteger(invNumber);

            inverseList.add(inverseInt);

        }

        return inverseList;
    }

    private ArrayList<BigInteger> getPrimeNumbers(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> primes = new ArrayList<>();

        for (BigInteger i = rangeFrom; i.compareTo(rangeTo) <= 0; i = i.add(BigInteger.ONE)) {
            if (i.compareTo(BigInteger.ONE) == 0) { continue; }
            boolean isPrimeNumber = true;

            for (BigInteger j = BigInteger.TWO; j.compareTo(i) < 0; j = j.add(BigInteger.ONE)) {
                BigInteger modulo = i.mod(j);
                if (modulo.compareTo(BigInteger.ZERO) == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) {
                primes.add(i);
            }
        }
        return primes;
    }
}
