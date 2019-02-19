public class PrimeTripletTest {

    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(345);
        BigInteger to = BigInteger.valueOf(355);
        ArrayList<BigInteger> primeTriplets = new ArrayList<BigInteger>();

        PrimeTriplet primeTriplet = PrimeTriplet.getInstance();
        primeTriplets = primeTriplet.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(347);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(349);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(353);
        resultArray.add(resultBi);

        assertEquals(resultArray, primeTriplets);

    }

}
