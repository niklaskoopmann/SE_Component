import java.math.BigInteger;
import java.util.ArrayList;

public class PrimeQuintuplet {
    private static PrimeQuintuplet instance = new PrimeQuintuplet();

    public static PrimeQuintuplet getInstance() {
        return instance;
    }

    //Define Port
    public Port port;

    private PrimeQuintuplet() {
        port = new Port();
    }

    public class Port implements IPrimeQuintuplet {
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return calculatePrimeQuintuplets(rangeFrom, rangeTo);
        }
    }

    private boolean isPrime(BigInteger n) {
        if ((n.compareTo(BigInteger.TWO) > 0 && n.mod(BigInteger.TWO) == BigInteger.ZERO) || n.compareTo(BigInteger.TWO) < 0) //n>2 && n %2 == 0
            return false;

        BigInteger maximum = n.sqrt().add(BigInteger.ONE);//(int) Math.sqrt(n) + 1;

        for (BigInteger i = BigInteger.valueOf(3); i.compareTo(maximum) < 0; i= i.add(BigInteger.TWO)) //int i = 3;i < maximum;i+= 2
            if ((n.mod(i)).equals(BigInteger.ZERO)) //n % i == 0
                return false;

        return true;
    }



    private ArrayList<BigInteger> calculatePrimeQuintuplets(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> quintupletList = new ArrayList<>();


        for(BigInteger i = rangeFrom; i.compareTo(rangeTo) < 0; i= i.add(BigInteger.ONE)){
            if(isPrime(i)){
                ArrayList<BigInteger> quintuplet = findQuintuplet(i);
                if(quintuplet != null && quintuplet.size()!= 0){
                    quintupletList.addAll(quintuplet);
                }
            }
        }

        return quintupletList;
    }

    private ArrayList<BigInteger> findQuintuplet(BigInteger i) { //i-4, i, i+2, i+6, i+8
        ArrayList<BigInteger> quintuplet = new ArrayList<>();
        if (i.compareTo(BigInteger.valueOf(4)) <= 0) return null; //no negative for i-4
        int[] summands = {-4, 0 , 2, 6, 8};
        for(int summand: summands){
           BigInteger temp =  i;
           temp= temp.add(BigInteger.valueOf(summand));

           quintuplet.add(temp);
        }
        for(BigInteger val: quintuplet){
            if(!isPrime(val)) return null;
        }
        return quintuplet;
    }
}
