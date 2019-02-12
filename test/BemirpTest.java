class BemirpTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(1050);
        BigInteger to = BigInteger.valueOf(1070);
        ArrayList<BigInteger> bemirps = new ArrayList<BigInteger>();

        Bemirp bemirp = Bemirp.getInstance();
        bemirps = bemirp.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(1061);
        resultArray.add(resultBi);
        assertEquals(resultArray, bemirps);


        BigInteger from2 = BigInteger.valueOf(1900);
        BigInteger to2 = BigInteger.valueOf(1910);
        ArrayList<BigInteger> bemirps2 = new ArrayList<BigInteger>();

        Bemirp bemirp2 = Bemirp.getInstance();
        bemirps = bemirp.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(1901);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, bemirps);
    }
}