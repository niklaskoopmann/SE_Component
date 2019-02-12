class IsolatedPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(20);
        BigInteger to = BigInteger.valueOf(30);
        ArrayList<BigInteger> isolatedPrimes = new ArrayList<BigInteger>();

        IsolatedPrime isolatedPrime = IsolatedPrime.getInstance();
        isolatedPrimes = isolatedPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(23);
        resultArray.add(resultBi);
        assertEquals(resultArray, isolatedPrimes);


        BigInteger from2 = BigInteger.valueOf(85);
        BigInteger to2 = BigInteger.valueOf(90);
        ArrayList<BigInteger> isolatedPrimes2 = new ArrayList<BigInteger>();

        IsolatedPrime isolatedPrime2 = IsolatedPrime.getInstance();
        isolatedPrimes = isolatedPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(89);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, isolatedPrimes);
    }
}