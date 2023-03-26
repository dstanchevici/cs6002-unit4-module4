
public class Quadratic {

    public static void main (String[] argv)
    {
	DrawTool.setXYRange (0,1000, 0,1000000);
	DrawTool.display ();

	double p = 1;
	double q = 100;

	for (int n=100; n<=1000; n+=100) {
	    // Quadratic:
	    DrawTool.setPointColor ("red");
	    double fn = n * n;                    // <<==  WRITE YOUR CODE HERE
	    DrawTool.drawPoint (n, fn);             

	    // Linear:
	    DrawTool.setPointColor ("blue");
	    double gn = q * n;
	    DrawTool.drawPoint (n, gn);
	}
    }


}
