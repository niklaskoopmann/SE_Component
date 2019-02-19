public class SexyPrimeTest {

    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(130);
        BigInteger to = BigInteger.valueOf(140);
        ArrayList<BigInteger> sexyPrimes = new ArrayList<BigInteger>();

        SexyPrime sexyPrime = SexyPrime.getInstance();
        sexyPrimes = sexyPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(131);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(137);
        resultArray.add(resultBi);

        assertEquals(resultArray, sexyPrimes);

    }

}
