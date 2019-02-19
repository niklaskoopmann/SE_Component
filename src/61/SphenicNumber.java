import java.math.BigInteger;
import java.util.ArrayList;

public class SphenicNumber {

    // static instance

    private static SphenicNumber instance = new SphenicNumber();

    public static SphenicNumber getInstance() {
        return instance;
    }

    ArrayList<BigInteger> distinctPrimes = new ArrayList<>();
    // define port

    public Port port;

    private SphenicNumber() {
        port = new Port();
    }

    private ArrayList<BigInteger> calculateSphenicNumber(BigInteger rangeFrom, BigInteger rangeTo)
    {
        ArrayList<BigInteger>SphenicList = new ArrayList<>();
        for(;rangeFrom.compareTo(rangeTo)<=0;rangeFrom=rangeFrom.add(BigInteger.ONE)){
            BigInteger number = rangeFrom;
            ArrayList<BigInteger>factors = new ArrayList<>();
            for(BigInteger i = new BigInteger("2"); i.compareTo(number)<=0; i= i.add(BigInteger.ONE)) {
                while(number.mod(i).compareTo(BigInteger.ZERO)==0) {
                    if (!factors.contains(i)){
                        factors.add(i);
                    }
                    number = number.divide(i);
                }
                if(factors.size()==3){
                    if(rangeFrom.compareTo(factors.get(0).multiply(factors.get(1).multiply(factors.get(2))))==0){
                    SphenicList.add(rangeFrom);}
                }
            }
        }
        System.out.println(SphenicList);
        return SphenicList;
    }


    public class Port implements ISphenicNumber {


        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {

            ArrayList<BigInteger> SphenicNumber = new ArrayList<>();
            //System.out.println("execute methode");

            return calculateSphenicNumber(rangeFrom, rangeTo);

        }
    }
}