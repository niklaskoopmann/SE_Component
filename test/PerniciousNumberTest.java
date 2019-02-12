class PerniciousNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(4);
        BigInteger to = BigInteger.valueOf(6);
        ArrayList<BigInteger> perniciousNumbers = new ArrayList<BigInteger>();

        PerniciousNumber perniciousNumber = PerniciousNumber.getInstance();
        perniciousNumbers = perniciousNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(5);
        resultArray.add(resultBi);
        assertEquals(resultArray, perniciousNumbers);


        BigInteger from2 = BigInteger.valueOf(8);
        BigInteger to2 = BigInteger.valueOf(10);
        ArrayList<BigInteger> perniciousNumbers2 = new ArrayList<BigInteger>();

        PerniciousNumber perniciousNumber2 = PerniciousNumber.getInstance();
        perniciousNumbers = perniciousNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(9);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, perniciousNumbers);
    }
}