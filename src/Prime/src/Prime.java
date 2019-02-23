

import com.sun.source.tree.WhileLoopTree;

import java.math.BigInteger;
import java.util.ArrayList;


    class Test {


        // Returns true if n is a Smith number, else false.

        static BigInteger sumDigit(BigInteger n) {
            BigInteger s = new BigInteger("0");
            BigInteger t;
            while (n.compareTo(BigInteger.ZERO) > 0) {
                if (n.compareTo(BigInteger.TEN) >0) {
                    t = n.mod(BigInteger.valueOf(10));
                    s = s.add(t);
                    n = n.divide(BigInteger.valueOf(10));
                }
                else{ s =s.add(n);
                n = n.divide(BigInteger.valueOf(10));
            }}
            return s;
        }

        static BigInteger sumPrimeFact(BigInteger n) {
            BigInteger i =new BigInteger("2");
            BigInteger sum = new BigInteger("0");
            while (n.compareTo(BigInteger.ONE)>0){
                if (n.mod(i).compareTo(BigInteger.ZERO) == 0) {
                    sum = sum.add(sumDigit(i));
                    n = n.divide(i);
                } else {
                    i = i.add(BigInteger.valueOf(1));
                }
            }
            return sum;
        }


        static void send(BigInteger i) {
            ArrayList<BigInteger> arrayList = new ArrayList<>();

            for (BigInteger bi = i; bi.compareTo(BigInteger.valueOf(200)) < 0; bi = bi.add(BigInteger.ONE)) {
                if (returnPrime(bi) == false) {
                    if (sumDigit(bi).equals(sumPrimeFact(bi))) {
                    arrayList.add(bi);}
                }

        }}

        static boolean returnPrime(BigInteger number) {
            //check via BigInteger.isProbablePrime(certainty)
            if (!number.isProbablePrime(5))
                return false;

            //check if even
            BigInteger two = new BigInteger("2");
            if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
                return false;

            //find divisor if any from 3 to 'number'
            for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) { //start from 3, 5, etc. the odd number, and look for a divisor if any
                if (BigInteger.ZERO.equals(number.mod(i))) //check if 'i' is divisor of 'number'
                    return false;
            }
            return true;
        }

        // Driver method
        public static void main(String[] args) {
            // Finding all prime numbers before limit. These
            // numbers are used to find prime factors.
            BigInteger i = new BigInteger("2");
            for (BigInteger bi = i; bi.compareTo(BigInteger.valueOf(200)) < 0; bi = bi.add(BigInteger.ONE)) {
                if (returnPrime(bi) == false) {
                    if (sumDigit(bi).equals(sumPrimeFact(bi))) {
                        System.out.println(bi);
                    }
                }
            }
        }
    }

