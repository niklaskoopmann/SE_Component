class BalancedPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(370);
        BigInteger to = BigInteger.valueOf(380);
        ArrayList<BigInteger> balancedPrimes = new ArrayList<BigInteger>();

        BalancedPrime balancedPrime = BalancedPrime.getInstance();
        balancedPrimes = balancedPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(373);
        resultArray.add(resultBi);
        assertEquals(resultArray, balancedPrimes);


        BigInteger from2 = BigInteger.valueOf(960);
        BigInteger to2 = BigInteger.valueOf(980);
        ArrayList<BigInteger> balancedPrimes2 = new ArrayList<BigInteger>();

        BalancedPrime balancedPrime2 = BalancedPrime.getInstance();
        balancedPrimes = balancedPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(977);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, balancedPrimes);
    }
}