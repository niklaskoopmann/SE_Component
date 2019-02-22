import java.math.BigInteger;
import java.util.ArrayList;

public class MoranNumber {

    private static MoranNumber instance = new MoranNumber();

    public static MoranNumber getInstance() {
        return instance;
    }

    public Port port;

    private MoranNumber(){
        port =  new Port();
    }

    public class Port implements IMoranNumber {

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return execute(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo ){
        BigInteger result;
        ArrayList<BigInteger> list = new ArrayList<>();
        for (BigInteger i = new BigInteger("1");i.compareTo(rangeTo) <= 0;i = i.add(BigInteger.ONE)) {
            BigInteger num = i;
            BigInteger sum = new BigInteger("0");
            while (num.compareTo(new BigInteger("0")) > 0){
                sum = sum.add(num.mod(new BigInteger("10")));
                num = num.divide(new BigInteger("10"));
            }
            if (i.mod(sum).compareTo(new BigInteger("0")) == 0){
                result = i.divide(sum);
                if (isPrime(result)){
                    list.add(i);
                }
            }
        }
        return list;
    }

    private static boolean isPrime(BigInteger number) {
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
