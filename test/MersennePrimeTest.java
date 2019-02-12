class MersennePrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(0);
        BigInteger to = BigInteger.valueOf(5);
        ArrayList<BigInteger> mersennePrimes = new ArrayList<BigInteger>();

        MersennePrime mersennePrime = MersennePrime.getInstance();
        mersennePrimes = mersennePrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(3);
        resultArray.add(resultBi);
        assertEquals(resultArray, mersennePrimes);


        BigInteger from2 = BigInteger.valueOf(30);
        BigInteger to2 = BigInteger.valueOf(40);
        ArrayList<BigInteger> mersennePrimes2 = new ArrayList<BigInteger>();

        MersennePrime mersennePrime2 = MersennePrime.getInstance();
        mersennePrimes = mersennePrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(31);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, mersennePrimes);
    }
}