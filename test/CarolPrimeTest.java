class CarolPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(5);
        BigInteger to = BigInteger.valueOf(10);
        ArrayList<BigInteger> carolPrimes = new ArrayList<BigInteger>();

        CarolPrime carolPrime = CarolPrime.getInstance();
        carolPrimes = carolPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(7);
        resultArray.add(resultBi);
        assertEquals(resultArray, carolPrimes);


        BigInteger from2 = BigInteger.valueOf(40);
        BigInteger to2 = BigInteger.valueOf(50);
        ArrayList<BigInteger> carolPrimes2 = new ArrayList<BigInteger>();

        CarolPrime carolPrime2 = CarolPrime.getInstance();
        carolPrimes = carolPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(47);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, carolPrimes);
    }
}