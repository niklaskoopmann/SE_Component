class SemiprimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(3);
        BigInteger to = BigInteger.valueOf(5);
        ArrayList<BigInteger> semiprimes = new ArrayList<BigInteger>();

        Semiprime semiprime = Semiprime.getInstance();
        semiprimes = semiprime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(4);
        resultArray.add(resultBi);
        assertEquals(resultArray, semiprimes);


        BigInteger from2 = BigInteger.valueOf(5);
        BigInteger to2 = BigInteger.valueOf(7);
        ArrayList<BigInteger> semiprimes2 = new ArrayList<BigInteger>();

        Semiprime semiprime2 = Semiprime.getInstance();
        semiprimes = semiprime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(6);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, semiprimes);
    }
}