class Class1PlusPrimeTest{
@Test
 void execute(){

         BigInteger from=BigInteger.valueOf(15);
         BigInteger to=BigInteger.valueOf(20);
         ArrayList<BigInteger> class1PlusPrimes=new ArrayList<BigInteger>();

        Class1PlusPrime class1PlusPrime=Class1PlusPrime.getInstance();
        class1PlusPrimes=class1PlusPrime.port.execute(from,to);
        ArrayList<BigInteger> resultArray=new ArrayList<BigInteger>();
        BigInteger resultBi=BigInteger.valueOf(17);
        resultArray.add(resultBi);
        assertEquals(resultArray,class1PlusPrimes);


        BigInteger from2=BigInteger.valueOf(35);
        BigInteger to2=BigInteger.valueOf(50);
        ArrayList<BigInteger> class1+Primes2=new ArrayList<BigInteger>();

        Class1+Prime class1+Prime2=Class1+Prime.getInstance();
        class1+Primes=class1+Prime.port.execute(from2,to2);

        ArrayList<BigInteger> resultArray2=new ArrayList<BigInteger>();
        BigInteger resultBi2=BigInteger.valueOf(47);
        resultArray2.add(resultBi2);
        assertEquals(resultArray2,class1+Primes);
   }
}