class RestictedRightTruncatablePrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(50);
        BigInteger to = BigInteger.valueOf(55);
        ArrayList<BigInteger> restictedRightTruncatablePrimes = new ArrayList<BigInteger>();

        RestictedRightTruncatablePrime restictedRightTruncatablePrime = RestictedRightTruncatablePrime.getInstance();
        restictedRightTruncatablePrimes = restictedRightTruncatablePrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(53);
        resultArray.add(resultBi);
        assertEquals(resultArray, restictedRightTruncatablePrimes);


        BigInteger from2 = BigInteger.valueOf(300);
        BigInteger to2 = BigInteger.valueOf(330);
        ArrayList<BigInteger> restictedRightTruncatablePrimes2 = new ArrayList<BigInteger>();

        RestictedRightTruncatablePrime restictedRightTruncatablePrime2 = RestictedRightTruncatablePrime.getInstance();
        restictedRightTruncatablePrimes = restictedRightTruncatablePrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(317);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, restictedRightTruncatablePrimes);
    }
}