class CenterHeptagonalPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(40);
        BigInteger to = BigInteger.valueOf(50);
        ArrayList<BigInteger> centerHeptagonalPrimes = new ArrayList<BigInteger>();

        CenterHeptagonalPrime centerHeptagonalPrime = CenterHeptagonalPrime.getInstance();
        centerHeptagonalPrimes = centerHeptagonalPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(43);
        resultArray.add(resultBi);
        assertEquals(resultArray, centerHeptagonalPrimes);


        BigInteger from2 = BigInteger.valueOf(70);
        BigInteger to2 = BigInteger.valueOf(80);
        ArrayList<BigInteger> centerHeptagonalPrimes2 = new ArrayList<BigInteger>();

        CenterHeptagonalPrime centerHeptagonalPrime2 = CenterHeptagonalPrime.getInstance();
        centerHeptagonalPrimes = centerHeptagonalPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(71);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, centerHeptagonalPrimes);
    }
}