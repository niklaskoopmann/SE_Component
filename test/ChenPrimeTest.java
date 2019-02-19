class ChenPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(15);
        BigInteger to = BigInteger.valueOf(18);
        ArrayList<BigInteger> chenPrimes = new ArrayList<BigInteger>();

        ChenPrime chenPrime = ChenPrime.getInstance();
        chenPrimes = chenPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(17);
        resultArray.add(resultBi);
        assertEquals(resultArray, chenPrimes);


        BigInteger from2 = BigInteger.valueOf(35);
        BigInteger to2 = BigInteger.valueOf(40);
        ArrayList<BigInteger> chenPrimes2 = new ArrayList<BigInteger>();

        ChenPrime chenPrime2 = ChenPrime.getInstance();
        chenPrimes = chenPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(37);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, chenPrimes);
    }
}