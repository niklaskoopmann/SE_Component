class PalindromicPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(4);
        BigInteger to = BigInteger.valueOf(6);
        ArrayList<BigInteger> palindromicPrimes = new ArrayList<BigInteger>();

        PalindromicPrime palindromicPrime = PalindromicPrime.getInstance();
        palindromicPrimes = palindromicPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(5);
        resultArray.add(resultBi);
        assertEquals(resultArray, palindromicPrimes);


        BigInteger from2 = BigInteger.valueOf(6);
        BigInteger to2 = BigInteger.valueOf(8);
        ArrayList<BigInteger> palindromicPrimes2 = new ArrayList<BigInteger>();

        PalindromicPrime palindromicPrime2 = PalindromicPrime.getInstance();
        palindromicPrimes = palindromicPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(7);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, palindromicPrimes);
    }
}