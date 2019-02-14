class KyneaPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(0);
        BigInteger to = BigInteger.valueOf(5);
        ArrayList<BigInteger> kyneaPrimes = new ArrayList<BigInteger>();

        KyneaPrime kyneaPrime = KyneaPrime.getInstance();
        kyneaPrimes = kyneaPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(2);
        resultArray.add(resultBi);
        assertEquals(resultArray, kyneaPrimes);


        BigInteger from2 = BigInteger.valueOf(20);
        BigInteger to2 = BigInteger.valueOf(30);
        ArrayList<BigInteger> kyneaPrimes2 = new ArrayList<BigInteger>();

        KyneaPrime kyneaPrime2 = KyneaPrime.getInstance();
        kyneaPrimes = kyneaPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(23);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, kyneaPrimes);
    }
}