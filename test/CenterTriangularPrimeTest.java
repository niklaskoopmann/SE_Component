class CenterTriangularPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(0);
        BigInteger to = BigInteger.valueOf(20);
        ArrayList<BigInteger> centerTriangularPrimes = new ArrayList<BigInteger>();

        CenterTriangularPrime centerTriangularPrime = CenterTriangularPrime.getInstance();
        centerTriangularPrimes = centerTriangularPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(19);
        resultArray.add(resultBi);
        assertEquals(resultArray, centerTriangularPrimes);


        BigInteger from2 = BigInteger.valueOf(30);
        BigInteger to2 = BigInteger.valueOf(40);
        ArrayList<BigInteger> centerTriangularPrimes2 = new ArrayList<BigInteger>();

        CenterTriangularPrime centerTriangularPrime2 = CenterTriangularPrime.getInstance();
        centerTriangularPrimes = centerTriangularPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(31);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, centerTriangularPrimes);
    }
}