public class ReverseRotationAndInsertionOfZeroeTest {

    class ReverseRotationAndInsertionOfZeroeTest {
        @Test
        void execute () {

            BigInteger from = BigInteger.valueOf(5);
            BigInteger to = BigInteger.valueOf(14);
            ArrayList<BigInteger> reverseRotationAndInsertionOfZeroes = new ArrayList<BigInteger>();

            ReverseRotationAndInsertionOfZeroe reverseRotationAndInsertionOfZeroe = ReverseRotationAndInsertionOfZeroe.getInstance();
            reverseRotationAndInsertionOfZeroes = reverseRotationAndInsertionOfZeroe.port.execute(from, to);
            ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
            BigInteger resultBi = BigInteger.valueOf(10);
            resultArray.add(resultBi);
            assertEquals(resultArray, reverseRotationAndInsertionOfZeroes);


            BigInteger from2 = BigInteger.valueOf(600);
            BigInteger to2 = BigInteger.valueOf(610);
            ArrayList<BigInteger> reverseRotationAndInsertionOfZeroes2 = new ArrayList<BigInteger>();

            ReverseRotationAndInsertionOfZeroe reverseRotationAndInsertionOfZeroe2 = ReverseRotationAndInsertionOfZeroe.getInstance();
            reverseRotationAndInsertionOfZeroes = reverseRotationAndInsertionOfZeroe.port.execute(from2, to2);

            ArrayList<BigInteger> resultArray2 = new ArrayList<BigInteger>();
            BigInteger resultBi2 = BigInteger.valueOf(606);
            resultArray2.add(resultBi2);
            assertEquals(resultArray2, reverseRotationAndInsertionOfZeroes);
        }
    }
}
