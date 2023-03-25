
public class RepeatedDivide {

    public static void main (String[] argv)
    {
	int n = 1024;
	System.out.println ("n=" + n);

	int m = numberOfDividesNeeded (n);
	System.out.println ("m=" + m);             // Should get 10 for n=1024

	double L = Math.log10(n) / Math.log10(2);
	System.out.println ("log2(n) = " + L);     // log of n to the base 2
    }

    static int numberOfDividesNeeded (int n)
    {
	// Write your code here. Repeatedly divide until
	// you get below 1. Count the number of divides needed.

	int m = 0;
	while (n > 1) {
	    n /= 2;
	    m++;
	}
	return m;
    }

}
