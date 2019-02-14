public class PqPQTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(100000);
        BigInteger to = BigInteger.valueOf(335120);
        ArrayList<BigInteger> pqPQs = new ArrayList<BigInteger>();

        PqPQ pqPQ = PqPQ.getInstance();
        pqPQs = pqPQ.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(102061);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(160201);
        resultArray.add(resultBi);
        BigInteger resultBi = BigInteger.valueOf(335113);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(311533);
        resultArray.add(resultBi);



        assertEquals(resultArray, pqPQs);

    }
}
