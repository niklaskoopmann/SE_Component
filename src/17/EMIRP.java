import java.math.BigInteger;
import java.util.ArrayList;

public class EMIRP {

    private static EMIRP instance = new EMIRP();

    public static EMIRP getInstance()
    {
        return instance;
    }
    public Port port;
    private int[] values;

    public EMIRP()
    {
        port = new Port();
        //execute(new BigInteger("2000000"), new BigInteger("5000000"));
    }

    public class Port implements IEMIRP {
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return calculateEMIRP(rangeFrom, rangeTo);
        }
    }

    //gibt naechste Zahl zurueck welche eine Primzahl ist
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

    private ArrayList<BigInteger> calculateEMIRP(BigInteger rangeFrom, BigInteger rangeTo)
    {
        ArrayList<BigInteger> EMIRP = new ArrayList<>();
        BigInteger number = rangeFrom;
        boolean rangeToReached = false;
        while(rangeToReached==false)
        {
            BigInteger nextPrime = getNextPrime(number);
            number = nextPrime;
            switch ((rangeTo.subtract(nextPrime)).compareTo(BigInteger.ZERO))
            {
                case 1:
                    break;
                case 0:
                case -1:
                    rangeToReached=true;
                    break;
            }

            BigInteger x = nextPrime;
            BigInteger rev = new BigInteger("0");

            boolean end = false;

            while (end == false)
            {
                switch (x.compareTo(BigInteger.ZERO))
                {
                    case 1:
                        rev = (rev.multiply(BigInteger.TEN)).add(x.mod(BigInteger.TEN));
                        x = x.divide(BigInteger.TEN);
                        break;
                    case 0:
                        end = true;
                    case -1:
                        end = true;
                        break;
                }

            }
            boolean isPrime = checkPrime(rev);
            if(isPrime == true)
            {
                EMIRP.add(nextPrime);
                System.out.println(nextPrime+ " --> "+rev);
            }

        }
        return EMIRP;
    }



}
