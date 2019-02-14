class FactorialPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(20);
        BigInteger to = BigInteger.valueOf(50);
        ArrayList<BigInteger> factorialPrimes = new ArrayList<BigInteger>();

        FactorialPrime factorialPrime = FactorialPrime.getInstance();
        factorialPrimes = factorialPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(23);
        resultArray.add(resultBi);
        assertEquals(resultArray, factorialPrimes);


        BigInteger from2 = BigInteger.valueOf(6);
        BigInteger to2 = BigInteger.valueOf(8);
        ArrayList<BigInteger> factorialPrimes2 = new ArrayList<BigInteger>();

        FactorialPrime factorialPrime2 = FactorialPrime.getInstance();
        factorialPrimes = factorialPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(7);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, factorialPrimes);
    }
}