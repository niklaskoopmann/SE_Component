import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MultiplicativePrime {
    private static MultiplicativePrime instance = new MultiplicativePrime();
    public Port port;

    private MultiplicativePrime() {
        port = new Port();
    }

    public class Port implements IMultiplicativePrime{
        private Method[] methods = getClass().getMethods();

        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return MultiplicativePrime.this.executeMulti(rangeFrom, rangeTo).stream().sorted(Comparator.comparing(o->o)).collect(Collectors.toCollection(ArrayList::new));
        }

        public void listMethods() {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
                if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
            System.out.println("---");
        }
    }

    private boolean isPrime(BigInteger thePrime) {
        boolean prime = true;
        BigInteger testVar = thePrime;
        for (BigInteger i = BigInteger.valueOf(2);
             ((i.compareTo(testVar.divide(BigInteger.valueOf(2))) == 0) ||
                     ((i.compareTo(testVar.divide(BigInteger.valueOf(2))) == -1) || (i.compareTo(testVar.divide(BigInteger.valueOf(2))) == 0)));
             i = i.add(BigInteger.valueOf(1))) {
            // condition for nonprime number
            if (testVar.mod(i) == BigInteger.valueOf(0)) {
                prime = false;
                break;
            }
        }
        return prime;
    }



    private ArrayList<BigInteger> executeMulti(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> theList = new ArrayList<BigInteger>();
        ArrayList<BigInteger> theTempList = new ArrayList<BigInteger>();
        for (BigInteger i = rangeFrom; i.compareTo(rangeTo) == -1; i = i.add(BigInteger.ONE)) {
            theTempList.add(i);
        }
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(BigInteger.valueOf(theTempList.size())) == -1; i = i.add(BigInteger.ONE)){
            BigInteger theTempPrime=theTempList.get(i.intValue());
            BigInteger theTempPrime2=BigInteger.valueOf(1);
            while(!(theTempPrime.compareTo(BigInteger.valueOf(0))==0)){
                BigInteger modOfPrime = theTempPrime.mod(BigInteger.valueOf(10));
                if(!(modOfPrime.compareTo(BigInteger.valueOf(0))==0)){
                    theTempPrime2=theTempPrime2.multiply(theTempPrime.mod(BigInteger.valueOf(10)));
                }
                else{
                    theTempPrime2=BigInteger.valueOf(1);
                    break;
                }
                theTempPrime=theTempPrime.divide(BigInteger.valueOf(10));
            }
            if(!(theTempPrime2.compareTo(BigInteger.valueOf(1))==0)&&isPrime(theTempPrime2)&&(!(theTempList.get(i.intValue()).compareTo(BigInteger.valueOf(0))==0)&&!(theTempList.get(i.intValue()).compareTo(BigInteger.valueOf(1))==0))){
                theList.add(theTempList.get(i.intValue()));
                theTempPrime=BigInteger.valueOf(0);
                theTempPrime2=BigInteger.valueOf(0);
            }
        }
        return theList;
    }
}
