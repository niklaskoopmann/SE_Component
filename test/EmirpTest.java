class EmirpTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(15);
        BigInteger to = BigInteger.valueOf(20);
        ArrayList<BigInteger> emirps = new ArrayList<BigInteger>();

        Emirp emirp = Emirp.getInstance();
        emirps = emirp.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(17);
        resultArray.add(resultBi);
        assertEquals(resultArray, emirps);


        BigInteger from2 = BigInteger.valueOf(30);
        BigInteger to2 = BigInteger.valueOf(34);
        ArrayList<BigInteger> emirps2 = new ArrayList<BigInteger>();

        Emirp emirp2 = Emirp.getInstance();
        emirps = emirp.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(31);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, emirps);
    }
}