import java.math.BigInteger;
import java.util.ArrayList;

public class TwoSidedPrime {

    private static TwoSidedPrime instance = new TwoSidedPrime();

    public static TwoSidedPrime getInstance() {
        return instance;
    }

    public Port port;

    private TwoSidedPrime() {
        port = new Port();
    }

    public class Port implements ITwoSidedPrime {

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return calculate(rangeFrom, rangeTo);
        }
    }


    private ArrayList<BigInteger> calculate(BigInteger rangeFrom, BigInteger rangeTo) {

        ArrayList<BigInteger> leftSidedPrime = isLeftSidedPrime(rangeFrom, rangeTo);
        ArrayList<BigInteger> twoSidedPrime = isRightSidedPrime(leftSidedPrime);
        return twoSidedPrime;
    }

    private ArrayList<BigInteger> isLeftSidedPrime(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> leftSidedPrime = new ArrayList<>();
        for (BigInteger currentNumber = rangeFrom; currentNumber.compareTo(rangeTo) <= 0; currentNumber = currentNumber.add(BigInteger.ONE)) {
            if (isPrime(currentNumber)){
            BigInteger numberToTest = currentNumber;
            if (!numberToTest.toString().contains("0")) {
                int digit = numberToTest.toString().length();
                boolean isPrimeNumber = true;
                for (int i = digit; i > 0; i--) {
                    if (i > 1)
                        numberToTest = new BigInteger(numberToTest.toString().substring(1));
                    if (!isPrime(numberToTest)) {
                        isPrimeNumber = false;
                        break;
                    }
                }
                if (isPrimeNumber) {
                    leftSidedPrime.add(currentNumber);
                }
            }}
        }
        return leftSidedPrime;
    }

    private ArrayList<BigInteger> isRightSidedPrime(ArrayList<BigInteger> leftSidedPrime) {
        ArrayList<BigInteger> twoSidedPrime = new ArrayList<>();

        leftSidedPrime.forEach( element -> {
            BigInteger numberToTest = element;
            int digit = numberToTest.toString().length();
            boolean isPrimeNumber = true;
            for (int i = digit; i > 0 ; i-- ) {
               if (i > 1) {
                   numberToTest = numberToTest.divide(new BigInteger("10"));
               }
                if (!isPrime(numberToTest)) {
                    isPrimeNumber = false;
                    break;
                }

            }
            if (isPrimeNumber) {
                twoSidedPrime.add(element);
            }
        });
        return twoSidedPrime;
    }

    protected boolean isPrime(BigInteger number){
        if(!number.isProbablePrime(5)){
            return false;
        } else {
            BigInteger var2 = new BigInteger("2");
            if(!var2.equals(number) && BigInteger.ZERO.equals(number.mod(var2))) {
                return false ;
            } else {
                for(BigInteger var3 = new BigInteger("3"); var3.multiply(var3).compareTo(number) < 1; var3 = var3.add(var2)) {
                    if(BigInteger.ZERO.equals(number.mod(var3))){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
