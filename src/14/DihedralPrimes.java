import java.math.BigInteger;
import java.util.ArrayList;

public class DihedralPrimes {

    private BigInteger Prime = new BigInteger("0");

    private static DihedralPrimes instance = new DihedralPrimes();
    public Port port;

    public DihedralPrimes()
    {
        port = new Port();
    }

    public class Port implements IComponent{
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo)
        {
            return innerMethodExecute(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> innerMethodExecute(BigInteger rangeFrom, BigInteger rangeTo)
    {
        ArrayList<BigInteger> bigIntegers = new ArrayList<>();

        for(BigInteger i = rangeFrom; i.compareTo(rangeTo) <= 0; i = i.add(BigInteger.ONE))
        {
            if(isDihedralPrimes(i))
            {
                bigIntegers.add(i);
            }
        }
        return bigIntegers;
    }

    private boolean isDihedralPrimes(BigInteger Dihedral1)
    {
        boolean isDihedralPrime = false;
        BigInteger DihedralCopy = Dihedral1;
        BigInteger Dihedral2 = new BigInteger("0");
        BigInteger Dihedral3 = new BigInteger("0");
        BigInteger Dihedral4 = new BigInteger("0");
        ArrayList<BigInteger> DihedralPrime1 = new ArrayList<>();
        ArrayList<BigInteger> DihedralPrime2 = new ArrayList<>();
        ArrayList<BigInteger> DihedralPrime3 = new ArrayList<>();

        if(isPrime(Dihedral1))
        {
            //Zahl verkehrtherum einlesen
            while(!(DihedralCopy.equals(BigInteger.ZERO)))
            {
                DihedralPrime1.add(DihedralCopy.mod(BigInteger.TEN));
                DihedralCopy = DihedralCopy.divide(BigInteger.TEN);
            }

            DihedralPrime2 = new ArrayList<>(DihedralPrime1);

            //Zahl verkehrtherum zusammensetzen
            for(int i = DihedralPrime1.size()-1; DihedralPrime1.size() > 0; i--)
            {
                Dihedral2 = Dihedral2.add(DihedralPrime1.get(0).multiply(BigInteger.TEN.pow(i)));
                DihedralPrime1.remove(0);
            }

            //2 mit 5 ersetzen und umgekehrt
            for(int i = 0; i < DihedralPrime2.size(); i++)
            {
                if(DihedralPrime2.get(i).compareTo(new BigInteger("2")) == 0)
                {
                    DihedralPrime2.set(i, new BigInteger("5"));
                } else if(DihedralPrime2.get(i).compareTo(new BigInteger("3")) == 0)
                {
                    return false;
                } else if(DihedralPrime2.get(i).compareTo(new BigInteger("4")) == 0)
                {
                    return false;
                } else if(DihedralPrime2.get(i).compareTo(new BigInteger("5")) == 0)
                {
                    DihedralPrime2.set(i, new BigInteger("2"));
                } else if(DihedralPrime2.get(i).compareTo(new BigInteger("6")) == 0)
                {
                    return false;
                } else if(DihedralPrime2.get(i).compareTo(new BigInteger("7")) == 0)
                {
                    return false;
                } else if(DihedralPrime2.get(i).compareTo(new BigInteger("9")) == 0)
                {
                    return false;
                }
            }

            DihedralPrime3 = new ArrayList<>(DihedralPrime2);

            //Zahl spiegelverkehrt zusammensetzen
            for(int i = DihedralPrime2.size()-1; DihedralPrime2.size() > 0; i--)
            {
                Dihedral3 = Dihedral3.add(DihedralPrime2.get(0).multiply(BigInteger.TEN.pow(i)));
                DihedralPrime2.remove(0);
            }

            //Zahl spiegelverkehrt und verkehrtherum zusammensetzen
            for(int i = 0; DihedralPrime3.size() > 0; i++)
            {
                Dihedral4 = Dihedral4.add(DihedralPrime3.get(0).multiply(BigInteger.TEN.pow(i)));
                DihedralPrime3.remove(0);
            }
            //überprüfen ob Zahl rückwärts eine Primzahl ist
            if(isPrime(Dihedral1) && isPrime(Dihedral2) && isPrime(Dihedral3) && isPrime(Dihedral4))
            {
                isDihedralPrime = true;
            }
        }
        return isDihedralPrime;
    }

    private boolean isPrime(BigInteger testNumber){
        boolean isPrime = true;

        for(BigInteger divisor = new BigInteger("2"); divisor.compareTo(testNumber.divide(new BigInteger("2"))) <= 0; divisor = divisor.add(BigInteger.ONE)) {
            if (testNumber.mod(divisor).intValue() == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
