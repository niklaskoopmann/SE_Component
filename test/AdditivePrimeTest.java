    class AdditivePrimeTest {
        @Test
        void execute() {

            BigInteger from = BigInteger.valueOf(110);
            BigInteger to = BigInteger.valueOf(120);
            ArrayList<BigInteger> additivePrimes = new ArrayList<BigInteger>();

            AdditivePrime additivePrime = AdditivePrime.getInstance();
            additivePrimes = additivePrime.port.execute(from, to);
            ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
            BigInteger resultBi = BigInteger.valueOf(113);
            resultArray.add(resultBi);
            assertEquals(resultArray, additivePrimes);


            BigInteger from2 = BigInteger.valueOf(110);
            BigInteger to2 = BigInteger.valueOf(120);
            ArrayList<BigInteger> additivePrimes2 = new ArrayList<BigInteger>();

            AdditivePrime additivePrime2 = AdditivePrime.getInstance();
            additivePrimes = additivePrime.port.execute(from2, to2);

            ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
            BigInteger resultBi2 = BigInteger.valueOf(113);
            resultArray2.add(resultBi2);
            assertEquals(resultArray2, additivePrimes);
        }
    }

