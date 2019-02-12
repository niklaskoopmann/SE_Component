class SmarandacheWillinPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(0);
        BigInteger to = BigInteger.valueOf(5);
        ArrayList<BigInteger> smarandacheWillinPrimes = new ArrayList<BigInteger>();

        SmarandacheWillinPrime smarandacheWillinPrime = SmarandacheWillinPrime.getInstance();
        smarandacheWillinPrimes = smarandacheWillinPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(2);
        resultArray.add(resultBi);
        assertEquals(resultArray, smarandacheWillinPrimes);


        BigInteger from2 = BigInteger.valueOf(20);
        BigInteger to2 = BigInteger.valueOf(50);
        ArrayList<BigInteger> smarandacheWillinPrimes2 = new ArrayList<BigInteger>();

        SmarandacheWillinPrime smarandacheWillinPrime2 = SmarandacheWillinPrime.getInstance();
        smarandacheWillinPrimes = smarandacheWillinPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(23);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, smarandacheWillinPrimes);
    }
}