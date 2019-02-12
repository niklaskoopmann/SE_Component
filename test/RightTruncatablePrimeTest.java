class RightTruncatablePrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(4);
        BigInteger to = BigInteger.valueOf(6);
        ArrayList<BigInteger> rightTruncatablePrimes = new ArrayList<BigInteger>();

        RightTruncatablePrime rightTruncatablePrime = RightTruncatablePrime.getInstance();
        rightTruncatablePrimes = rightTruncatablePrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(5);
        resultArray.add(resultBi);
        assertEquals(resultArray, rightTruncatablePrimes);


        BigInteger from2 = BigInteger.valueOf(20);
        BigInteger to2 = BigInteger.valueOf(26);
        ArrayList<BigInteger> rightTruncatablePrimes2 = new ArrayList<BigInteger>();

        RightTruncatablePrime rightTruncatablePrime2 = RightTruncatablePrime.getInstance();
        rightTruncatablePrimes = rightTruncatablePrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(23);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, rightTruncatablePrimes);
    }
}