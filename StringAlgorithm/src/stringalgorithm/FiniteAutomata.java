
package stringalgorithm;


public class FiniteAutomata {
    
      public static final int no_of_char=127;
      
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
       
        
         // Process txt over FA.
    int i, state=0;
    for (i = 0; i < N; i++)
    {
       state = TF[state][txt[i]];
       if (state == M)
       {
         System.out.println("Pattern found at index ="+(i-M+1));
       }
    }
        
    }
    
    /* This function builds the TF table which represents Finite Automata for a
   given pattern  */
    public static void computeTF(char[] pat,int TF[][])
    {
        int state,x;
       
        for(state=0;state<=pat.length;state++)   //O(m+1)
            for(x=0;x<no_of_char;x++)
                  TF[state][x]=getNextState(pat,state,x);
    }
    
 public static int getNextState(char []pat,int state, int x)
 {
    // If the character c is same as next character in pattern,
    // then simply increment state
    // System.out.println("x = "+x+" pat[state] = "+pat[state]+" cond= "+ (x == pat[state]));
     
    if (state < pat.length && x ==pat[state])
        return state+1;
 
    int ns, i;  // ns stores the result which is next state
 
    // ns finally contains the longest prefix which is also suffix
    // in "pat[0..state-1]c"
 
    // Start from the largest possible value and stop when you find
    // a prefix which is also suffix
    for (ns = state; ns > 0; ns--)
    {
         // System.out.println("x = "+x+" pat[ns-1] = "+pat[ns-1]+" cond= "+ (x == pat[ns-1]));
        if(pat[ns-1] == x)
        {
           
         // System.out.println("Check point ");
            for(i = 0; i < ns-1; i++)
            {
                if (pat[i] != pat[state-ns+1+i])
                    break;
            }
            if (i == ns-1)
                return ns;
        }
    }
 
    return 0;
}
    
}
