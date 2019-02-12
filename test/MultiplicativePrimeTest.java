class MultiplicativePrimeTest {
    @Test
    void execute() {

        BigInteger from = BigInteger.valueOf(4);
        BigInteger to = BigInteger.valueOf(6);
        ArrayList<BigInteger> multiplicativePrimes = new ArrayList<BigInteger>();

        MultiplicativePrime multiplicativePrime = MultiplicativePrime.getInstance();
        multiplicativePrimes = multiplicativePrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(5);
        resultArray.add(resultBi);
        assertEquals(resultArray, multiplicativePrimes);


        BigInteger from2 = BigInteger.valueOf(6);
        BigInteger to2 = BigInteger.valueOf(8);
        ArrayList<BigInteger> multiplicativePrimes2 = new ArrayList<BigInteger>();

        MultiplicativePrime multiplicativePrime2 = MultiplicativePrime.getInstance();
        multiplicativePrimes = multiplicativePrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(7);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, multiplicativePrimes);
    }
}