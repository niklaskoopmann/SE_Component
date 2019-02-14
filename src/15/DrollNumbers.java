import java.math.BigInteger;
import java.util.ArrayList;

public class DrollNumbers {

    private static DrollNumbers instance = new DrollNumbers();

    public static DrollNumbers getInstance() {
        return instance;
    }

    public Port port;

    private DrollNumbers() {
        port = new Port();
    }

    public class Port implements IDrollNumbers {
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {

            ArrayList<BigInteger> prime = new ArrayList<BigInteger>();

            for (BigInteger i = rangeFrom;
                 i.compareTo(rangeTo) <= 0;
                 i = i.add(BigInteger.ONE)){

                BigInteger even = BigInteger.ZERO;
                BigInteger unEven = BigInteger.ZERO;
                BigInteger n = rangeFrom;

                for (BigInteger j = BigInteger.TWO;
                     j.compareTo(n) <= 0;
                     j = j.add(BigInteger.ONE)){

                    if (n.mod(j).equals(BigInteger.ZERO)){
                        if (j.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
                            even = even.add(j);
                            n = n.divide(j);
                            j = BigInteger.ONE;
                        }else {
                            unEven = unEven.add(j);
                            n = n.divide(j);
                            j = BigInteger.ONE;
                        }
                    }

                }
                if (even.equals(unEven)){
                    if (!rangeFrom.equals(BigInteger.ONE))
                        prime.add(rangeFrom);
                }
                rangeFrom = rangeFrom.add(BigInteger.ONE);

            }
            return prime;
        }
    }
}
