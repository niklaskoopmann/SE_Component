import java.math.BigInteger;
import java.util.ArrayList;

public class MountainPrime {
    public static MountainPrime instance = new MountainPrime();

    private MountainPrime() {
        port = new Port();
    }

    public static MountainPrime getInstance() {
        return instance;
    }

    public Port port;

    public class Port implements IMountainPrime {

        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return executeMountainPrime(rangeFrom, rangeTo);
        }
    }

    private ArrayList<BigInteger> executeMountainPrime(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> mountainPrimes = new ArrayList<>();
        int digitcount;

        /** Auf sinnvolle Eingabe prüfen
         *
         */
        if (rangeFrom.compareTo(rangeTo) == 1) {
            return mountainPrimes;
        }

        /**
         * Bei gerader Zahl auf ungerade erhöhen
          */

        if (rangeFrom.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0) {
            rangeFrom.add(BigInteger.ONE);
        }
        /**
         * prüfung, solange erlaubte werte vorliegen
         */
        while (rangeFrom.compareTo(rangeTo) == -1) {
            digitcount = rangeFrom.toString().length();
            if (digitcount == 3 | digitcount == 5 | digitcount == 9 | digitcount == 11) {
                if (primetest(rangeFrom) & mountainTest(rangeFrom)) {
                    mountainPrimes.add(rangeFrom);
                }

                rangeFrom = rangeFrom.add(BigInteger.TWO);
            } else {
                switch (digitcount) {
                    case 1:
                    case 2:
                        rangeFrom = BigInteger.valueOf(101);
                        break;
                    case 4:
                        rangeFrom = BigInteger.valueOf(10001);
                        break;
                    case 6:
                    case 7:
                    case 8:
                        rangeFrom = BigInteger.valueOf(100000001);
                        break;
                    case 10:
                        BigInteger eleven = new BigInteger("10000000001");
                        rangeFrom = eleven;
                        break;
                    default:
                        rangeTo = BigInteger.ZERO;
                        break;
                }
            }
        }
        return mountainPrimes;
    }

    /**
     * für BigInteger angepasste Primzahlprüfung
     */
    private boolean primetest(BigInteger number) {
        BigInteger index = new BigInteger("3");
        if (number.compareTo(BigInteger.ONE) != 1) {
            return false;
        }
        if (number.compareTo(BigInteger.TWO) == 0) {
            return true;
        }
        if (number.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0) {
            return false;
        }

        while ((index.multiply(index).compareTo(number)) == -1 & number.mod(index).compareTo(BigInteger.ZERO) != 0) {
            index = index.add(BigInteger.TWO);
        }
        if (index.multiply(index).compareTo(number) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Test ob die erste und letzte Zahl eine eins ist
     * und ob die "Bergform" eingehalten ist
     */
    private static boolean mountainTest(BigInteger number) {
        String snumber = number.toString();
        int[] digits = new int[snumber.length()];
        for (int i=0;i<snumber.length();i++){
            digits[i]=Integer.parseInt( snumber.substring( i, i+1));
        }
        //Prüfen, ob erste und letzte Zahl 1 ist
        if(digits[0]!=1 | digits[digits.length-1]!=1){
            return false;
        }

        //prüfung ob mountain
        for (int i = 0; i < (snumber.length() - 1); i++) {
            //erster teilprüfung ob nachfolger größer
            if (i < (snumber.length() / 2) & digits[i] >= digits[i + 1]) {
                return false;
                //zweiter teil prüfung ob nachfolger kleiner
            } else if (i >= (snumber.length() / 2) & digits[i] <= digits[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
