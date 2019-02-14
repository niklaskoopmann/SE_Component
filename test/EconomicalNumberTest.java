class EconomicalNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(4);
        BigInteger to = BigInteger.valueOf(6);
        ArrayList<BigInteger> economicalNumbers = new ArrayList<BigInteger>();

        EconomicalNumber economicalNumber = EconomicalNumber.getInstance();
        economicalNumbers = economicalNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(5);
        resultArray.add(resultBi);
        assertEquals(resultArray, economicalNumbers);


        BigInteger from2 = BigInteger.valueOf(6);
        BigInteger to2 = BigInteger.valueOf(9);
        ArrayList<BigInteger> economicalNumbers2 = new ArrayList<BigInteger>();

        EconomicalNumber economicalNumber2 = EconomicalNumber.getInstance();
        economicalNumbers = economicalNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(7);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, economicalNumbers);
    }
}