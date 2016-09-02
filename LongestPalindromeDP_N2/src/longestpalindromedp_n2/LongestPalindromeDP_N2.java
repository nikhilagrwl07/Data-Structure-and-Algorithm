
package longestpalindromedp_n2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LongestPalindromeDP_N2 {

    
    public static void main(String[] args) throws IOException {
       
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
       String A= br.readLine();       
    
       longestPalindromeDP1(A);
       longestPalindromeDP3(A);
      //longestPalindromeDP2(A);
    }
    
    // Time complexity - O(n2). 
    // Space Complexity - O(n2)
    public static void longestPalindromeDP1(String s)
    {
        
        int n = s.length();
  int longestBegin = 0;
  int maxLen = 1;
     boolean table[][] = new boolean[1000][1000];  //{false};
  for (int i = 0; i < n; i++) {
    table[i][i] = true;
  }
  for (int i = 0; i < n-1; i++) {
    if (s.charAt(i) == s.charAt(i+1)) {
      table[i][i+1] = true;
      longestBegin = i;
      maxLen = 2;
    }
  }
  for (int len = 3; len <= n; len++) {
    for (int i = 0; i < n-len+1; i++) {
      int j = i+len-1;
      if (s.charAt(i) == s.charAt(j)&& table[i+1][j-1]) {
        table[i][j] = true;
        longestBegin = i;
        maxLen = len;
      }
    }
  }
  
  
    System.out.println(s.subSequence(longestBegin, maxLen+longestBegin));
    }
         
   public static String expandAroundCenter(String s,int c1,int c2)
   {
       int l=c1,r=c2;
       int n=s.length();
       
       while(l>=0 && r<=n-1 && s.charAt(l) ==s.charAt(r))
       {
           l--;
           r++;
       }
        System.out.println((l+1)+"  "+(r-l-1));
       
       System.out.println(s.substring(l+1,r-l-1));
       return s.substring(l+1,r-l-1);
   }
    
    public static void longestPalindromeDP2(String s)
    {
        int n=s.length();
        if(n==0) return;
        
        // A single char is always a palindrome
        String longest=s.substring(0, 1);
            
        for(int i=0;i<n-1;i++)
        {
            String p1=expandAroundCenter(s,i,i);
            if(p1.length()>longest.length())
            {
                longest=p1;
            }
            
            String p2=expandAroundCenter(s, i, i+1);
            if(p2.length()>longest.length())
            {
                longest=p2;
            }
        }
        
        System.out.println(longest);
    }

    public static void longestPalindromeDP3(String s)
    {
        if(s.length()==0 || s.length()==1)
        {
            System.out.print("Longest Palindrome Substring = "+s);
            return;
        }
        
        int N=s.length();
        int i,j,diff=1;
        
        // declaring the table t[][]
        int[][] t=new int[N][N];
        
        for(i=0;i<N;i++)
        {
            t[i][i]=1;
        }
        
        diff=1;
        while(true)
        {
            i=0;
            
            j=i+diff;
         
            
            while(j<N)
            {
                if(diff==1)
                {
                    if(s.charAt(i)==s.charAt(j))
                        t[i][j]=1;
                    else
                        t[i][j]=0;
                }
                else // diff>=2
                {
                    if(s.charAt(i) ==s.charAt(j))
                        t[i][j]=t[i+1][j-1];
                    else
                        t[i][j]=0;
                }
                i++;
                j++;
            }
            diff++;
            
//       /  System.out.println("i = "+i +" j = "+j);
          
            if(i==1)
              break;    
        }
        
        int max=Integer.MIN_VALUE;
        int maxI=-1;
        int maxJ=-1;
        for(i=0;i<N;i++)
        {
            for(j=i;j<N;j++)
            {
              //  System.out.print(t[i][j]+" ");
                        
                if(t[i][j]==1 && max<(j-i))
                {
                    max=(j-i);                    
                    maxI=i;
                    maxJ=j;
                }
                
            }
          //  System.out.println();
        }
       // System.out.println(maxI+"  "+maxJ);
  System.out.print("Longest Palindrome Substring = "+s.substring(maxI, maxJ+1));
    }


}
