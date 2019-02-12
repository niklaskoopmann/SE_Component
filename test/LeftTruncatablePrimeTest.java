class Left-truncatablePrimeTest {

 @Test
 void execute () {

         BigInteger from = BigInteger.valueOf(4);
         BigInteger to = BigInteger.valueOf(6);
         ArrayList<BigInteger> left-truncatablePrimes = new ArrayList<BigInteger>();

        Left-truncatablePrime left-truncatablePrime = Left-truncatablePrime.getInstance();
        left-truncatablePrimes = left-truncatablePrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(5);
        resultArray.add(resultBi);
        assertEquals(resultArray, left-truncatablePrimes);


        BigInteger from2 = BigInteger.valueOf(40);
        BigInteger to2 = BigInteger.valueOf(45);
        ArrayList<BigInteger> left-truncatablePrimes2 = new ArrayList<BigInteger>();

        Left-truncatablePrime left-truncatablePrime2 = Left-truncatablePrime.getInstance();
        left-truncatablePrimes = left-truncatablePrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(43);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, left-truncatablePrimes);
    }
}