class EvilNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(26);
        BigInteger to = BigInteger.valueOf(28);
        ArrayList<BigInteger> evilNumbers = new ArrayList<BigInteger>();

        EvilNumber evilNumber = EvilNumber.getInstance();
        evilNumbers = evilNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(27);
        resultArray.add(resultBi);
        assertEquals(resultArray, evilNumbers);


        BigInteger from2 = BigInteger.valueOf(19);
        BigInteger to2 = BigInteger.valueOf(22);
        ArrayList<BigInteger> evilNumbers2 = new ArrayList<BigInteger>();

        EvilNumber evilNumber2 = EvilNumber.getInstance();
        evilNumbers = evilNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(20);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, evilNumbers);
    }
}