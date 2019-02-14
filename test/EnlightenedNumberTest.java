class EnlightenedNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(255);
        BigInteger to = BigInteger.valueOf(260);
        ArrayList<BigInteger> enlightenedNumbers = new ArrayList<BigInteger>();

        EnlightenedNumber enlightenedNumber = EnlightenedNumber.getInstance();
        enlightenedNumbers = enlightenedNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(256);
        resultArray.add(resultBi);
        assertEquals(resultArray, enlightenedNumbers);


        BigInteger from2 = BigInteger.valueOf(2300);
        BigInteger to2 = BigInteger.valueOf(2310);
        ArrayList<BigInteger> enlightenedNumbers2 = new ArrayList<BigInteger>();

        EnlightenedNumber enlightenedNumber2 = EnlightenedNumber.getInstance();
        enlightenedNumbers = enlightenedNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(2304);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, enlightenedNumbers);
    }
}