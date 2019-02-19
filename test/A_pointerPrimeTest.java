    class A_pointerPrimeTest {
        @Test
        void execute () {

            BigInteger from = BigInteger.valueOf(1400);
            BigInteger to = BigInteger.valueOf(1420);
            ArrayList<BigInteger> a_pointerPrimes = new ArrayList<BigInteger>();

            A_pointerPrime a_pointerPrime = A_pointerPrime.getInstance();
            a_pointerPrimes = a_pointerPrime.port.execute(from, to);
            ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
            BigInteger resultBi = BigInteger.valueOf(1409);
            resultArray.add(resultBi);
            assertEquals(resultArray, a_pointerPrimes);


            BigInteger from2 = BigInteger.valueOf(2000);
            BigInteger to2 = BigInteger.valueOf(2020);
            ArrayList<BigInteger> a_pointerPrimes2 = new ArrayList<BigInteger>();

            A_pointerPrime a_pointerPrime2 = A_pointerPrime.getInstance();
            a_pointerPrimes = a_pointerPrime.port.execute(from2, to2);

            ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
            BigInteger resultBi2 = BigInteger.valueOf(2017);
            resultArray2.add(resultBi2);
            assertEquals(resultArray2, a_pointerPrimes);
        }
    }

