public class CousinPrimeTest {

    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(165);
        BigInteger to = BigInteger.valueOf(175);
        ArrayList<BigInteger> cousinPrimes = new ArrayList<BigInteger>();

        CousinPrime cousinPrime = CousinPrime.getInstance();
        cousinPrimes = cousinPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(170);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(171);
        resultArray.add(resultBi);


        assertEquals(resultArray, cousinPrimes);

    }
}
