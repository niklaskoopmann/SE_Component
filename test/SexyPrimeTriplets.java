public class SexyPrimeTriplets {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(555);
        BigInteger to = BigInteger.valueOf(570);
        ArrayList<BigInteger> sexyPrimeTriplets = new ArrayList<BigInteger>();

        SexyPrimeTriplets sexyPrimeTriplets = SexyPrimeTriplets.getInstance();
        sexyPrimeTriplets = sexyPrimeTriplet.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(557);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(563);
        resultArray.add(resultBi);
        BigInteger resultBi = BigInteger.valueOf(569);
        resultArray.add(resultBi);


        assertEquals(resultArray, sexyPrimeTriplets);

    }
}
