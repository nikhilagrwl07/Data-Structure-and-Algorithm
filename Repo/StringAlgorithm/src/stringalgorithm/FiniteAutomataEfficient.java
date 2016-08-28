
package stringalgorithm;


public class FiniteAutomataEfficient {

   public static final int no_of_char=256;
      
    public static void main(String[] args) {
      
        char[] txt="ABABDABACDABABCABABABABCABABABABCABAB".toCharArray();
        char[] pat="ABABCABAB".toCharArray();
        
        search(pat,txt);   
        
    }
    // print all occrence of pat in txt
    public static void search(char[] pat,char[] txt)
    {
      
        int M=pat.length;
        int N=txt.length;
        
        // Transition function table
        int TF[][]=new int[M+1][no_of_char];
        
        computeTF(pat,TF);
        
        // process text over FA.
    int i, j=0;
    for (i = 0; i < N; i++)
    {
       j = TF[j][txt[i]];
       if (j == M)
       {
         System.out.println("Pattern found at index= "+(i-M+1));
       }
    }
        
    }
    
    /* This function builds the TF table which represents Finite Automata for a
   given pattern  */
public static void computeTF(char []pat,int TF[][])
{
    int i, lps = 0, x;
 
        //System.out.println("row = "+TF.length);
       // System.out.println("col = "+TF[0].length);
    // Fill entries in first row
    for (x =0; x < no_of_char; x++)
       TF[0][x] = 0;
    
    TF[0][pat[0]] = 1;
 
    // Fill entries in other rows
    for (i = 1; i<pat.length; i++)
    {
        // Copy values from row at index lps
        for (x = 0; x < no_of_char; x++)
            TF[i][x] = TF[lps][x];
 
        // Update the entry corresponding to this character
       // System.out.println("i= "+i+" pat[i] = "+pat[i-1]);
        TF[i][pat[i]] = i + 1;
 
        // Update lps for next row to be filled
        if (i < pat.length)
          lps = TF[lps][pat[i]];
    }
}
    
 
}
