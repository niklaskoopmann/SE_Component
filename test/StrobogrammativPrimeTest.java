class StrobogrammativPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(10);
        BigInteger to = BigInteger.valueOf(15);
        ArrayList<BigInteger> strobogrammativPrimes = new ArrayList<BigInteger>();

        StrobogrammativPrime strobogrammativPrime = StrobogrammativPrime.getInstance();
        strobogrammativPrimes = strobogrammativPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(11);
        resultArray.add(resultBi);
        assertEquals(resultArray, strobogrammativPrimes);


        BigInteger from2 = BigInteger.valueOf(35);
        BigInteger to2 = BigInteger.valueOf(130);
        ArrayList<BigInteger> strobogrammativPrimes2 = new ArrayList<BigInteger>();

        StrobogrammativPrime strobogrammativPrime2 = StrobogrammativPrime.getInstance();
        strobogrammativPrimes = strobogrammativPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(101);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, strobogrammativPrimes);
    }
}