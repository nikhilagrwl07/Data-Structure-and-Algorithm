
package dynamicprogramming;

public class LongestPalindromicSubsequence {
    
         static int longest=Integer.MIN_VALUE;
         static String longestString=null;
     public static void main(String[] args) {
         
         String c="GEEKSFORGEEKS";
     //   int s=0,e=c.length-1;
        
        solution(c);
     
     
    }
     public static void solution(String c)
     {
         System.out.println("Input String: "+c);
         
  System.out.println("Length of LPS(Naive) : "+Naive(0,c.length()-1,c.toCharArray()));
            
    subsequence(c);
    System.out.println("Length of LPS(My way) : "+longest);  
   DP(c.toCharArray());
     }

     public static int Naive(int s,int e,char[] c)
     {
         if(s==e)
             return 1;
         
         if(s<e)
         {
             if(c[s]==c[e])
             {
                // System.out.println(s+" "+e+" "+c[s]+" ");
                 return Naive(s+1,e-1,c)+2;
             }
             else if(c[s]!=c[e])
             {
                 return Math.max(Naive(s+1, e, c),Naive(s, e-1, c));
             }
         }
        
             return 0;
         
     }
   
     public static void subsequence(String c)
     {
        
        int i;//Integer.parseInt(args[1]);
        
        for(i=0;i<=c.length();i++)
            print("", c, i);
     
     System.out.println("Longest Palindromic Subequence= "+longestString);
     }
     
      public static void print(String prefix, String remaining, int k) {
        if (k == 0 && prefix.length()!=0) 
        {
            
            if(isPalindrome(prefix))
            {
                if(longest<prefix.length())
                {
                    longest=prefix.length();
                    longestString=prefix;
                 }
                //System.out.println(prefix);
            }
            //
            return;
        }
        if (remaining.length() == 0)
            return;
        
        print(prefix + remaining.charAt(0), remaining.substring(1), k-1);
        print(prefix, remaining.substring(1), k);
    }
    
      public static boolean isPalindrome(String s)
      {
          int N=s.length()-1,i;
         
          for(i=0;i<=N;i++)
          {
              if((i<=N-i) && s.charAt(i)!=s.charAt(N-i))
                  return false;
                  
          }
          
          return true;
      }
      
      public static void DP(char[] str)
      {
          int n=str.length,i,j;
          int[][] L=new int[n][n];
          int cl;
          
            for (i = 0; i < n; i++)
                L[i][i] = 1;
 
    // Build the table. Note that the lower diagonal values of table are
    // useless and not filled in the process. The values are filled in a
    // manner similar to Matrix Chain Multiplication DP solution (See
    // http://www.geeksforgeeks.org/archives/15553). cl is length of
    // substring
    for (cl=2; cl<=n; cl++)
    {
        for (i=0; i<n-cl+1; i++)
        {
            j = i+cl-1;
            if (str[i] == str[j] && cl == 2)
               L[i][j] = 2;
            else if (str[i] == str[j])
               L[i][j] = L[i+1][j-1] + 2;
            else
               L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
        }
    }
 
          
           for(i=0;i<str.length;i++)
          {
              for(j=0;j<str.length;j++)
              {
                  System.out.print(L[i][j]+" ");
              }
              System.out.println();
        }
      }
}

