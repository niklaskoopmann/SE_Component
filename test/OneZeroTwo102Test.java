class OneZeroTwo102Test {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(100);
        BigInteger to = BigInteger.valueOf(110);
        ArrayList<BigInteger> oneZeroTwo102s = new ArrayList<BigInteger>();

        OneZeroTwo102 oneZeroTwo102 = OneZeroTwo102.getInstance();
        oneZeroTwo102s = oneZeroTwo102.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(102);
        resultArray.add(resultBi);
        assertEquals(resultArray, oneZeroTwo102s);

    }
}