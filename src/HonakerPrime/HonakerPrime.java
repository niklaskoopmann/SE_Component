
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class HonakerPrime {
    private static HonakerPrime instance = new HonakerPrime();
    public Port port;

    private HonakerPrime() {
        port = new Port();
    }

    public class Port implements IHonakerPrime {
        private Method[] methods = getClass().getMethods();

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return InnerExecute(rangeFrom,rangeTo);
        }

        public void listMethods() {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
                if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
            System.out.println("---");
        }
    }

    public ArrayList<BigInteger> InnerExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> list = new ArrayList<>();

        BigInteger PrimeIndex=new BigInteger("0");


        //zählt PrimeIndex zum Startwert
        if(rangeFrom.compareTo(BigInteger.valueOf(1)) !=0){
            for(BigInteger i =new BigInteger("1"); i.compareTo(rangeFrom)<=0; i=i.add(BigInteger.ONE)){
                if (returnPrime(i)){
                    PrimeIndex= PrimeIndex.add(BigInteger.ONE);
                }
            }
        }

        // HonakerPrime Algorithmus für Anfangswert bis Endwert
        for (BigInteger bi = rangeFrom; bi.compareTo(rangeTo) < 0;  bi = bi.add(BigInteger.ONE)) {
            if (returnPrime(bi)) {


                PrimeIndex = PrimeIndex.add(BigInteger.ONE);
                BigInteger isHonaker = Honaker(bi, PrimeIndex);

                if (!BigInteger.valueOf(0).equals(isHonaker)){
                    list.add(isHonaker);
                }

            }
        }


        return (list);
    }





    // Gibt Primzahlen zurück
    public static boolean returnPrime(BigInteger number) {
        if (!number.isProbablePrime(5))
            return false;

        BigInteger two = new BigInteger("2");
        if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
            return false;

        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) { //start from 3, 5, etc. the odd number, and look for a divisor if any
            if (BigInteger.ZERO.equals(number.mod(i))) //check if 'i' is divisor of 'number'
                return false;
        }
        return true;
    }


    // HonakerPrime Algorithmus
    public static BigInteger Honaker(BigInteger Number , BigInteger PrimeIndex) {

        BigInteger PrimeSum = new BigInteger("0");
        BigInteger PrimeTemp;
        BigInteger IndexTemp;
        BigInteger IndexSum = new BigInteger("0");

        for (BigInteger j = Number; j.compareTo(BigInteger.valueOf(0)) > 0; j = j.divide(BigInteger.valueOf(10))) {
            PrimeTemp = j.mod(BigInteger.valueOf(10));
            PrimeSum = PrimeSum.add(PrimeTemp);
        }
        for (BigInteger k = PrimeIndex; k.compareTo(BigInteger.valueOf(0)) > 0; k = k.divide(BigInteger.valueOf(10))) {
            IndexTemp = k.mod(BigInteger.valueOf(10));
            IndexSum = IndexSum.add(IndexTemp);
        }
        if (IndexSum.equals(PrimeSum)) {
            return Number;
        } else return BigInteger.valueOf(0);
    }
}
