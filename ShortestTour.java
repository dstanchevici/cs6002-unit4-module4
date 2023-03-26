
public class ShortestTour {

    // Number of points:
    static int n = 8;

    // Their x,y coordinates. The i-th point's coordinates are x[i],y[i]
    static double[] x = {1, 2, 8, 7, 4, 3, 2, 9};
    static double[] y = {1, 6, 1, 3, 3, 5, 9, 4};

    // We'll record a tour here. tour[j] = the index of the j-th point
    // in order. So tour[0] is the first point, tour[1] is the second etc.
    static int[] tour = new int [8];


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

	makeTour ();

	// Draw the tour:
	DrawTool.setLineColor ("blue");
	double tourLength = 0;
	for (int i=0; i<n-1; i++) {
	    DrawTool.drawLine (x[tour[i]], y[tour[i]], x[tour[i+1]], y[tour[i+1]]);
	    tourLength += distance (x[tour[i]], y[tour[i]], x[tour[i+1]], y[tour[i+1]]);
	}
	DrawTool.drawLine (x[tour[n-1]], y[tour[n-1]], x[tour[0]],y[tour[0]]);
	tourLength += distance (x[tour[n-1]], y[tour[n-1]], x[tour[0]],y[tour[0]]);

	DrawTool.writeTopString ("Tour length: " + tourLength);
	System.out.println ("Tour length: " + tourLength);
    }


    static void makeTour ()
    {
	// We'll make the first stop point #0 always:
	tour[0] = 0;

	// The others. The order: 0, 2, 1, 4, 6, 7, 5, 3
	tour[1] = 2;
	tour[2] = 3;
	tour[3] = 7;
	tour[4] = 6;
	tour[5] = 1;
	tour[6] = 5;
	tour[7] = 4;
    }


    static double distance (double x1, double y1, double x2, double y2)
    {
	return Math.sqrt ((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

}
