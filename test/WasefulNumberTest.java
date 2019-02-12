class WasefulNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(10);
        BigInteger to = BigInteger.valueOf(15);
        ArrayList<BigInteger> wasefulNumbers = new ArrayList<BigInteger>();

        WasefulNumber wasefulNumber = WasefulNumber.getInstance();
        wasefulNumbers = wasefulNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(12);
        resultArray.add(resultBi);
        assertEquals(resultArray, wasefulNumbers);


        BigInteger from2 = BigInteger.valueOf(29);
        BigInteger to2 = BigInteger.valueOf(31);
        ArrayList<BigInteger> wasefulNumbers2 = new ArrayList<BigInteger>();

        WasefulNumber wasefulNumber2 = WasefulNumber.getInstance();
        wasefulNumbers = wasefulNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(30);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, wasefulNumbers);
    }