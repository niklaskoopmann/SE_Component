class DihedralPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(95);
        BigInteger to = BigInteger.valueOf(110);
        ArrayList<BigInteger> dihedralPrimes = new ArrayList<BigInteger>();

        DihedralPrime dihedralPrime = DihedralPrime.getInstance();
        dihedralPrimes = dihedralPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(101);
        resultArray.add(resultBi);
        assertEquals(resultArray, dihedralPrimes);


        BigInteger from2 = BigInteger.valueOf(180);
        BigInteger to2 = BigInteger.valueOf(200);
        ArrayList<BigInteger> dihedralPrimes2 = new ArrayList<BigInteger>();

        DihedralPrime dihedralPrime2 = DihedralPrime.getInstance();
        dihedralPrimes = dihedralPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(181);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, dihedralPrimes);
    }
}