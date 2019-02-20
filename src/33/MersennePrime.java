import java.math.BigInteger;
import java.util.ArrayList;

public class MersennePrime {

    private static MersennePrime instance = new MersennePrime();

    public static MersennePrime getInstance(){
        return instance;
    }

    public Port port;

    private MersennePrime(){
        port = new Port();
    }

    public class Port implements IMersennePrime{

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
          return calculate(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> calculate(BigInteger rangeFrom, BigInteger rangeTo){
        ArrayList<BigInteger> mersennePrimes = new ArrayList<>();

        for(BigInteger currentNumber = rangeFrom; currentNumber.compareTo(rangeTo) <= 0; currentNumber = currentNumber.add(BigInteger.ONE)) {
            BigInteger numberToTest = currentNumber;
            BigInteger probablePrime = pow(numberToTest).subtract(BigInteger.ONE);

            if(isPrime(probablePrime))
            mersennePrimes.add(probablePrime);
        }
        return mersennePrimes;
    }

    BigInteger pow (BigInteger exponent){
        BigInteger result = BigInteger.ONE;
        while (exponent.signum() > 0) {
            result = result.multiply(BigInteger.valueOf(2));
            exponent = exponent.subtract(BigInteger.ONE);
        }
        return result;
    }

    boolean isPrime(BigInteger number){
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
