import java.util.*;

public class ListComparison {

    static LinkedList<Integer> listA = new LinkedList<> ();
    static ArrayList<Integer> listB = new ArrayList<> ();

    // Try N=10000, 20000, ..., 1000000
    static int N = 200_000;

    public static void main (String[] argv)
    {
	makeRandomData ();

	double arrayAvg=0, linkedAvg=0;
	for (int i=0; i<5; i++) {
	    // First, the linked list.
	    long startTime = System.currentTimeMillis ();
	    testLinkedListGet ();
	    long endTime = System.currentTimeMillis ();
	    System.out.println ("LinkedList:  time taken: " + (endTime-startTime));
	    linkedAvg += ( (endTime-startTime) / 5.0 ); 

	    // Second, the array list.
	    startTime = System.currentTimeMillis ();
	    testArrayListGet ();
	    endTime = System.currentTimeMillis ();
	    System.out.println ("ArrayList:  time taken: " + (endTime-startTime));
	    arrayAvg += ( (endTime-startTime) / 5.0 ); 
	}
	System.out.println ("N=" + N);
	System.out.println ("LinkiedList avg=" + linkedAvg);
	System.out.println ("ArrayList avg=" + arrayAvg);
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
