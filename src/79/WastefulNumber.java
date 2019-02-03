import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class WastefulNumber {

    private static WastefulNumber instance = new WastefulNumber();

    public static WastefulNumber getInstance() {
        return instance;
    }

    public Port port;

    private WastefulNumber() {
        port = new Port();
    }

    public class Port implements IWastefulNumber {

        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerMethodExecute(rangeFrom, rangeTo);
        }

    }

    public ArrayList<BigInteger> innerMethodExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> returnList = new ArrayList<BigInteger>();
        BigInteger startValue = rangeFrom;

        while (startValue.compareTo(rangeTo) <= 0) {

            if (new BigInteger(Integer.toString(startValue.toString().length())).compareTo(primeFactorizationDigits(startValue)) == -1) {
                returnList.add(startValue);
            }

            startValue = startValue.add(BigInteger.ONE);
        }

        return returnList;
    }

    private BigInteger primeFactorizationDigits(BigInteger number) {
        HashMap<BigInteger, BigInteger> primeFactorizationDigitsMap = new HashMap<BigInteger, BigInteger>();
        for (BigInteger i = BigInteger.TWO; i.compareTo(number) <= 0; i = i.add(BigInteger.ONE)) {
            while (number.mod(i).compareTo(BigInteger.ZERO) == 0) {
                if (primeFactorizationDigitsMap.get(i) != null) {
                    primeFactorizationDigitsMap.put(i, primeFactorizationDigitsMap.get(i).add(BigInteger.ONE));
                } else {
                    primeFactorizationDigitsMap.put(i, BigInteger.ONE);
                }
                number = number.divide(i);
            }
        }

        BigInteger returnValue = BigInteger.ZERO;
        for (HashMap.Entry<BigInteger, BigInteger> entry : primeFactorizationDigitsMap.entrySet()) {
            returnValue = returnValue.add(new BigInteger(Integer.toString(entry.getKey().toString().length())));
            if (entry.getValue().compareTo(BigInteger.ONE) == 1) {
                returnValue = returnValue.add(new BigInteger(Integer.toString(entry.getValue().toString().length())));
            }
        }

        return returnValue;

    }

}
