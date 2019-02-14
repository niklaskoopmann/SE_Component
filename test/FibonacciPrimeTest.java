class FibonacciPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(200);
        BigInteger to = BigInteger.valueOf(240);
        ArrayList<BigInteger> fibonacciPrimes = new ArrayList<BigInteger>();

        FibonacciPrime fibonacciPrime = FibonacciPrime.getInstance();
        fibonacciPrimes = fibonacciPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(233);
        resultArray.add(resultBi);
        assertEquals(resultArray, fibonacciPrimes);


        BigInteger from2 = BigInteger.valueOf(1500);
        BigInteger to2 = BigInteger.valueOf(1600);
        ArrayList<BigInteger> fibonacciPrimes2 = new ArrayList<BigInteger>();

        FibonacciPrime fibonacciPrime2 = FibonacciPrime.getInstance();
        fibonacciPrimes = fibonacciPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(1597);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, fibonacciPrimes);
    }
}