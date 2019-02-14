import java.math.BigInteger;
import java.util.ArrayList;

public class QuartanPrime {

    private static QuartanPrime instance = new QuartanPrime();

    public static QuartanPrime getInstance() {
        return instance;
    }

    public Port port;

    private QuartanPrime() {
        port = new Port();
    }

    public class Port implements IQuartanPrime{
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {

            ArrayList<BigInteger> prime = new ArrayList<BigInteger>();

            BigInteger number = new BigInteger("1");
            BigInteger counter = new BigInteger("2");
            boolean stopLoop = true;

            if (rangeFrom.compareTo(new BigInteger("10")) <= 0) {
                prime.add(new BigInteger("2"));
            }

            while (number.compareTo(rangeTo) < 0) {

                number = counter;

                for (BigInteger f = new BigInteger("0");
                     f.compareTo(new BigInteger("3")) < 0;
                     f = f.add(BigInteger.ONE)) {

                    number = number.multiply(counter);
                }

                BigInteger save = number;

                if (counter.mod(new BigInteger("2")).equals(BigInteger.ONE)) {
                    BigInteger even = new BigInteger("2");
                    BigInteger dontChange = new BigInteger("2");
                    boolean proof = true;

                    while (even.compareTo(counter) < 0) {

                        for (BigInteger f = new BigInteger("0");
                             f.compareTo(new BigInteger("3")) < 0;
                             f = f.add(BigInteger.ONE)) {

                            even = even.multiply(dontChange);
                        }

                        number = save.add(even);

                        if (number.compareTo(rangeTo) <= 0 && number.compareTo(rangeFrom) >= 0) {
                            for (BigInteger i = BigInteger.TWO;
                                 i.multiply(i).compareTo(number) <= 0;
                                 i = i.add(BigInteger.ONE)) {
                                if (number.mod(i).equals(BigInteger.ZERO)) {
                                    proof = false;
                                    break;
                                }
                            }

                            if (proof) {
                                prime.add(number);
                            }

                        }
                        dontChange = dontChange.add(new BigInteger("2"));
                        even = dontChange;
                        proof = true;
                    }
                } else {
                    BigInteger uneven = BigInteger.ONE;
                    BigInteger dontChange = BigInteger.ONE;
                    boolean proof = true;

                    while (uneven.compareTo(counter) < 0) {

                        for (BigInteger f = new BigInteger("0");
                             f.compareTo(new BigInteger("3")) < 0;
                             f = f.add(BigInteger.ONE)) {

                            uneven = uneven.multiply(dontChange);
                        }
                        number = save.add(uneven);

                        if (number.compareTo(rangeTo) <= 0 && number.compareTo(rangeFrom) >= 0) {

                            for (BigInteger i = BigInteger.TWO;
                                 i.multiply(i).compareTo(number) <= 0;
                                 i = i.add(BigInteger.ONE)) {

                                if (number.mod(i).equals(BigInteger.ZERO)) {
                                    proof = false;
                                    break;
                                }
                            }

                            if (proof) {
                                prime.add(number);
                            }
                        }
                        dontChange = dontChange.add(new BigInteger("2"));
                        uneven = dontChange;
                        proof = true;
                    }
                }
                counter = counter.add(BigInteger.ONE);
            }
            return prime;
        }
    }
}
