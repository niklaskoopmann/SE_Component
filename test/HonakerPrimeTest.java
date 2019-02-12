class HonakerPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(125);
        BigInteger to = BigInteger.valueOf(140);
        ArrayList<BigInteger> honakerPrimes = new ArrayList<BigInteger>();

        HonakerPrime honakerPrime = HonakerPrime.getInstance();
        honakerPrimes = honakerPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(131);
        resultArray.add(resultBi);
        assertEquals(resultArray, honakerPrimes);


        BigInteger from2 = BigInteger.valueOf(1085);
        BigInteger to2 = BigInteger.valueOf(1100);
        ArrayList<BigInteger> honakerPrimes2 = new ArrayList<BigInteger>();

        HonakerPrime honakerPrime2 = HonakerPrime.getInstance();
        honakerPrimes = honakerPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(1091);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, honakerPrimes);
    }
}