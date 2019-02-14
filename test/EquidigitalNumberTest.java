class EquidigitalNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(26);
        BigInteger to = BigInteger.valueOf(28);
        ArrayList<BigInteger> equidigitalNumbers = new ArrayList<BigInteger>();

        EquidigitalNumber equidigitalNumber = EquidigitalNumber.getInstance();
        equidigitalNumbers = equidigitalNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(27);
        resultArray.add(resultBi);
        assertEquals(resultArray, equidigitalNumbers);


        BigInteger from2 = BigInteger.valueOf(34);
        BigInteger to2 = BigInteger.valueOf(36);
        ArrayList<BigInteger> equidigitalNumbers2 = new ArrayList<BigInteger>();

        EquidigitalNumber equidigitalNumber2 = EquidigitalNumber.getInstance();
        equidigitalNumbers = equidigitalNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(35);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, equidigitalNumbers);
    }
}