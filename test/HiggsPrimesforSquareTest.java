class HiggsPrimesforSquareTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(40);
        BigInteger to = BigInteger.valueOf(45);
        ArrayList<BigInteger> higgsPrimesforSquares = new ArrayList<BigInteger>();

        HiggsPrimesforSquare higgsPrimesforSquare = HiggsPrimesforSquare.getInstance();
        higgsPrimesforSquares = higgsPrimesforSquare.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(47);
        resultArray.add(resultBi);
        assertEquals(resultArray, higgsPrimesforSquares);


        BigInteger from2 = BigInteger.valueOf(50);
        BigInteger to2 = BigInteger.valueOf(55);
        ArrayList<BigInteger> higgsPrimesforSquares2 = new ArrayList<BigInteger>();

        HiggsPrimesforSquare higgsPrimesforSquare2 = HiggsPrimesforSquare.getInstance();
        higgsPrimesforSquares = higgsPrimesforSquare.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(53);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, higgsPrimesforSquares);
    }
}