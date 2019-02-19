class CenterSquarePrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(0);
        BigInteger to = BigInteger.valueOf(10);
        ArrayList<BigInteger> centerSquarePrimes = new ArrayList<BigInteger>();

        CenterSquarePrime centerSquarePrime = CenterSquarePrime.getInstance();
        centerSquarePrimes = centerSquarePrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(5);
        resultArray.add(resultBi);
        assertEquals(resultArray, centerSquarePrimes);


        BigInteger from2 = BigInteger.valueOf(10);
        BigInteger to2 = BigInteger.valueOf(20);
        ArrayList<BigInteger> centerSquarePrimes2 = new ArrayList<BigInteger>();

        CenterSquarePrime centerSquarePrime2 = CenterSquarePrime.getInstance();
        centerSquarePrimes = centerSquarePrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(13);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, centerSquarePrimes);
    }
}