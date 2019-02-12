public class ThabitPrimeOfKindTest {
    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(8);
        BigInteger to = BigInteger.valueOf(15);
        ArrayList<BigInteger> thabitPrimeOfKinds = new ArrayList<BigInteger>();

        ThabitPrimeOfKind thabitPrimeOfKind = ThabitPrimeOfKind.getInstance();
        thabitPrimeOfKinds = thabitPrimeOfKind.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(13);
        resultArray.add(resultBi);
        assertEquals(resultArray, thabitPrimeOfKinds);


        BigInteger from2 = BigInteger.valueOf(6);
        BigInteger to2 = BigInteger.valueOf(8);
        ArrayList<BigInteger> thabitPrimeOfKinds2 = new ArrayList<BigInteger>();

        ThabitPrimeOfKind thabitPrimeOfKind2 = ThabitPrimeOfKind.getInstance();
        thabitPrimeOfKinds = thabitPrimeOfKind.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(7);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, thabitPrimeOfKinds);
    }
}
