
import java.math.BigInteger;
import java.util.ArrayList;

public class LeftTractablePrime{

    private static LeftTractablePrime instance = new LeftTractablePrime();

    public static LeftTractablePrime getInstance(){
        return instance;
    }

    public Port port;

    private LeftTractablePrime(){
        port = new Port();
    }

    public class Port implements ILeftTrancatablePrime{

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return calculatePrime(rangeFrom, rangeTo);
        }

    }

    private ArrayList<BigInteger> calculatePrime(BigInteger rangeFrom, BigInteger rangeTo){
        ArrayList<BigInteger> listTractablePrimeNumbers = new ArrayList<>();

        for(BigInteger currentNumber = rangeFrom; currentNumber.compareTo(rangeTo) <= 0; currentNumber = currentNumber.add(BigInteger.ONE)) {
            if(isPrime(currentNumber)){
                BigInteger numberToTest = currentNumber;
                if(!numberToTest.toString().contains("0")) {
                    int digit = numberToTest.toString().length();
                    boolean isPrimeNumber = true;
                    for (int i = digit; i > 0 ; i-- ){
                        if (i > 1) {
                            numberToTest = new BigInteger(numberToTest.toString().substring(1));
                        }
                        if (!isPrime(numberToTest)) {
                            isPrimeNumber = false;
                            break;
                        }
                    }
                    if (isPrimeNumber)
                       listTractablePrimeNumbers.add(currentNumber);
                }
            }
        }
        return listTractablePrimeNumbers;
    }

    private boolean isPrime(BigInteger number){

        if (!number.isProbablePrime(5))
        return false;

        BigInteger two = new BigInteger("2");
        if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
            return false;

        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) {
            if (BigInteger.ZERO.equals(number.mod(i)))
                return false;
        }
        return true;
    }
}
