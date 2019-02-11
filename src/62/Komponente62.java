import java.math.BigInteger;
import java.util.ArrayList;

public class Komponente62 {

    private static Komponente62 instance = new Komponente62();
    public Port port;

    private Komponente62() {
        port = new Port();
    }

    public static Komponente62 getInstance() {
        return instance;
    }

    public class Port implements IKomponente62 {
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return innerMethodExecute(rangeFrom, rangeTo);
        }
    }

    private ArrayList<BigInteger> innerMethodExecute(BigInteger rangeFrom, BigInteger rangeTo) {
        BigInteger border = rangeFrom;
        if(rangeFrom.compareTo(new BigInteger("2")) < 0) {
            border = new BigInteger("2");
        }
        ArrayList<BigInteger> candidates = generatePrimes(border, rangeTo);
        ArrayList<BigInteger> solution = new ArrayList<>();
        for (BigInteger number : candidates) {
            if (checkNumber(number)) {
                solution.add(number);
            }
        }
        return solution;
    }

    private boolean checkNumber(BigInteger candidate) {
        BigInteger displacement = new BigInteger("2");
        BigInteger candidatePlus = candidate.add(displacement);
        BigInteger candidateMinus = candidate.subtract(displacement);
        if(candidateMinus.intValue() < 0) {
            candidateMinus = candidatePlus;
        }
        if ((candidateMinus.sqrt().multiply(candidateMinus.sqrt()).equals(candidateMinus)) || (candidatePlus.sqrt().multiply(candidatePlus.sqrt()).equals(candidatePlus))) {
            return true;
        } else {
            return false;
        }
    }

    private ArrayList<BigInteger> generatePrimes(BigInteger rangeFrom, BigInteger rangeTo) {
        ArrayList<BigInteger> list = new ArrayList();
        BigInteger counter = new BigInteger(rangeFrom.toString());
        while (counter.compareTo(rangeTo.add(new BigInteger("1"))) != 0) {
            if (isPrime(counter)) {
                list.add(counter);
            }
            counter = counter.add(new BigInteger("1"));
        }
        return list;
    }

    private boolean isPrime(BigInteger testNumber) {
        int divisorCounter = 1;
        BigInteger index, i;

        for (index = new BigInteger("2"); index.compareTo(testNumber) != 1; index = index.add(new BigInteger("1"))) {
            for (i = new BigInteger("2"); i.compareTo(index) != 1; i = i.add(new BigInteger("1"))) {
                if ((testNumber.mod(i).equals(BigInteger.ZERO))) {
                    divisorCounter++;
                }
                if (divisorCounter > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
