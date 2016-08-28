package nikhil.algo.KMP;

public class KMPalgo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMPalgo kmp=new KMPalgo();
		
		String txt="ABABDABACDABABCABAB";
		String pat="ABABCABAB";
		kmp.KMPsearch(pat,txt);
	}
	public void KMPsearch(String pat,String txt)
	{
		int m=pat.length();
		int n=txt.length();
		
		 // create lps[] that will hold the longest prefix suffix values for pattern
		int lps[]=new int[m];
		
		 int j  = 0;  // index for pat[]
		 
		// Preprocess the pattern (calculate lps[] array)
		    computeLPSArray(pat, m, lps);
		
	}
	public void computeLPSArray(String pat,int len,int[] lps)
	{
		
	}
	
}
