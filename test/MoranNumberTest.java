class MoranNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(15);
        BigInteger to = BigInteger.valueOf(20);
        ArrayList<BigInteger> moranNumbers = new ArrayList<BigInteger>();

        MoranNumber moranNumber = MoranNumber.getInstance();
        moranNumbers = moranNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(18);
        resultArray.add(resultBi);
        assertEquals(resultArray, moranNumbers);


        BigInteger from2 = BigInteger.valueOf(110);
        BigInteger to2 = BigInteger.valueOf(113);
        ArrayList<BigInteger> moranNumbers2 = new ArrayList<BigInteger>();

        MoranNumber moranNumber2 = MoranNumber.getInstance();
        moranNumbers = moranNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(111);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, moranNumbers);
    }
}