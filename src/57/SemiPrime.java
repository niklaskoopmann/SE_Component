import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SemiPrime{
    public static SemiPrime instance = new SemiPrime();
    public Port port;

    public static SemiPrime getInstance(){
        return instance;
    }

    private SemiPrime() {
        port = new Port();
    }

    public class Port implements ISemiPrime{
        private Method[] methods = getClass().getMethods();

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return SemiPrime.this.execute(rangeFrom, rangeTo).stream().sorted(Comparator.comparing(o->o)).collect(Collectors.toCollection(ArrayList::new));
        }

        @Override
        public void listMethods() {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
                if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
            System.out.println("---");
        }
    }

    private ArrayList<BigInteger> PrimeGenerator(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> thePrimeList = new ArrayList<BigInteger>();
        for (BigInteger j = rangeFrom; j.compareTo(rangeTo) == -1; j = j.add(BigInteger.ONE)) {
            boolean prime = true;
            prime = isPrime(j);
            if (prime && j != BigInteger.valueOf(1)) {
                thePrimeList.add(j);
            }
        }
        return thePrimeList;
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


    public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> theList = new ArrayList<BigInteger>();
        ArrayList<BigInteger> thePrimeList = PrimeGenerator(rangeFrom, rangeTo);
        ArrayList<BigInteger> thePrimeList2 = thePrimeList;
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(BigInteger.valueOf(thePrimeList.size())) == -1; i = i.add(BigInteger.valueOf(1))) {
            for (BigInteger j = BigInteger.valueOf(0); j.compareTo(BigInteger.valueOf(thePrimeList.size())) == -1; j = j.add(BigInteger.valueOf(1))) {
                BigInteger newSemiprime = thePrimeList.get(i.intValue()).multiply(thePrimeList2.get(j.intValue()));
                boolean exist = false;
                for (BigInteger k = BigInteger.valueOf(0); k.compareTo(BigInteger.valueOf(theList.size())) == -1; k = k.add(BigInteger.valueOf(1))) {
                    if (newSemiprime.compareTo(theList.get(k.intValue())) == 0) {
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    theList.add(newSemiprime);
                }
            }
        }
        theList = theList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
        return theList;
    }

}
