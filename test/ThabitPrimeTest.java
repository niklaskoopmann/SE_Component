class ThabitPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(10);
        BigInteger to = BigInteger.valueOf(15);
        ArrayList<BigInteger> thabitPrimes = new ArrayList<BigInteger>();

        ThabitPrime thabitPrime = ThabitPrime.getInstance();
        thabitPrimes = thabitPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(11);
        resultArray.add(resultBi);
        assertEquals(resultArray, thabitPrimes);


        BigInteger from2 = BigInteger.valueOf(30);
        BigInteger to2 = BigInteger.valueOf(50);
        ArrayList<BigInteger> thabitPrimes2 = new ArrayList<BigInteger>();

        ThabitPrime thabitPrime2 = ThabitPrime.getInstance();
        thabitPrimes = thabitPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(47);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, thabitPrimes);
    }
}