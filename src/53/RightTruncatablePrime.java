import java.math.BigInteger;
import java.util.*;


public class RightTruncatablePrime {
	private static RightTruncatablePrime instance = new RightTruncatablePrime();
	
	public static RightTruncatablePrime getInstance(){
        return instance;
    }
	
	//define Port
    public Port port;

    private RightTruncatablePrime(){
        port = new Port();
    }

    public class Port implements IRightTruncatablePrime{
        public ArrayList<BigInteger> execute (BigInteger rangeF, BigInteger rangeT){
            return execute(rangeF, rangeT);
        }

    }
    
    //TODO: getVersion Methode notwendig? Bei uns gibt es doch nur eine "Version"
		
	// Variablen
	
	// Methoden
	ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
		ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
		ArrayList<BigInteger> tempPrimes = new ArrayList<BigInteger>();

		for (BigInteger bi = rangeFrom; 0>(bi.compareTo(rangeTo)); bi.add(BigInteger.ONE)) {
			if (returnPrime(bi)) {
				tempPrimes.add(bi);
			}
			for (BigInteger object: tempPrimes) {
			    //System.out.println(object);
				if (returnPrime(removeRightChar(object))) {
					primes.add(object);
				}
				
			}
		}
		
		return primes;
	}
	
	public BigInteger removeRightChar(BigInteger bigInt) {
		/*
		String string = "004-034556";
		String[] parts = string.split("-");
		String part1 = parts[0]; // 004
		String part2 = parts[1]; // 034556
		*/
		BigInteger bigIntTen = new BigInteger("10");
		bigInt = bigInt.divide(bigIntTen);
		return bigInt;
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
	
	/*
	public static void main(String... args) { 
		BigInteger rangeFrom = new BigInteger("1");
		BigInteger rangeTo = new BigInteger("200");
		RightTruncatablePrime rightTruncatablePrime = new RightTruncatablePrime();
		rightTruncatablePrime.execute(rangeFrom, rangeTo);
	}
	*/
}
