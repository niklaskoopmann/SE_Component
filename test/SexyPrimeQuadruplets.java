public class SexyPrimeQuadrupletsTest {

    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(1600);
        BigInteger to = BigInteger.valueOf(1620);
        ArrayList<BigInteger> sexyPrimeQuadruplets = new ArrayList<BigInteger>();

        SexyPrimeQuadruplet sexyPrimeQuadruplet = SexyPrimeQuadruplet.getInstance();
        sexyPrimeQuadruplets = sexyPrimeQuadruplet.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(1601);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(1607);
        resultArray.add(resultBi);
        BigInteger resultBi = BigInteger.valueOf(1613);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(1619);
        resultArray.add(resultBi);

        assertEquals(resultArray, sexyPrimeQuadruplets);

    }

}
