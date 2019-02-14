class PrimeQuintupletII {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(0);
        BigInteger to = BigInteger.valueOf(20);
        ArrayList<BigInteger> primeQuintupletIIs = new ArrayList<BigInteger>();

        PrimeQuintupletII primeQuintupletII = PrimeQuintupletII.getInstance();
        primeQuintupletIIs = primeQuintupletII.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(5);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(7);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(11);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(13);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(17);
        resultArray.add(resultBi);
        assertEquals(resultArray, primeQuintupletIIs);

    }
}