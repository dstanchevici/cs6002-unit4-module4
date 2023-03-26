
public class ExpoPoly {

    public static void main (String[] argv)
    {
	for (double n=10; n<=100; n+=10) {
	    
	    // MY CODE
	    double poly = Math.pow (n, 4);                 
            double exp = Math.pow (2.0, n);
	    
	    System.out.printf ("poly=%f  exp=%f\n", poly, exp);
	}
    }

}
