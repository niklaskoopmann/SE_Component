import javax.sound.sampled.Port;
import java.math.BigInteger;
import java.util.ArrayList;


public class SelfPrimesInBase10{

    //static instance
    private static SelfPrimesInBase10 instance = new SelfPrimesInBase10();
    public static SelfPrimesInBase10 getInstance(){
        return instance;
    }

    //define port
    public Port port;

    private SelfPrimesInBase10(){
        port = new Port();
    }
    public class Port implements ISelfPrimesInBase10{
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return calculate(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> calculate(BigInteger rangeFrom, BigInteger rangeTo){

        System.out.println("start execute");

        //fills output with all primes till rangeTo
        ArrayList<BigInteger> output = new ArrayList<BigInteger>();
        while(rangeFrom.compareTo(rangeTo) < 0){
            if(checkPrime(rangeFrom)){
                output.add(rangeFrom);
            }
            rangeFrom = rangeFrom.add(BigInteger.ONE);
        }

        //check every prime in the list for being a self prime   // removes normal primes
        for(int i = 0; i < output.size(); i++){
            if(isSelfPrimeBase10(output.get(i))) {
                output.remove(i);
                i--;
            }
        }
        return output;
    }

    public boolean isSelfPrimeBase10(BigInteger prime) {

        System.out.println("check prime: " + prime);

        for (BigInteger n = BigInteger.ZERO; n.compareTo(prime) < 0; n=n.add(BigInteger.ONE)) {

            BigInteger sum = BigInteger.ZERO;

            //digit sum of n
            String digits = n.toString();

            for (int i = 0; i < digits.length(); i++) {
                int digit = (digits.charAt(i) - '0');
                sum = sum.add(BigInteger.valueOf(digit));
            }

            //if int and digit sum equals prime return true
            if (n.add(sum).equals(prime)) {
                System.out.println("prime removed");
                return true;
            }
        }
        System.out.println("Is a self Prime");
        return false;
    }

    //prueft ob uebergebene Zahl eine Primzahl ist
    private boolean checkPrime(BigInteger number){
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
