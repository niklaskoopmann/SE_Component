public class RoleReversalTest {

    @Test
    void execute () {

        BigInteger from = BigInteger.valueOf(35);
        BigInteger to = BigInteger.valueOf(75);
        ArrayList<BigInteger> roleReversals = new ArrayList<BigInteger>();

        RoleReversal roleReversal = RoleReversal.getInstance();
        roleReversals = roleReversal.port.execute(from, to);
        ArrayList<BigInteger> resultArray = new ArrayList<BigInteger>();
        BigInteger resultBi = BigInteger.valueOf(37);
        resultArray.add(resultBi);
        resultBi = BigInteger.valueOf(73);
        resultArray.add(resultBi);

        assertEquals(resultArray, roleReversals);

    }

}
