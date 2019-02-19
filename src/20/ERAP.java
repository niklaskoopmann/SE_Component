import java.math.BigInteger;
import java.util.ArrayList;

public class ERAP {
    private static ERAP instance = new ERAP();

    public static ERAP getInstance() {
        return instance;
    }

    public Port port;

    private ERAP() {
        port = new Port();
    }

    public class Port implements IERAP{
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {

            ArrayList<BigInteger> prime = new ArrayList<BigInteger>();
            BigInteger factorOfNumber1 = BigInteger.ZERO;
            BigInteger factorOfNumber2 = BigInteger.ZERO;

            for (BigInteger i = rangeFrom;
                 i.compareTo(rangeTo) <= 0;
                 i = i.add(BigInteger.ONE)){
                BigInteger n = rangeFrom;

                for (BigInteger j = BigInteger.TWO;
                     j.compareTo(n) <= 0;
                     j = j.add(BigInteger.ONE)){

                    if (n.mod(j).equals(BigInteger.ZERO)){
                        factorOfNumber1 = factorOfNumber1.add(j);
                        n = n.divide(j);
                        j = BigInteger.ONE;
                    }
                }

                if (factorOfNumber1.equals(factorOfNumber2)){
                    if (factorOfNumber2.compareTo(BigInteger.TWO)>=0) {
                        prime.add(rangeFrom.subtract(BigInteger.ONE));
                        prime.add(rangeFrom);
                    }
                }

                factorOfNumber2 = factorOfNumber1;
                factorOfNumber2 = factorOfNumber2.add(BigInteger.ONE);

                factorOfNumber1 = BigInteger.ZERO;
                rangeFrom = rangeFrom.add(BigInteger.ONE);
            }
            return prime;
        }
    }
}
