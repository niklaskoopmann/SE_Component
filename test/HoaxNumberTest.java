class HoaxNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(21);
        BigInteger to = BigInteger.valueOf(23);
        ArrayList<BigInteger> hoaxNumbers = new ArrayList<BigInteger>();

        HoaxNumber hoaxNumber = HoaxNumber.getInstance();
        hoaxNumbers = hoaxNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(22);
        resultArray.add(resultBi);
        assertEquals(resultArray, hoaxNumbers);


        BigInteger from2 = BigInteger.valueOf(93);
        BigInteger to2 = BigInteger.valueOf(95);
        ArrayList<BigInteger> hoaxNumbers2 = new ArrayList<BigInteger>();

        HoaxNumber hoaxNumber2 = HoaxNumber.getInstance();
        hoaxNumbers = hoaxNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(94);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, hoaxNumbers);
    }
}