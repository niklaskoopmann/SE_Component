class TwinReversiblePrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(15);
        BigInteger to = BigInteger.valueOf(75);
        ArrayList<BigInteger> twinReversiblePrimes = new ArrayList<BigInteger>();

        TwinReversiblePrime twinReversiblePrime = TwinReversiblePrimeTest.getInstance();
        twinReversiblePrimes = twinReversiblePrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(17);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(37);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(71);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(73);
        resultArray.add(resultBi);

        assertEquals(resultArray, twinReversiblePrimes);

    }
}