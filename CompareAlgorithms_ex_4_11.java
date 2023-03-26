
public class CompareAlgorithms_ex_4_11 {

    public static void main (String[] argv)
    {
	
	int N = 1_00;
	
	for (int n=10; n<=20; n+=1) {
	    // Algorithm A:
	    long fn = (3*n*n*n) + (5*n*n) + (100*n) ;
	
	    // Algorithm B:
	    long gn = 4*n*n*n;

	    System.out.println ("n=" + n + " f(n)=" + fn + " g(n)=" + gn);
	}
    }


}
