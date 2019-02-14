class M-pointerPrimeTest {
@Test
 void execute () {

         BigInteger from = BigInteger.valueOf(0);
         BigInteger to = BigInteger.valueOf(30);
         ArrayList<BigInteger> m_pointerPrimes = new ArrayList<BigInteger>();

        M_pointerPrime m_pointerPrime = M_pointerPrime.getInstance();
        m_pointerPrimes = m_pointerPrime.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(23);
        resultArray.add(resultBi);
        assertEquals(resultArray, m-pointerPrimes);


        BigInteger from2 = BigInteger.valueOf(40);
        BigInteger to2 = BigInteger.valueOf(100);
        ArrayList<BigInteger> m_pointerPrimes2 = new ArrayList<BigInteger>();

        M_pointerPrime m_pointerPrime2 = M_pointerPrime.getInstance();
        m_pointerPrimes = m_pointerPrime.port.execute(from2, to2);

        ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
        BigInteger resultBi2 = BigInteger.valueOf(61);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2, m_pointerPrimes);
    }
}