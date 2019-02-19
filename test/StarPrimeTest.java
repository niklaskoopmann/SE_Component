class StarPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(10);
        BigInteger to = BigInteger.valueOf(15);
        ArrayList<BigInteger> starPrimes = new ArrayList<BigInteger>();

        StarPrime starPrime = StarPrime.getInstance();
        starPrimes = starPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(13);
        resultArray.add(resultBi);
        assertEquals(resultArray, starPrimes);


        BigInteger from2 = BigInteger.valueOf(35);
        BigInteger to2 = BigInteger.valueOf(40);
        ArrayList<BigInteger> starPrimes2 = new ArrayList<BigInteger>();

        StarPrime starPrime2 = StarPrime.getInstance();
        starPrimes = starPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(37);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, starPrimes);
    }
}