class MagnanimousNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(24);
        BigInteger to = BigInteger.valueOf(27);
        ArrayList<BigInteger> magnanimousNumbers = new ArrayList<BigInteger>();

        MagnanimousNumber magnanimousNumber = MagnanimousNumber.getInstance();
        magnanimousNumbers = magnanimousNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(25);
        resultArray.add(resultBi);
        assertEquals(resultArray, magnanimousNumbers);


        BigInteger from2 = BigInteger.valueOf(33);
        BigInteger to2 = BigInteger.valueOf(36);
        ArrayList<BigInteger> magnanimousNumbers2 = new ArrayList<BigInteger>();

        MagnanimousNumber magnanimousNumber2 = MagnanimousNumber.getInstance();
        magnanimousNumbers = magnanimousNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(34);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, magnanimousNumbers);
    }
}