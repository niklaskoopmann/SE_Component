public class SumOfNPrime {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(10);
        BigInteger to = BigInteger.valueOf(20);
        ArrayList<BigInteger> twinPrimes = new ArrayList<BigInteger>();

        TwinPrime twinPrime = TwinPrime.getInstance();
        twinPrimes = twinPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(13);
        resultArray.add(resultBi);

        assertEquals(resultArray, twinPrimes);

    }
}
