class SolinasPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(2);
        BigInteger to = BigInteger.valueOf(4);
        ArrayList<BigInteger> solinasPrimes = new ArrayList<BigInteger>();

        SolinasPrime solinasPrime = SolinasPrime.getInstance();
        solinasPrimes = solinasPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(3);
        resultArray.add(resultBi);
        assertEquals(resultArray, solinasPrimes);


        BigInteger from2 = BigInteger.valueOf(4);
        BigInteger to2 = BigInteger.valueOf(6);
        ArrayList<BigInteger> solinasPrimes2 = new ArrayList<BigInteger>();

        SolinasPrime solinasPrime2 = SolinasPrime.getInstance();
        solinasPrimes = solinasPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(5);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, solinasPrimes);
    }
}