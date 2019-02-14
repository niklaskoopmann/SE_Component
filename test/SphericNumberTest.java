class SphericNumberTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(29);
        BigInteger to = BigInteger.valueOf(35);
        ArrayList<BigInteger> sphericNumbers = new ArrayList<BigInteger>();

        SphericNumber sphericNumber = SphericNumber.getInstance();
        sphericNumbers = sphericNumber.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(30);
        resultArray.add(resultBi);
        assertEquals(resultArray, sphericNumbers);


        BigInteger from2 = BigInteger.valueOf(40);
        BigInteger to2 = BigInteger.valueOf(50);
        ArrayList<BigInteger> sphericNumbers2 = new ArrayList<BigInteger>();

        SphericNumber sphericNumber2 = SphericNumber.getInstance();
        sphericNumbers = sphericNumber.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(42);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, sphericNumbers);
    }
}