
package stringalgorithm;
// Source: http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
public class KMP {

   
    public static void main(String[] args) {
        String txt="abcabcdabcyxabcdabcdabcy";
        String pat="abcdabcy";
        
        solution(txt.toCharArray(),pat.toCharArray());
    }
    public static void solution(char[] txt,char[] pat)
    {
        if(txt.length==0 || pat.length==0)
            return;
        
        int[] lps=new int[pat.length];
        
        lps=computeLPSArray(pat,lps);
        
        printArray(lps);
        
        KMPsearch(txt,pat,lps);
        
    }
    
    public static void KMPsearch(char[] txt,char[] pat,int[] lps)
    {
        int i=0,j=0;
        
        while(i<txt.length)
        {
            if(txt[i]==pat[j])
            {
                i++;
                j++;
            }
            else // txt[i]!=pat[j]
            {
                if(j==0)
                    i++;
                else
                {     
                   
                    j=lps[j-1];
                }
            }
            
            if(j==pat.length)
            {
                System.out.println("Match Occur i = "+(i-j));
                j=lps[j-1];
            }
            
        }
    }
    
     public static int[] computeLPSArray(char[] pat,int[] lps)
     {
         // for computing LPS array for given pattern
         lps[0]=0; // becuase of NO PROPER suffix and NO PROPER prefix
         int i=1,j=0;
         
         while(i<pat.length)
         {
             if(pat[i]==pat[j])
             {
                 j++;
                 lps[i]=j;
                 i++;
             }
             else // pat[i]!=pat[j]
             {
                 if(j!=0)
                 {
                     j=lps[j-1];
                 }
                 else
                 {
                     lps[i]=0;
                     i++;
                 }
             } 
         }
         return lps;
     }

     public static void printArray(int[] a)
     {
         for(int i=0;i<a.length;i++)
             System.out.print(a[i]+" ");
     }

}
