import java.math.BigInteger;
import java.util.ArrayList;

public interface ISuperPrime {
    public interface IEconomicalNumber {
        ArrayList<BigInteger> execute (BigInteger rangeFrom, BigInteger rangeTo);
    }
}
