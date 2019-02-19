class PermutablePrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(4);
        BigInteger to = BigInteger.valueOf(6);
        ArrayList<BigInteger> permutablePrimes = new ArrayList<BigInteger>();

        PermutablePrime permutablePrime = PermutablePrime.getInstance();
        permutablePrimes = permutablePrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(5);
        resultArray.add(resultBi);
        assertEquals(resultArray, permutablePrimes);


        BigInteger from2 = BigInteger.valueOf(6);
        BigInteger to2 = BigInteger.valueOf(8);
        ArrayList<BigInteger> permutablePrimes2 = new ArrayList<BigInteger>();

        PermutablePrime permutablePrime2 = PermutablePrime.getInstance();
        permutablePrimes = permutablePrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(7);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, permutablePrimes);
    }
}