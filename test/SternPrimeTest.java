class SternPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(15);
        BigInteger to = BigInteger.valueOf(20);
        ArrayList<BigInteger> sternPrimes = new ArrayList<BigInteger>();

        SternPrime sternPrime = SternPrime.getInstance();
        sternPrimes = sternPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(17);
        resultArray.add(resultBi);
        assertEquals(resultArray, sternPrimes);


        BigInteger from2 = BigInteger.valueOf(130);
        BigInteger to2 = BigInteger.valueOf(140);
        ArrayList<BigInteger> sternPrimes2 = new ArrayList<BigInteger>();

        SternPrime sternPrime2 = SternPrime.getInstance();
        sternPrimes = sternPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(137);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, sternPrimes);
    }
}