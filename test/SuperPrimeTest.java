public class SuperPrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(7);
        BigInteger to = BigInteger.valueOf(15);
        ArrayList<BigInteger> superPrimes = new ArrayList<BigInteger>();

        SuperPrime superPrime = SuperPrime.getInstance();
        superPrimes = superPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(11);
        resultArray.add(resultBi);
        assertEquals(resultArray, superPrimes);


        BigInteger from2 = BigInteger.valueOf(4);
        BigInteger to2 = BigInteger.valueOf(6);
        ArrayList<BigInteger> superPrimes2 = new ArrayList<BigInteger>();

        SuperPrime superPrime2 = SuperPrime.getInstance();
        superPrimes = superPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(5);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, superPrimes);
    }
}
