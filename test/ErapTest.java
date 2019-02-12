public class ErapTest {

    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(165);
        BigInteger to = BigInteger.valueOf(175);
        ArrayList<BigInteger> eraps = new ArrayList<BigInteger>();

        Erap erap = Erap.getInstance();
        eraps = erap.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(170);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(171);
        resultArray.add(resultBi);


        assertEquals(resultArray, eraps);

    }

}
