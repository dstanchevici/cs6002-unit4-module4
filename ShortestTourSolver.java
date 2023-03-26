
public class ShortestTourSolver {

    // Number of points:
    static int n = 8;

    // Their x,y coordinates. The i-th point's coordinates are x[i],y[i]
    static double[] x = {1, 2, 8, 7, 4, 3, 2, 9};
    static double[] y = {1, 6, 1, 3, 3, 5, 9, 4};

    static int[] tour = new int [8];

    // We'll record the best tour here, and the best length.
    static double bestLength;
    static int[] bestTour;

    static int numEvaluated = 0;


    public static void main (String[] argv)
    {
	DrawTool.setXYRange (0,10, 0,10);
	DrawTool.display ();

	// Display the points:
	DrawTool.setCircleColor ("red");
	for (int i=0; i<n; i++) {
	    DrawTool.drawCircle (x[i], y[i], 0.3);
	    DrawTool.drawSmallLabel (x[i],y[i], ""+i);
	}

	findTour ();

	// Draw the tour:
	DrawTool.setLineColor ("blue");
	double tourLength = 0;
	for (int i=0; i<n-1; i++) {
	    DrawTool.drawLine (x[tour[i]], y[tour[i]], x[tour[i+1]], y[tour[i+1]]);
	    tourLength += distance (x[tour[i]], y[tour[i]], x[tour[i+1]], y[tour[i+1]]);
	}
	tourLength += distance (x[tour[n-1]], y[tour[n-1]], x[tour[0]],y[tour[0]]);
	DrawTool.drawLine (x[tour[n-1]], y[tour[n-1]], x[tour[0]],y[tour[0]]);
	DrawTool.writeTopString ("Tour length: " + tourLength);

	System.out.println ("Num of tours evaluated=" + numEvaluated);
    }


    static void findTour ()
    {
	// We'll start with the default tour: in order of 0,1,2,...
	for (int i=0; i<n; i++) {
	    tour[i] = i;
	}
	bestTour = tour;
	bestLength = evaluateTour (bestTour);

	int[] tempTour = new int [n];
	for (int i=0; i<n; i++) {
	    tempTour[i] = -1;         // Use -1 to indicate a blank spot.
	}

	// This is what solves the problem:
	recursiveFindTour (tempTour, 0);

	// Record the best tour and draw.
	tour = bestTour;
	bestLength = evaluateTour (bestTour);

	System.out.println ("Best Tour found:");
	printTour (bestTour, bestLength);
    }


    static void recursiveFindTour (int[] tempTour, int k)
    {
	// Bottom out of recursion:
	if (k == n-1) {
	    // There's only one spot left.
	    for (int i=0; i<n; i++) {
		if (tempTour[i] == -1) {
		    tempTour[i] = k;
		    double length = evaluateTour (tempTour);
		    if (length < bestLength) {
			bestLength = length;
			bestTour = copy (tempTour);
			//printTour (bestTour, bestLength);
		    }
		    tempTour[i] = -1;
		    return;
		}
	    }
	}

	// Otherwise, assign k, recurse with k+1
	for (int i=0; i<n; i++) {
	    if (tempTour[i] == -1) {
		// Try this spot.
		tempTour[i] = k;
		recursiveFindTour (tempTour, k+1);
		// Reset.
		tempTour[i] = -1;
	    }
	}
    }


    static double evaluateTour (int[] tour)
    {
	numEvaluated++;
	
	double len = 0;
	for (int i=0; i<n-1; i++) {
	    if ((tour[i]==-1) || (tour[i+1]==-1)) {
		System.out.println ("ERROR");
		printTour (tour, -1);
	    }
	    len += distance (x[tour[i]], y[tour[i]], x[tour[i+1]], y[tour[i+1]]);
	}
	len += distance (x[tour[0]], y[tour[0]], x[tour[n-1]], y[tour[n-1]]);
	return len;
    }


    static double distance (double x1, double y1, double x2, double y2)
    {
	return Math.sqrt ((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }


    static void printTour (int[] tour, double length)
    {
	System.out.print ("Length=" + length + ": ");
	for (int i=0; i<n; i++) {
	    System.out.print (" " + tour[i]);
	}
	System.out.println ();
    }

    static int[] copy (int[] tour) 
    {
	int[] A = new int [tour.length];
	for (int i=0; i<tour.length; i++) {
	    A[i] = tour[i];
	}
	return A;
    }

}
