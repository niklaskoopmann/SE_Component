class StrongPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(10);
        BigInteger to = BigInteger.valueOf(15);
        ArrayList<BigInteger> strongPrimes = new ArrayList<BigInteger>();

        StrongPrime strongPrime = StrongPrime.getInstance();
        strongPrimes = strongPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(11);
        resultArray.add(resultBi);
        assertEquals(resultArray, strongPrimes);


        BigInteger from2 = BigInteger.valueOf(35);
        BigInteger to2 = BigInteger.valueOf(40);
        ArrayList<BigInteger> strongPrimes2 = new ArrayList<BigInteger>();

        StrongPrime strongPrime2 = StrongPrime.getInstance();
        strongPrimes = strongPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(37);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, strongPrimes);
    }
}