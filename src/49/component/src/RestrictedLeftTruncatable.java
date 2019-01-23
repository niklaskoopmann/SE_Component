import java.math.BigInteger;
import java.util.ArrayList;

public class RestrictedLeftTruncatable
{
    // static instance
    private static RestrictedLeftTruncatable instance = new RestrictedLeftTruncatable();

    private RestrictedLeftTruncatable() {
        port = new Port();
    }

    public static RestrictedLeftTruncatable getInstance()
    {
        return instance;
    }

    // define port
    public Port port;

    public class Port implements IRestrictedLeftTruncatable
    {
        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo)
        {
            return executeRestrictedLeftTruncatable(rangeFrom, rangeTo);
        }
    }

    private ArrayList<BigInteger> executeRestrictedLeftTruncatable(BigInteger rangeFrom, BigInteger rangeTo)
    {
        if (rangeFrom.compareTo(BigInteger.TWO) < 0)
            rangeFrom = BigInteger.TWO;

        if (rangeFrom.compareTo(rangeTo) > 0)
            return new ArrayList<>();

        ArrayList<BigInteger> primeNumbers = new ArrayList<>();

        for (BigInteger i = rangeFrom; i.compareTo(rangeTo) < 1; i = i.add(BigInteger.ONE))
        {
            if (isLeftTruncatable(i))
            {
                if (isRestrictedLeftTruncatable(i))
                {
                    primeNumbers.add(i);
                }
            }
        }

        return primeNumbers;
    }

    private boolean isLeftTruncatable(BigInteger number)
    {
        BigInteger whileNumber = number;
        boolean isLeftTruncatableBool = true;

        while (whileNumber.compareTo(BigInteger.ZERO) != 0)
        {
            BigInteger zeroNumber = whileNumber.mod(BigInteger.TEN);
            whileNumber = whileNumber.divide(BigInteger.TEN);

            if (zeroNumber.compareTo(BigInteger.ZERO) == 0)
            {
                isLeftTruncatableBool = false;
                break;
            }
        }

        if (isLeftTruncatableBool)
        {
            whileNumber = number;

            while (whileNumber.compareTo(BigInteger.ZERO) != 0)
            {
                if (!isPrime(whileNumber))
                {
                    isLeftTruncatableBool = false;
                    break;
                }

                whileNumber = reverseNumber(whileNumber);
                whileNumber = whileNumber.divide(BigInteger.TEN);
                whileNumber = reverseNumber(whileNumber);
            }
        }

        return isLeftTruncatableBool;
    }

    private boolean isRestrictedLeftTruncatable(BigInteger number)
    {
        BigInteger copyNumber = number;
        boolean isRestrictedLeftTruncatable = true;
        BigInteger numberToAdd = BigInteger.TEN.pow(copyNumber.toString().length());

        for (int i = 1; i < 10; i++)
        {
            copyNumber = copyNumber.add(numberToAdd);

            if (isPrime(copyNumber))
            {
                isRestrictedLeftTruncatable = false;
                break;
            }
        }

        return isRestrictedLeftTruncatable;
    }

    private BigInteger reverseNumber(BigInteger number)
    {
        String reverseString = new StringBuilder(number.toString()).reverse().toString();
        return new BigInteger(reverseString);
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
