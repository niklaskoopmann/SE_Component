import java.math.BigInteger;
import java.util.ArrayList;

public class EvilNumber {

    // static instance

    private static EvilNumber instance = new EvilNumber();

    public static EvilNumber getInstance() {
        return instance;
    }

    // define port

    public Port port;

    private EvilNumber() {
        port = new Port();
    }

    private ArrayList<BigInteger> calculateEvilNumbers(BigInteger rangeFrom, BigInteger rangeTo)
    {

        ArrayList<BigInteger> EvilNumbers = new ArrayList<>();

        for(;rangeFrom.compareTo(rangeTo)<=0; rangeFrom = rangeFrom.add(BigInteger.ONE))
        {

            //if(rangeFrom.mod(BigInteger.TWO) != BigInteger.ZERO)
            //{
                BigInteger count = new BigInteger("0");
                String s = rangeFrom.toString(2);
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i)=='1') {
                        count = count.add(BigInteger.ONE);

                    }

                }
                if(count.mod(BigInteger.TWO) == BigInteger.ZERO)
                {
                    EvilNumbers.add(rangeFrom);
                }


           // }


        }
        return null;
    }


    public class Port implements IEvilNumber {


        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {

            ArrayList<BigInteger> EvilNumber = new ArrayList<>();
            //System.out.println("execute methode");
            return calculateEvilNumbers(rangeFrom, rangeTo);
        }
    }
}

