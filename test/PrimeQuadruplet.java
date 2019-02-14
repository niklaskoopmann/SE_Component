class PrimeQuadruplet {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(10);
        BigInteger to = BigInteger.valueOf(20);
        ArrayList<BigInteger> primeQuadruplets = new ArrayList<BigInteger>();

        PrimeQuadruplet primeQuadruplet = PrimeQuadruplet.getInstance();
        primeQuadruplets = primeQuadruplet.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(11);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(13);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(17);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(19);
        resultArray.add(resultBi);
        assertEquals(resultArray, primeQuadruplets);

    }
}