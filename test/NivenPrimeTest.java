public class NivenPrimeTest {

    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(5);
        BigInteger to = BigInteger.valueOf(15);
        ArrayList<BigInteger> nivenPrimes = new ArrayList<BigInteger>();

        NivenPrime nivenPrime = NivenPrime.getInstance();
        nivenPrime = nivenPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(7);
        resultArray.add(resultBi);

        assertEquals(resultArray, nivenPrime);

    }
}
