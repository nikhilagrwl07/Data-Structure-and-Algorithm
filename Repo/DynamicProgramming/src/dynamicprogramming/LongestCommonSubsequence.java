
package dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    static char[] result=new char[6];
    
    public static void main(String[] args) {
    
      char[] s2= "AGGTAB".toCharArray();
      char[] s1="GXTXAYB".toCharArray();
      
      System.out.println("\ns1 = "+Arrays.toString(s1));
     System.out.println("s2 = "+Arrays.toString(s2));
     
     
   int lcs_length=naive2(s1,s2,s1.length-1,s2.length-1,0);
     
   System.out.println("(Recursion) Length= "+lcs_length);
  
    for(int i=0;i<result.length;i++)
        System.out.print(result[i]);
    
//    LCS_DP(s1,s2);
    }
    
    
      public static int naive2(char[] s1,char[] s2,int l1,int l2,int i)       
      {
          if(l1<0 || l2<0)       
              return 0;
          
          if(s1[l1]==s2[l2])
          {
            //  System.out.println("check");
            // result[i]=s1[l1];
            //  System.out.println(i);
              return 1+naive2(s1, s2, l1-1, l2-1,i+1);
          }
          else 
          {
                 return Math.max(naive2(s1, s2, l1-1, l2,i),naive2(s1, s2, l1, l2-1,i));
          }
      }

      
   
//    public static int naive(char[] s1,char[] s2,int l1,int l2,String s)
//    {
//       
//        if(l1==0 || l2==0)
//        {
//            return 0;
//        }
//        
//        if(s1[l1-1]==s2[l2-1])
//        {
//       //   System.out.println(l1+" "+l2+" "+s1[l1]+ " check 2");
//            s=s1[l1-1]+s;
//            return naive(s1,s2,l1-1,l2-1,s)+1;
//        }
//        else
//        {
//            int f1=naive(s1, s2, l1, l2-1,s);
//            int f2=naive(s1, s2, l1-1, l2,s);
//            return Math.max(f1, f2);
//        }
//    }

    public static void LCS_DP(char[] s1,char[] s2)
    {
        if(s1.length==0 || s2.length==0)
            return ;
        
        int l1=s1.length,l2=s2.length;
        
        int m[][]=new int[l1+1][l2+1];
        
        int i,j;
       
        System.out.print("LCS String = ");
       for(i=0;i<=l1;i++)
        {
            for(j=0;j<=l2;j++)
            {
                if(i==0 || j==0)
                {
                    m[i][j]=0;
                }

                else
                {
                    if(s1[i-1]==s2[j-1] )
                    {
                        m[i][j]=m[i-1][j-1]+1;
                        System.out.print(s1[i-1]);
                    }
                    else
                    {
                       m[i][j]=Math.max(m[i][j-1],m[i-1][j]);
                    }
                 
                }
            }
        }
        
        System.out.println("\nLength (Using DP) = "+m[l1][l2]);
    }
}
