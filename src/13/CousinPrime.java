import java.math.BigInteger;
import java.util.ArrayList;
import java.lang.reflect.Method;

public class CousinPrime {

    //static instance
    private static CousinPrime instance = new CousinPrime();

    public static CousinPrime getInstance(){
        return instance;
    }

    //define Port
    public Port port;

    private CousinPrime(){
        port = new Port();
    }

    
    public class Port implements ICousinPrime{
    	private Method[] methods = getClass().getMethods();
    	
        public ArrayList<BigInteger> execute(BigInteger rangeF, BigInteger rangeT){
            //return executeCousin(rangeF, rangeT);
            //return CousinPrime.this.executeCousin(rangeF, rangeT).stream().collect(Collectors.toCollection(ArrayList::new));
        	return execute(rangeF, rangeT);
        }

        public void printVersion() {
            System.out.println(getVersion() + "\n");
        }
        
        public String getVersion(){
            return "CousinPrime";
        }
        
        public void listMethods() {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
                if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
            System.out.println("---");
        }
    }

    //EXECUTE
    ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo){
        ArrayList<BigInteger> cousinPrime = new ArrayList<>();

        for(BigInteger bi = rangeFrom ; 0>(bi.compareTo(rangeTo)); bi.add(BigInteger.ONE)){
            //Ist Zahl Primzahl?
            if(returnPrime(bi)){
                //Wenn ja, ist +4 primzahl?
                if(returnPrime(bi.add(BigInteger.valueOf(4)))){
                    cousinPrime.add(bi);
                    cousinPrime.add(bi.add(BigInteger.valueOf(4)));
                }
            }
        }
        return cousinPrime;
    }

    //Is prime?
    public boolean returnPrime(BigInteger number) {
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
