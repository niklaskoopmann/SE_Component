import java.math.BigInteger;
import java.util.ArrayList;

public interface IComponent {
    ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo);
}
