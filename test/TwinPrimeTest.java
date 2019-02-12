class TwinPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(15);
        BigInteger to = BigInteger.valueOf(75);
        ArrayList<BigInteger> twinPrimes = new ArrayList<BigInteger>();

        TwinPrime twinPrime = TwinPrime.getInstance();
        twinPrimes = twinPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(11);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(13);
        resultArray.add(resultBi);

        assertEquals(resultArray, twinPrimes);

    }
}