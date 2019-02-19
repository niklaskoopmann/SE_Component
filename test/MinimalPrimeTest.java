class MinimalPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(4);
        BigInteger to = BigInteger.valueOf(6);
        ArrayList<BigInteger> minimalPrimes = new ArrayList<BigInteger>();

        MinimalPrime minimalPrime = MinimalPrime.getInstance();
        minimalPrimes = minimalPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(5);
        resultArray.add(resultBi);
        assertEquals(resultArray, minimalPrimes);


        BigInteger from2 = BigInteger.valueOf(40);
        BigInteger to2 = BigInteger.valueOf(45);
        ArrayList<BigInteger> minimalPrimes2 = new ArrayList<BigInteger>();

        MinimalPrime minimalPrime2 = MinimalPrime.getInstance();
        minimalPrimes = minimalPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(41);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, minimalPrimes);
    }
}