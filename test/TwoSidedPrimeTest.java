class TwoSidedPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(10);
        BigInteger to = BigInteger.valueOf(30);
        ArrayList<BigInteger> twoSidedPrimes = new ArrayList<BigInteger>();

        TwoSidedPrime twoSidedPrime = TwoSidedPrime.getInstance();
        twoSidedPrimes = twoSidedPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(23);
        resultArray.add(resultBi);
        assertEquals(resultArray, twoSidedPrimes);


        BigInteger from2 = BigInteger.valueOf(30);
        BigInteger to2 = BigInteger.valueOf(50);
        ArrayList<BigInteger> twoSidedPrimes2 = new ArrayList<BigInteger>();

        TwoSidedPrime twoSidedPrime2 = TwoSidedPrime.getInstance();
        twoSidedPrimes = twoSidedPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(37);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, twoSidedPrimes);
    }
}