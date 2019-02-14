class MountainPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(0);
        BigInteger to = BigInteger.valueOf(4);
        ArrayList<BigInteger> mountainPrimes = new ArrayList<BigInteger>();

        MountainPrime mountainPrime = MountainPrime.getInstance();
        mountainPrimes = mountainPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(3);
        resultArray.add(resultBi);
        assertEquals(resultArray, mountainPrimes);


        BigInteger from2 = BigInteger.valueOf(7);
        BigInteger to2 = BigInteger.valueOf(10);
        ArrayList<BigInteger> mountainPrimes2 = new ArrayList<BigInteger>();

        MountainPrime mountainPrime2 = MountainPrime.getInstance();
        mountainPrimes = mountainPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(9);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, mountainPrimes);
    }
}