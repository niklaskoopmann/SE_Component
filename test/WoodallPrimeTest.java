class WoodallPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(0);
        BigInteger to = BigInteger.valueOf(2);
        ArrayList<BigInteger> woodallPrimes = new ArrayList<BigInteger>();

        WoodallPrime woodallPrime = WoodallPrime.getInstance();
        woodallPrimes = woodallPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(1);
        resultArray.add(resultBi);
        assertEquals(resultArray, woodallPrimes);


        BigInteger from2 = BigInteger.valueOf(6);
        BigInteger to2 = BigInteger.valueOf(9);
        ArrayList<BigInteger> woodallPrimes2 = new ArrayList<BigInteger>();

        WoodallPrime woodallPrime2 = WoodallPrime.getInstance();
        woodallPrimes = woodallPrime2.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(7);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, woodallPrimes);
    }
}