import java.math.BigInteger;
import java.util.ArrayList;

public class Bemirp
{
    // static instance
    private static Bemirp instance = new Bemirp();

    private Bemirp()
    {
        port = new Port();
    }

    public static Bemirp getInstance()
    {
        return instance;
    }

    // define port
    public Port port;

    public class Port implements IBemirp
    {
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo)
        {
            return executeBemirp(rangeFrom, rangeTo);
        }
    }

    private ArrayList<BigInteger> executeBemirp(BigInteger rangeFrom, BigInteger rangeTo)
    {
        if (rangeFrom.compareTo(BigInteger.TWO) < 0)
            rangeFrom = BigInteger.TWO;

        if (rangeFrom.compareTo(rangeTo) > 0)
            return new ArrayList<>();

        ArrayList<BigInteger> primeNumbers = new ArrayList<>();

        for (BigInteger i = rangeFrom; i.compareTo(rangeTo) < 1; i = i.add(BigInteger.ONE))
        {
            if (containsCorrectNumbers(i))
            {
                if (isPrime(i))
                {
                    if (isPrime(reverseNumber(i)))
                    {
                        BigInteger testNumber = upsideDownNumber(i);

                        if (isPrime(testNumber))
                        {
                            if (isPrime(reverseNumber(testNumber)))
                            {
                                primeNumbers.add(i);
                            }
                        }
                    }
                }
            }
        }

        return primeNumbers;
    }

    private boolean containsCorrectNumbers(BigInteger number)
    {
        BigInteger whileNumber = number;
        boolean containsCorrectNumbers = true;
        boolean containsReverseNumbers = false;

        while (whileNumber.compareTo(BigInteger.ZERO) != 0)
        {
            int digit = Integer.parseInt(whileNumber.mod(BigInteger.TEN).toString());
            whileNumber = whileNumber.divide(BigInteger.TEN);

            if (!containsReverseNumbers && (digit == 6 || digit == 9))
                containsReverseNumbers = true;


            if (digit == 2 || digit == 3 || digit == 4 || digit == 5 || digit == 3 || digit == 7)
            {
                containsCorrectNumbers = false;
                break;
            }
        }

        if ((number.compareTo(reverseNumber(number)) == 0) || (reverseNumber(number).compareTo(upsideDownNumber(number)) == 0))
            return false;

        return containsCorrectNumbers && containsReverseNumbers;
    }

    private BigInteger reverseNumber(BigInteger number)
    {
        String reverseString = new StringBuilder(number.toString()).reverse().toString();
        return new BigInteger(reverseString);
    }

    private BigInteger upsideDownNumber(BigInteger number)
    {
        BigInteger copyNumber = number;
        ArrayList<BigInteger> digits = new ArrayList<>();

        while (copyNumber.compareTo(BigInteger.ZERO) != 0)
        {
            BigInteger digit = copyNumber.mod(BigInteger.TEN);
            digits.add(digit);

            copyNumber = copyNumber.divide(BigInteger.TEN);
        }

        BigInteger upsideDownNumberBigInteger = BigInteger.ZERO;

        for (int i = digits.size() - 1; i >= 0; i--)
        {
            upsideDownNumberBigInteger = upsideDownNumberBigInteger.multiply(BigInteger.TEN);

            BigInteger numberToAdd;

            if (digits.get(i).compareTo(BigInteger.valueOf(6)) == 0)
            {
                numberToAdd = BigInteger.valueOf(9);
            }
            else if (digits.get(i).compareTo(BigInteger.valueOf(9)) == 0)
            {
                numberToAdd = BigInteger.valueOf(6);
            }
            else
            {
                numberToAdd = digits.get(i);
            }


            upsideDownNumberBigInteger = upsideDownNumberBigInteger.add(numberToAdd);
        }

        return upsideDownNumberBigInteger;
    }

    private boolean isPrime(BigInteger number)
    {
        BigInteger index = new BigInteger("3");

        if (number.compareTo(BigInteger.ONE) != 1)
            return false;

        if (number.compareTo(BigInteger.TWO) == 0)
            return true;

        if (number.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0)
            return false;

        while ((index.multiply(index).compareTo(number)) == -1 & number.mod(index).compareTo(BigInteger.ZERO) != 0)
            index = index.add(BigInteger.TWO);

        if (index.multiply(index).compareTo(number) == 1)
            return true;
        else
            return false;
    }
}
