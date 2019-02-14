public class SiamesePrimeTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(5);
        BigInteger to = BigInteger.valueOf(15);
        ArrayList<BigInteger> siamesePrime = new ArrayList<BigInteger>();

        SiamesePrime siamesePrime = SiamesePrime.getInstance();
        siamesePrime = siamesePrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(7);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(11);
        resultArray.add(resultBi);


        assertEquals(resultArray, siamesePrime);

    }
}
