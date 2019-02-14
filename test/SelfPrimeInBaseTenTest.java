class SelfPrimeInBaseTenTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(20);
        BigInteger to = BigInteger.valueOf(32);
        ArrayList<BigInteger> selfPrimeInBaseTens = new ArrayList<BigInteger>();

        SelfPrimeInBaseTen selfPrimeInBaseTen = SelfPrimeInBaseTen.getInstance();
        selfPrimeInBaseTens = selfPrimeInBaseTen.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(31);
        resultArray.add(resultBi);
        assertEquals(resultArray, selfPrimeInBaseTens);


        BigInteger from2 = BigInteger.valueOf(6);
        BigInteger to2 = BigInteger.valueOf(8);
        ArrayList<BigInteger> selfPrimeInBaseTens2 = new ArrayList<BigInteger>();

        SelfPrimeInBaseTen selfPrimeInBaseTen2 = SelfPrimeInBaseTen.getInstance();
        selfPrimeInBaseTens = selfPrimeInBaseTen.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(7);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, selfPrimeInBaseTens);
    }
}