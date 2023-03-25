
public class RepeatedDividePlot {

    public static void main (String[] argv)
    {
	DrawTool.setXYRange (0,1000, 0,1000);
	DrawTool.display ();

	for (int n=100; n<=1000; n+=100) {
	    DrawTool.setPointColor ("red");
	    DrawTool.drawPoint (n, n);         // This plots f(n)=n
	    int m = numberOfDividesNeeded (n);
	    DrawTool.setPointColor ("blue");
	    DrawTool.drawPoint (n, m);         // This plots g(n)
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
