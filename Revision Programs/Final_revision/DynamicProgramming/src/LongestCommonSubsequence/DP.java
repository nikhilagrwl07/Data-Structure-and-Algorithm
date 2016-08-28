
package LongestCommonSubsequence;

import java.util.Arrays;


public class DP 
{
    public static void main(String[] args) {
       
        char s1[]="AGGTAB".toCharArray();
        char s2[]="GXTXAYB".toCharArray();
                
  System.out.println("\ns1 = "+Arrays.toString(s1));
     System.out.println("s2 = "+Arrays.toString(s2));
     
    // char[] ans=new char[Math.max(s1.length, s2.length)];
     
     int lcs_length=Naive(s1,s2,0,0);
      
      System.out.println("length(Bottom Up Recursion)= "+lcs_length);//+" String= "+Arrays.toString(ans));
     
      int lcs_length_top_down=Naive3(s1,s2,s1.length-1,s2.length-1);
      
      System.out.println("length(Tpp Down Recursion)= "+lcs_length_top_down);//+" String= "+Arrays.toString(ans));
     
      
      
      // DP(a);
    }
    
    
   // O(n^2)  
    public static void DP(int[] t)
    {
        int N=t.length;

        // Base cases
        if(N==0)
        {
            System.out.println(-1);
        }
        
        if(N==1)
        {
            System.out.println(t[0]>0?t[0]:-1);
        }
        
        
        int j;
        int Mj=0;
        int max=Integer.MIN_VALUE;
     
        
        for(j=0;j<N;j++)
        {
           Mj=Math.max(Mj+t[j], t[j]);            
          
           max=Math.max(Mj,max);
          
           // System.out.println("j= "+j+" Mj= "+Mj);
        }
        
        
     System.out.println("Maximum Value Contiguous Subsequence(DP) ="+max);
     //   System.out.println("i= "+iMax+" j= "+jMax);
        
    }

    // bottom up approach
    public static int Naive(char[] s1,char[] s2,int i,int j)
    {
        // Base Cases
        if(i==s1.length-1 || j==s2.length-1)
        {
            if(s1[i]==s2[j])
            {
               // ans=ans+s1[i];
                return 1;
            }
            else
            {
                if(i!=s1.length-1)
                {
                    return Naive(s1,s2,i+1,j);
                }
                else
                    return Naive(s1,s2,i,j+1);
                
            }
           // return 0;
        }
        
        if(s1[i]==s2[j])
        {
            return 1+Naive(s1, s2, i+1, j+1);//, ans+s1[i]);
        }
        else
        {
            return Math.max(Naive(s1, s2, i, j+1), Naive(s1, s2, i+1, j));
        }
        
    }

    // Top Down Approach
     public static int Naive3(char[] s1,char[] s2,int i,int j)
    {
        // Base Cases
        if(i==0 || j==0)
        {
            if(s1[i]==s2[j])
            {
               // ans=ans+s1[i];
                return 1;
            }
            return 0;
        }
        
        if(s1[i]==s2[j])
        {
            return 1+Naive3(s1, s2, i-1, j-1);//, ans+s1[i]);
        }
        else
        {
            return Math.max(Naive3(s1, s2, i, j-1), Naive3(s1, s2, i-1, j));
        }
        
    }
}
