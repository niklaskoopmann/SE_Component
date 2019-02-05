import java.math.BigInteger;
import java.util.ArrayList;

public class Rhonda_Number {
    private static Rhonda_Number instance = new Rhonda_Number();

    public static Rhonda_Number getInstance()
    {
        return instance;
    }
    public Port port;
    private int[] values;

    public Rhonda_Number()
    {
        port = new Port();
    }

    public class Port implements IRhonda_Number {
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return calculateRhonda_Number(rangeFrom, rangeTo);
        }
    }

    private BigInteger getNextPrime(BigInteger number){
        if(number.intValue() < 2) return BigInteger.TWO;
        if(number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) number = number.subtract(BigInteger.ONE);
        do{
            number = number.add(BigInteger.TWO);
        }while(!checkPrime(number));

        return number;
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

    private ArrayList<BigInteger> calculateRhonda_Number(BigInteger rangeFrom, BigInteger rangeTo)
    {
        ArrayList<BigInteger> Rhonda_Number = new ArrayList<>();
        ArrayList<BigInteger> primzerlegung = new ArrayList<>();

        BigInteger number = rangeFrom;
        BigInteger split = rangeFrom;
        boolean rangeToReached = false;

        while(rangeToReached==false) {
            switch ((rangeTo.subtract(number)).compareTo(BigInteger.ZERO)) {
                case 1:
                    break;
                case 0:
                case -1:
                    rangeToReached = true;
                    break;
            }

            BigInteger nextPrime=getNextPrime(BigInteger.ZERO);

            while (checkPrime(split)==false && number.compareTo(BigInteger.TEN) >0)
            {
                if(split.mod(nextPrime).equals(BigInteger.ZERO))
                {

                    primzerlegung.add(nextPrime);
                    split = split.divide(nextPrime);

                }
                else
                {
                    nextPrime=getNextPrime(nextPrime);
                }
            }
            primzerlegung.add(split);
            String nextNumber = number.toString();

            BigInteger summe = BigInteger.ONE;
            BigInteger [] d= new BigInteger[nextNumber.length()-1];
            for(int i = 0; i<nextNumber.length();i++)
            {
                summe= summe.multiply(new BigInteger (nextNumber.substring(i, i+1)));
            }


            BigInteger sum = BigInteger.ZERO;

            for(BigInteger p : primzerlegung){
                sum = sum.add(p);
            }

            sum = sum.multiply(BigInteger.TEN);

            if(sum.compareTo(summe) == 0)
            {
                Rhonda_Number.add(number);
                System.out.println(number);
            }

            number = number.add(BigInteger.ONE);
            split = number;
            primzerlegung.clear();

        }
        return Rhonda_Number;
    }
}
