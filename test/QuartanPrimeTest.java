class QuartanPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(0);
        BigInteger to = BigInteger.valueOf(3);
        ArrayList<BigInteger> quartanPrimes = new ArrayList<BigInteger>();

        QuartanPrime quartanPrime = QuartanPrime.getInstance();
        quartanPrimes = quartanPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(2);
        resultArray.add(resultBi);
        assertEquals(resultArray, quartanPrimes);


        BigInteger from2 = BigInteger.valueOf(15);
        BigInteger to2 = BigInteger.valueOf(20);
        ArrayList<BigInteger> quartanPrimes2 = new ArrayList<BigInteger>();

        QuartanPrime quartanPrime2 = QuartanPrime.getInstance();
        quartanPrimes = quartanPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(17);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, quartanPrimes);
    }
}