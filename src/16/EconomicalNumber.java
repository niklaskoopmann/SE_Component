import java.math.BigInteger;
import java.util.*;

public class EconomicalNumber {

    private static EconomicalNumber instance = new EconomicalNumber();

    public static EconomicalNumber getInstance(){
        return instance;
    }

    //Define Port
    public Port port;

    private EconomicalNumber(){
        port = new Port();
    }

    public class Port implements IEconomicalNumber{
        public ArrayList<BigInteger> execute (BigInteger rangeFrom, BigInteger rangeTo){

            return calculateEcoNumbers(rangeFrom, rangeTo);
        }
    }

    private ArrayList<BigInteger> calculateEcoNumbers(BigInteger rangeFrom, BigInteger rangeTo){
        ArrayList<BigInteger> ecoNumbers = new ArrayList<>();
        if(rangeFrom.equals(BigInteger.ZERO)) rangeFrom = BigInteger.TWO;
        for(BigInteger i = rangeFrom;i.compareTo(rangeTo) <= 0; i=i.add(BigInteger.ONE) ){
            ArrayList<BigInteger> primeFactorList = primeFactors(i);
            if(getDigitCount(i) >= getDigitCount(primeFactorList)){
                ecoNumbers.add(i);
            }
        }
        return ecoNumbers;
    }

    public ArrayList<BigInteger> primeFactors(BigInteger numbers) {
        BigInteger n = numbers;
        ArrayList<BigInteger> factors = new ArrayList<>();
        for(BigInteger i = BigInteger.valueOf(2);
            i.compareTo(n.divide(i)) <= 0;
            i = i.add(BigInteger.ONE)){ //(int i = 2; i <= n / i; i++)

            while(n.mod(i).compareTo(BigInteger.ZERO) == 0){ //(n % i == 0)
                factors.add(i);
                n = n.divide(i); //n /= i
            }
        }
        if(n.compareTo(BigInteger.ONE) > 0){ //(n > 1)
            factors.add(n);
        }
        return factors;
    }

    private int getDigitCount(BigInteger number) {
        double factor = Math.log(2) / Math.log(10);
        int digitCount = (int) (factor * number.bitLength() + 1);
        if (BigInteger.TEN.pow(digitCount - 1).compareTo(number) > 0) {
            return digitCount - 1;
        }
        return digitCount;
    }

    private int getDigitCount(ArrayList<BigInteger> factorList){
        HashMap<BigInteger, Integer> factorExponentMap = new HashMap<>();
        for(BigInteger factor: factorList){
            if(factorExponentMap.get(factor) == null){
                factorExponentMap.put(factor, 1);
            }
            else{
                int newValue = factorExponentMap.get(factor) +1;
                factorExponentMap.put(factor, newValue);
            }
        }

        int sum = 0;
        for(BigInteger i: factorExponentMap.keySet()){
            sum += getDigitCount(i);
            int expo = factorExponentMap.get(i);
            if(expo >1){
                sum += (expo + "").length();
            }
        }
        return sum;
    }


}
