class CenterDecagonalPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(5);
        BigInteger to = BigInteger.valueOf(15);
        ArrayList<BigInteger> centerDecagonalPrimes = new ArrayList<BigInteger>();

        CenterDecagonalPrime centerDecagonalPrime = CenterDecagonalPrime.getInstance();
        centerDecagonalPrimes = centerDecagonalPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(11);
        resultArray.add(resultBi);
        assertEquals(resultArray, centerDecagonalPrimes);


        BigInteger from2 = BigInteger.valueOf(30);
        BigInteger to2 = BigInteger.valueOf(40);
        ArrayList<BigInteger> centerDecagonalPrimes2 = new ArrayList<BigInteger>();

        CenterDecagonalPrime centerDecagonalPrime2 = CenterDecagonalPrime.getInstance();
        centerDecagonalPrimes = centerDecagonalPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(31);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, centerDecagonalPrimes);
    }
}