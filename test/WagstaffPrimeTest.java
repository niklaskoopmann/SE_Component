class WagstaffPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(10);
        BigInteger to = BigInteger.valueOf(30);
        ArrayList<BigInteger> wagstaffPrimes = new ArrayList<BigInteger>();

        WagstaffPrime wagstaffPrime = WagstaffPrime.getInstance();
        wagstaffPrimes = wagstaffPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(11);
        resultArray.add(resultBi);
        assertEquals(resultArray, wagstaffPrimes);


        BigInteger from2 = BigInteger.valueOf(30);
        BigInteger to2 = BigInteger.valueOf(50);
        ArrayList<BigInteger> wagstaffPrimes2 = new ArrayList<BigInteger>();

        WagstaffPrime wagstaffPrime2 = WagstaffPrime.getInstance();
        wagstaffPrimes = wagstaffPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(43);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, wagstaffPrimes);
    }
}