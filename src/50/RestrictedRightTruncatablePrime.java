import java.math.BigInteger;
import java.util.ArrayList;

public class RestrictedRightTruncatablePrime {

    private static RestrictedRightTruncatablePrime instance = new RestrictedRightTruncatablePrime();

    public static RestrictedRightTruncatablePrime getInstance() {
        return instance;
    }

    private RestrictedRightTruncatablePrime(){
        port =  new Port();
    }

    public Port port;

    public class Port implements IRestrictedRightTruncatablePrime {

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return execute(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo)
    {
        ArrayList<BigInteger> list = new ArrayList<>();
        for (BigInteger i = rangeFrom;i.compareTo(rangeTo) <= 0;i = i.add(BigInteger.ONE)) {
            if(!isPrime(i)){
                continue;
            }
            if(!isTruncate(i)){
                continue;
            }
            if(!isRestricted(i)){
                continue;
            }
            list.add(i);
        }
        return list;
    }
        public static boolean isTruncate(BigInteger number){
            while(number.compareTo(BigInteger.valueOf(10)) > 0){
                number=number.divide(BigInteger.valueOf(10));
                if (!isPrime(number)){
                    return false;
                }
            }
            if(isPrime(number)){
                return true;
            }
            else{
                return false;
            }
        }

        public static boolean isRestricted(BigInteger number){
            BigInteger num= number.multiply(BigInteger.valueOf(10));
            int i=1;
            num=num.add(BigInteger.ONE);
            if(isPrime(num)){
                return false;
            }
            while( i<10) {
                if (isPrime(num)) {
                    return false;
                }
                num = num.add(BigInteger.TWO);
                i += 2;
            }
            return true;
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
