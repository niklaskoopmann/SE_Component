class PrimeSextupletTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(5);
        BigInteger to = BigInteger.valueOf(25);
        ArrayList<BigInteger> primeSextuplets = new ArrayList<BigInteger>();

        PrimeSextuplet primeSextuplet = PrimeSextuplet.getInstance();
        primeSextuplets = primeSextuplet.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(7);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(11);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(13);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(17);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(19);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(23);
        resultArray.add(resultBi);
        assertEquals(resultArray, primeSextuplets);

    }
}