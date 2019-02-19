import java.math.BigInteger;
import java.util.ArrayList;

public class HoaxNumber {

    private static HoaxNumber instance = new HoaxNumber();
    public static HoaxNumber getInstance(){
        return instance;
    }

    //define port
    public Port port;

    private HoaxNumber(){
        port = new Port();
    }
    public class Port implements IHoaxNumber{
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {
            return calculate(rangeFrom, rangeTo);
        }
    }


    ArrayList<BigInteger> calculate(BigInteger rangeFrom, BigInteger rangeTo){
        ArrayList<BigInteger> hoaxNumbers = new ArrayList<>();

        rangeTo = rangeTo.add(BigInteger.ONE);

        while(!rangeFrom.equals(rangeTo)){
            System.out.println("Testing " + rangeFrom.toString());
            if(checkHoax(rangeFrom)) hoaxNumbers.add(rangeFrom);

            rangeFrom = rangeFrom.add(BigInteger.valueOf(1));
        }

        return hoaxNumbers;
    }

    private boolean checkHoax(BigInteger number){
        if(checkPrime(number)) return false;

        return (calculateDigitSum(splitBigInteger(number)) == calculateDigitSum(splitArray(getDistinctPrimes(number))));

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

    //gibt naechste Zahl zurueck welche eine Primzahl ist
    private BigInteger getNextPrime(BigInteger number){
        if(number.intValue() < 2) return BigInteger.TWO;
        if(number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) number = number.subtract(BigInteger.ONE);
        do{
            number = number.add(BigInteger.TWO);
        }while(!checkPrime(number));

        return number;
    }

    //sucht die Distincten Primzahlen und gibt diese zurueck
    private ArrayList<Integer> getDistinctPrimes(BigInteger number){
        ArrayList<Integer> distinctPrimes = new ArrayList<>();
        BigInteger count = new BigInteger("2");

        while (!number.equals(BigInteger.ONE)){
            if(number.mod(count).equals(BigInteger.ZERO)){
                number = number.divide(count);
                if(!distinctPrimes.contains(count.intValue())) distinctPrimes.add(count.intValue());

                continue;
            }

            count = getNextPrime(count);

        }

        return distinctPrimes;
    }

    //splittet mehrstellige Zahlen auf
    private ArrayList<Integer> splitArray(ArrayList<Integer> list){
        ArrayList<Integer> splitList = new ArrayList<>();
        int flag;

        while (!list.isEmpty()){
            //uebertraegt einstellige Zahlen
            if(list.get(0) <= 9){
                splitList.add(list.remove(0));
                continue;
            }

            //splittet mehrstellige Zahlen auf
            flag = list.remove(0);
            while (flag > 0){
                splitList.add(flag % 10);
                flag = flag / 10;
            }
        }

        return splitList;
    }

    //splittet einen BigInteger in seine Stellen auf
    private ArrayList<Integer> splitBigInteger(BigInteger number){
        ArrayList<Integer> splitArray = new ArrayList<>();

        while (!number.equals(BigInteger.ZERO)){
            splitArray.add(number.mod(new BigInteger("10")).intValue());
            number = number.divide(new BigInteger("10"));
        }

        return splitArray;
    }

    //Berechnet die Summe aus den Zahlen der ArrayList
    private int calculateDigitSum(ArrayList<Integer> list){
        int sum = 0;

        while (!list.isEmpty()) {
            sum += list.remove(0);
        }
        return sum;
    }
}

