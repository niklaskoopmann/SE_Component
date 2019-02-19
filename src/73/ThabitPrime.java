import java.math.BigInteger;
import java.util.ArrayList;
import java.lang.reflect.Method;

public class ThabitPrime {
    //static instance
    private static ThabitPrime instance = new ThabitPrime();
    public static ThabitPrime getInstance(){
        return instance;
    }

    //define port
    public Port port;
    private ThabitPrime(){
        port = new Port();
    }

    public String getVersion(){
        return"Thabit Prime";
    }

    public class Port implements IThabitPrime{
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo){
            return ThabitPrime.this.execute(rangeFrom, rangeTo);
        }

        public void printVersion(){
            System.out.println(getVersion());
        }
    }

    private ArrayList<BigInteger> execute(BigInteger rangeF, BigInteger rangeT){
    	ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
        for(BigInteger bi = rangeF; 0>bi.compareTo(rangeT); bi.add(BigInteger.ONE)){
            //Is prime number?
            if(returnPrime(bi)){
                //3*2^n -1
                //+1     // 3*2^n
                bi.add(BigInteger.ONE);
                //  :3    //2^n
                bi.divide(BigInteger.valueOf(3));
                //  log2
                //TODO: logarithm
                double log = 0;
                log = logBigInteger(bi);
                // Teste, ob double eine ganze Zahl ist
                int testInt = (int) log;
                if (log - testInt == 0) {
                	// Falls Ganzezahl, einfuepgen in Arrayliste
                	primes.add(bi);
                }
            }
        }

        return primes;
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
 
    
    private static double logBigInteger(BigInteger val) {
    	final int MAX_DIGITS_2 = 977; // ~ MAX_DIGITS_EXP/LN(2)
    	final double LOG2 = Math.log(2.0);
    	
        if (val.signum() < 1)
            return val.signum() < 0 ? Double.NaN : Double.NEGATIVE_INFINITY;
        int blex = val.bitLength() - MAX_DIGITS_2; // any value in 60..1023 works ok here
        if (blex > 0)
            val = val.shiftRight(blex);
        double res = Math.log(val.doubleValue());
        return blex > 0 ? res + blex * LOG2 : res;
    }
}
