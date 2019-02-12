class DrollNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(70);
        BigInteger to = BigInteger.valueOf(75);
        ArrayList<BigInteger> drollNumbers = new ArrayList<BigInteger>();

        DrollNumber drollNumber = DrollNumber.getInstance();
        drollNumbers = drollNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(72);
        resultArray.add(resultBi);
        assertEquals(resultArray, drollNumbers);


        BigInteger from2 = BigInteger.valueOf(200);
        BigInteger to2 = BigInteger.valueOf(250);
        ArrayList<BigInteger> drollNumbers2 = new ArrayList<BigInteger>();

        DrollNumber drollNumber2 = DrollNumber.getInstance();
        drollNumbers = drollNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(240);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, drollNumbers);
    }
}