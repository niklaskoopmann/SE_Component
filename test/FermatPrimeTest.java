class FermatPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(1);
        BigInteger to = BigInteger.valueOf(4);
        ArrayList<BigInteger> fermatPrimes = new ArrayList<BigInteger>();

        FermatPrime fermatPrime = FermatPrime.getInstance();
        fermatPrimes = fermatPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(3);
        resultArray.add(resultBi);
        assertEquals(resultArray, fermatPrimes);


        BigInteger from2 = BigInteger.valueOf(4);
        BigInteger to2 = BigInteger.valueOf(6);
        ArrayList<BigInteger> fermatPrimes2 = new ArrayList<BigInteger>();

        FermatPrime fermatPrime2 = FermatPrime.getInstance();
        fermatPrimes = fermatPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(5);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, fermatPrimes);
    }
}