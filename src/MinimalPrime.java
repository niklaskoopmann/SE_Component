import javax.sound.sampled.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class MinimalPrime {

    //static instance
    private static MinimalPrime instance = new MinimalPrime();
    public static MinimalPrime getInstance(){
        return instance;
    }

    //define port
    public Port port;

    private MinimalPrime(){
        port = new Port();
    }
    public class Port implements IMinimalPrime{
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return calculate(rangeFrom, rangeTo);
        }
    }


    ArrayList<BigInteger> calculate(BigInteger rangeFrom, BigInteger rangeTo){
        ArrayList<BigInteger> minimalPrimes = new ArrayList<>();

        //returnt null, da 66600049 die groeste Minimal Prime ist
        if(rangeFrom.compareTo(BigInteger.valueOf(66600049)) > 0 ) return null;

        //reduziert ranteTo, da nach 66600049 keine weiten Minimal Primes existieren
        if(rangeTo.compareTo(BigInteger.valueOf(66600049)) > 0 ) rangeTo = BigInteger.valueOf(66600049 + 1);


        rangeFrom = rangeFrom.subtract(BigInteger.ONE);
        if(rangeFrom.intValue() <= 0) rangeFrom = BigInteger.ONE;
        rangeFrom = getNextPrime(rangeFrom);


        while (rangeFrom.compareTo(rangeTo) <= 0){
            if(isMinimalPrime(rangeFrom)) minimalPrimes.add(rangeFrom);
            System.out.println("Testing Prime " + rangeFrom.toString());

            rangeFrom = getNextPrime(rangeFrom);
        }

        return minimalPrimes;
    }

    //prueft ob die Zahl eine Minimal Prime Number ist
    private boolean isMinimalPrime(BigInteger number){
        String numberString = number.toString();
        String smallerPrimes[] = getSmallerPrimes(number).toArray(new String[0]);
        String firstChar;

        for(int m = 0; m < smallerPrimes.length; m++){
            firstChar = smallerPrimes[m].charAt(0) + "";
            if(numberString.contains(firstChar)){

                int count = 0;
                for(int x = 0; x < numberString.length(); x++){
                    if(numberString.charAt(x) == smallerPrimes[m].charAt(count)){
                        count++;
                        if(count == smallerPrimes[m].length()) return false;
                    }
                }
            }
        }

        return true;
    }

    //gibt alle Primzahlen zurueck, welche kleiner als die gegebene Zahl ist
    private ArrayList<String> getSmallerPrimes(BigInteger number){
        ArrayList<String> primes = new ArrayList<>();
        BigInteger count = BigInteger.TWO;

        while (count.compareTo(number) < 0){
            primes.add(count.toString());

            count = getNextPrime(count);
        }

        return primes;
    }

    //gibt naechste Zahl zurueck welche eine Primzahl ist
    private BigInteger getNextPrime(BigInteger number){
        if(number.intValue() < 2) return BigInteger.TWO;
        if(number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) number = number.subtract(BigInteger.ONE);
        do{
            number = number.add(BigInteger.TWO);
        }while(!checkPrime(number));

        return number;
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
