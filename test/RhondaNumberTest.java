class RhondaNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(1500);
        BigInteger to = BigInteger.valueOf(1600);
        ArrayList<BigInteger> rhondaNumbers = new ArrayList<BigInteger>();

        RhondaNumber rhondaNumber = RhondaNumber.getInstance();
        rhondaNumbers = rhondaNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(1568);
        resultArray.add(resultBi);
        assertEquals(resultArray, rhondaNumbers);


        BigInteger from2 = BigInteger.valueOf(2800);
        BigInteger to2 = BigInteger.valueOf(2900);
        ArrayList<BigInteger> rhondaNumbers2 = new ArrayList<BigInteger>();

        RhondaNumber rhondaNumber2 = RhondaNumber.getInstance();
        rhondaNumbers = rhondaNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(2835);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, rhondaNumbers);
    }
}