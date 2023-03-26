
public class ExpoFactorial {

    public static void main (String[] argv)
    {
	for (int n=1; n<=10; n+=1) {
	    double exp = Math.pow (2.0, n);
	    double fact = factorial (n);
	    System.out.printf ("exp=%f  factorial=%f\n", exp, fact);
	}
    }

    static double factorial (int n) 
    {
	double fact = 1.0;
	for (int i=n; i>1; i--) {
	    fact *= i;
	}
	return fact;
    }

}
