import java.util.*;

public class ListComparison {

    static LinkedList<Integer> listA = new LinkedList<> ();
    static ArrayList<Integer> listB = new ArrayList<> ();

    // Try N=10000, 20000, ..., 1000000
    static int N = 10_000;

    public static void main (String[] argv)
    {
	makeRandomData ();

	// First, the linked list.
	long startTime = System.currentTimeMillis ();
	testLinkedListGet ();
	long endTime = System.currentTimeMillis ();
	System.out.println ("LinkedList:  time taken: " + (endTime-startTime));

	// Second, the array list.
	startTime = System.currentTimeMillis ();
	testArrayListGet ();
	endTime = System.currentTimeMillis ();
	System.out.println ("ArrayList:  time taken: " + (endTime-startTime));
    }

    static void testLinkedListGet ()
    {
	for (int i=0; i<N; i++) {
	    int k = listA.get (i);
	}
    }


    static void testArrayListGet ()
    {
	for (int i=0; i<N; i++) {
	    int k = listB.get (i);
	}
    }


    static void makeRandomData ()
    {
	Random rand = new Random ();
	int prevK = 0;
	for (int i=0; i<N; i++) {
	    int k = prevK + 1 + rand.nextInt (3);
	    listA.add (k);
	    listB.add (k);
	}
    }



}
