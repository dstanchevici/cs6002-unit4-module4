
public class ComparisonPlot {

    public static void main (String[] argv)
    {
	DrawTool.setXYRange (0,1000, 0,1000);
	DrawTool.display ();

	double p = 1;
	double q = 50;

	for (int n=100; n<=1000; n+=100) {
	    DrawTool.setPointColor ("red");
	    DrawTool.drawPoint (n, p*n);               // f(n) = p * n
	    DrawTool.setPointColor ("blue");
	    double m = Math.log10(n) / Math.log10(2);  // This is log-base-2 of n.
	    DrawTool.drawPoint (n, q*m);               // g(n) = q * log_2(n)
	    System.out.println ("n=" + n + " m=" + m);
	}
    }

    static int numberOfDividesNeeded (int n)
    {
	// Write your code here. Repeatedly divide until
	// you get below 1.

	int m = 0;
	while (n > 1) {
	    n /= 2;
	    m++;
	}
	return m;

    }

}
