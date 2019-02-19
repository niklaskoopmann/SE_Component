import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci_Primes {
    private static Fibonacci_Primes instance = new Fibonacci_Primes();

    public static Fibonacci_Primes getInstance()
    {
        return instance;
    }
    public Port port;
    private int[] values;

    public Fibonacci_Primes()
    {
        port = new Port();
    }

    public class Port implements IFibonacci_Primes {
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return calculateFibonacci_Primes(rangeFrom, rangeTo);
        }
    }


    //prueft ob uebergebene Zahl eine Primzahl ist
    private boolean checkPrime(BigInteger number){
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

    public ArrayList<BigInteger>calculateFibonacci_Primes(BigInteger start, BigInteger end)
    {
        ArrayList<BigInteger> fib = new ArrayList<BigInteger>();
        ArrayList<BigInteger> fib_Prime = new ArrayList<BigInteger>();

        fib = getFibbonacci(start,end);
        for (BigInteger i: fib) {
            if(checkPrime(i))
                fib_Prime.add(i);
        }
        for (BigInteger i: fib_Prime)
            System.out.println(i.toString());
        return fib_Prime;
    }
    private ArrayList<BigInteger> getFibbonacci(BigInteger start, BigInteger end){

        ArrayList<BigInteger> fib = new ArrayList<BigInteger>();

        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("2");

        while (end.compareTo(a)== 1){
            b = a.add(a=b);
            if(a.compareTo(start) == 1 && end.compareTo(a)== 1)
                fib.add(a);
        }
        return fib;

    }
}
