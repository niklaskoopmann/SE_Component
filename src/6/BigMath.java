import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * Provides some mathematical operations on BigDecimal and BigInteger
 */
public class BigMath {

    protected static final double LOG2 = Math.log(2.0);
    protected static final double LOG10 = Math.log(10.0);

    // numbers greater than 10^MAX_DIGITS_10 or e^MAX_DIGITS_EXP are considered unsafe ('too big') for floating point operations
    protected static final int MAX_DIGITS_EXP = 677;
    protected static final int MAX_DIGITS_10 = 294; // ~ MAX_DIGITS_EXP/LN(10)
    protected static final int MAX_DIGITS_2 = 977; // ~ MAX_DIGITS_EXP/LN(2)

    /**
     * Computes the natural logarithm of a BigInteger. 
     *
     * Works for really big integers (practically unlimited), even when the argument 
     * falls outside the <tt>double</tt> range
     *
     * Returns Nan if argument is negative, NEGATIVE_INFINITY if zero.
     *
     * @param val Argument
     * @return Natural logarithm, as in <tt>Math.log()</tt>
     */
    public static double logBigInteger(BigInteger val) {
        if (val.signum() < 1)
            return val.signum() < 0 ? Double.NaN : Double.NEGATIVE_INFINITY;
        int blex = val.bitLength() - MAX_DIGITS_2; // any value in 60..1023 works ok here
        if (blex > 0)
            val = val.shiftRight(blex);
        double res = Math.log(val.doubleValue());
        return blex > 0 ? res + blex * LOG2 : res;
    }

    /**
     * Computes the natural logarithm of a BigDecimal. 
     *
     * Works for really big (or really small) arguments, even outside the double range.
     *
     * Returns Nan if argument is negative, NEGATIVE_INFINITY if zero.
     *
     * @param val Argument
     * @return Natural logarithm, as in <tt>Math.log()</tt>
     */
    public static double logBigDecimal(BigDecimal val) {
        if (val.signum() < 1)
            return val.signum() < 0 ? Double.NaN : Double.NEGATIVE_INFINITY;
        int digits = val.precision() - val.scale();
        if (digits < MAX_DIGITS_10 && digits > -MAX_DIGITS_10)
            return Math.log(val.doubleValue());
        else
            return logBigInteger(val.unscaledValue()) - val.scale() * LOG10;
    }

    /**
     * Computes the exponential function, returning a BigDecimal (precision ~ 16).
     *
     * Works for very big and very small exponents, even when the result 
     * falls outside the double range
     *
     * @param exponent Any finite value (infinite or Nan throws IllegalArgumentException)
     * @return The value of e (base of the natural logarithms) raised to the given exponent, as in <tt>Math.exp()</tt>
     */
    public static BigDecimal expBig(double exponent) {
        if (!Double.isFinite(exponent))
            throw new IllegalArgumentException("Infinite not accepted: " + exponent);
        // e^b = e^(b2+c) = e^b2 2^t with e^c = 2^t 
        double bc = MAX_DIGITS_EXP;
        if (exponent < bc && exponent > -bc)
            return new BigDecimal(Math.exp(exponent), MathContext.DECIMAL64);
        boolean neg = false;
        if (exponent < 0) {
            neg = true;
            exponent = -exponent;
        }
        double b2 = bc;
        double c = exponent - bc;
        int t = (int) Math.ceil(c / LOG10);
        c = t * LOG10;
        b2 = exponent - c;
        if (neg) {
            b2 = -b2;
            t = -t;
        }
        return new BigDecimal(Math.exp(b2), MathContext.DECIMAL64).movePointRight(t);
    }

    /**
     * Same as Math.pow(a,b) but returns a BigDecimal (precision ~ 16). 
     *
     * Works even for outputs that fall outside the <tt>double</tt> range
     *
     * The only limit is that b * log(a) does not overflow the double range 
     *
     * @param a Base. Should be non-negative 
     * @param b Exponent. Should be finite (and non-negative if base is zero)
     * @return Returns the value of the first argument raised to the power of the second argument.
     */
    public static BigDecimal powBig(double a, double b) {
        if (!(Double.isFinite(a) && Double.isFinite(b)))
            throw new IllegalArgumentException(Double.isFinite(b) ? "base not finite: a=" + a : "exponent not finite: b=" + b);
        if (b == 0)
            return BigDecimal.ONE;
        if (b == 1)
            return BigDecimal.valueOf(a);
        if (a == 0) {
            if (b >= 0)
                return BigDecimal.ZERO;
            else
                throw new IllegalArgumentException("0**negative = infinite");
        }
        if (a < 0) {
            throw new IllegalArgumentException("negative base a=" + a);
        }
        double x = b * Math.log(a);
        if (Math.abs(x) < MAX_DIGITS_EXP)
            return BigDecimal.valueOf(Math.pow(a, b));
        else
            return expBig(x);
    }

    public static BigInteger sqrt(BigInteger x)
    {
        if (x.compareTo(BigInteger.ONE) < 0)
        {
            return BigInteger.ZERO.subtract(BigInteger.ONE);
        }
        BigInteger low, hi, tmp, two;
        low = BigInteger.ONE;
        two = hi = tmp = new BigInteger("2");
        while (x.divide(tmp).compareTo(tmp) > 0)
        {
            low = tmp;
            tmp = tmp.multiply(two);
        }   // verdopple tmp bis es grösser als die Wurzel ist
        if (x.divide(tmp).compareTo(tmp) == 0)
        {
            return tmp;
        }
        while (low.compareTo(tmp) != 0)
        {
            if (x.divide(tmp).compareTo(tmp) < 0)
            {
                hi = tmp;
            } else
            {
                low = tmp;
            }
            tmp = low.add(hi).divide(two);
        }   // Binary Search abwärts
        return tmp;
    }

    public static boolean returnPrime(BigInteger number) {
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

}