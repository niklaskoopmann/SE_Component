class SmithNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(0);
        BigInteger to = BigInteger.valueOf(5);
        ArrayList<BigInteger> smithNumbers = new ArrayList<BigInteger>();

        SmithNumber smithNumber = SmithNumber.getInstance();
        smithNumbers = smithNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(4);
        resultArray.add(resultBi);
        assertEquals(resultArray, smithNumbers);


        BigInteger from2 = BigInteger.valueOf(20);
        BigInteger to2 = BigInteger.valueOf(25);
        ArrayList<BigInteger> smithNumbers2 = new ArrayList<BigInteger>();

        SmithNumber smithNumber2 = SmithNumber.getInstance();
        smithNumbers = smithNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(22);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, smithNumbers);
    }
}