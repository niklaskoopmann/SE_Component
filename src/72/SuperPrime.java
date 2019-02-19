import java.math.BigInteger;
import java.util.ArrayList;

public class SuperPrime {

    private static SuperPrime instance = new SuperPrime();

    public static SuperPrime getInstance(){
        return instance;
    }

    //Define Port
    public Port port;

    private SuperPrime(){
        port = new Port();
    }

    public class Port implements ISuperPrime{
        public ArrayList<BigInteger> execute (BigInteger rangeFrom, BigInteger rangeTo){
            return calculateSuperPrimes(rangeFrom, rangeTo);
        }
    }

    private BigInteger getNextPrime(BigInteger number){
        if(number.intValue() < 2) return BigInteger.TWO;
        if(number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) number = number.subtract(BigInteger.ONE);
        do{
            number = number.add(BigInteger.TWO);
        }while(!isPrime(number));

        return number;
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
    
    private ArrayList<BigInteger> calculateSuperPrimes(BigInteger rangeFrom, BigInteger rangeTo){

        BigInteger i = BigInteger.valueOf(0);
        BigInteger j = BigInteger.valueOf(0);
        ArrayList<BigInteger> primeList = new ArrayList<>();
        while((i = getNextPrime(i)).compareTo(rangeTo) <= 0){
            primeList.add(i);
        }
        ArrayList<BigInteger> indexList = new ArrayList<>();
        while((j = getNextPrime(j)).compareTo(BigInteger.valueOf(primeList.size())) <=0){
            indexList.add(j);
        }
        ArrayList<BigInteger> superPrimeList = new ArrayList<>();
        for(BigInteger index: indexList){
            superPrimeList.add(primeList.get(index.intValue()-1));
        }
        ArrayList<BigInteger> toRemove = new ArrayList<>();
        for(BigInteger prime: superPrimeList){
            if(prime.compareTo(rangeFrom) < 0){
                toRemove.add(prime);
            }
            else{
                break;
            }

        }
        superPrimeList.removeAll(toRemove);
        return superPrimeList;
    }
}
