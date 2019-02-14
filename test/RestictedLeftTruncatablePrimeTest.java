class RestictedLeftTruncatablePrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(0);
        BigInteger to = BigInteger.valueOf(3);
        ArrayList<BigInteger> restictedLeftTruncatablePrimes = new ArrayList<BigInteger>();

        RestictedLeftTruncatablePrime restictedLeftTruncatablePrime = RestictedLeftTruncatablePrime.getInstance();
        restictedLeftTruncatablePrimes = restictedLeftTruncatablePrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(2);
        resultArray.add(resultBi);
        assertEquals(resultArray, restictedLeftTruncatablePrimes);


        BigInteger from2 = BigInteger.valueOf(4);
        BigInteger to2 = BigInteger.valueOf(10);
        ArrayList<BigInteger> restictedLeftTruncatablePrimes2 = new ArrayList<BigInteger>();

        RestictedLeftTruncatablePrime restictedLeftTruncatablePrime2 = RestictedLeftTruncatablePrime.getInstance();
        restictedLeftTruncatablePrimes = restictedLeftTruncatablePrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(5);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, restictedLeftTruncatablePrimes);
    }
}