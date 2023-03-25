import java.util.*;

public class ArraySearchComparison {

    static int k;        // An integer to search with.
    static int[] A;      // The array in which to search for k.

    public static void main (String[] argv)
    {
	// Try N=100, 1000, 100000, 100_000_000
	int N = 100_000_000;
	makeRandomData (N);

	// First, a straightforward linear search.
	long startTime = System.currentTimeMillis ();
	boolean found = plainSearch (A, k);
	long endTime = System.currentTimeMillis ();
	System.out.println ("Found=" + found + "  Time taken: " + (endTime-startTime));

	// Next, binary search (logarithmic)
	startTime = System.currentTimeMillis ();
	boolean found2 = binarySearch (A, k);
	endTime = System.currentTimeMillis ();
	System.out.println ("Found=" + found2 + "  Time taken: " + (endTime-startTime));
    }

    static boolean plainSearch (int[] A, int value)
    {
        // Walk through the array and look for "value"

        for (int i=0; i<A.length; i++) {
	    if ( value == A[i]) {
		return true;
	    }
	}

	return false;
    }

    static boolean binarySearch (int[] A, int value)
    {
	// Try to puzzle over what this is doing.
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (value == A[mid]) {
                return true;
            }
            else if (value < A[mid]) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return false;
    }

    static void makeRandomData (int N)
    {
	A = new int [N];
	Random rand = new Random ();
	for (int i=1; i<N; i++) {
	    A[i] = A[i-1] + 1 + rand.nextInt (3);
	}
	k = rand.nextInt (A[A.length-1]);
    }

}
