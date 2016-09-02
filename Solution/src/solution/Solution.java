
package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

  
    public static void main(String[] args) throws IOException {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String l1 = br.readLine().toLowerCase();
            String l2 = br.readLine().toLowerCase();
            
            
            
            if(l1==null || l2==null)
                System.out.println(0);
            else
            {
                    int result=0;
                     int word1=0,word2=0;
                String delims = "[ .,]+";

                    String[] t1 = l1.split(delims);    
                    String[] t2 = l2.split(delims);    

                for (String w: t1)
                {
                        word1++;
                }
                
                for (String w: t2)
                {
                        word2++;
                }
                    
           //     System.out.println("len1 ="+word1+" len1 ="+word2);
                    // Case 1:
                    int p1=findingcommon(l1,t2);
            System.out.println("p1 ="+p1);
                    // Case 2:
                int p2=findingcommon(l2,t1);
        System.out.println("p2 ="+p2);
                if(p1==0 && p2==0)
                {
                    System.out.println("Check="+0);
                }
                
                else
                {
        
                if(p1>p2)
                {
                   result=(int) Math.ceil((100.0*p1)/word2); //l2.length();
                        
                  // System.out.println(result);
                }
                else if(p2>p1)
                {
                    result=(int) Math.ceil((100*p2)/word1); //l1.length();
                  //  System.out.println(result);
                }
                else if(p1==p2)
                {
                    result=Math.max((int) Math.ceil((100*p1)/word2), (int) Math.ceil((100*p2)/word1));
                }
                
                  System.out.println(result);
               // result=Math.floor(result);
                // System.out.println(result);
                }
            }
    }
    
    public static int findingcommon(String txt,String[] pat)
    {
        
        if(txt==null || pat==null)
            return 0;

        int countCommon=0;
        
        // for each word of pat find it in txt
        //for (String w: pat)
//       / for(int i=0;i<pat.length;i++)
       for (String w: pat)
        {
            if(solution(txt.toCharArray(),w.toCharArray()))
            {
               System.out.println(w);
                countCommon++;
            }
           
                System.out.println("w = "+ w);
        }
        return countCommon;
    }
    
    
     public static boolean solution(char[] txt,char[] pat)
    {
        if(txt.length==0 || pat.length==0)
            return false;
        
        
        int[] lps=new int[pat.length];
        
        lps=computeLPSArray(pat,lps);
        
        if(KMPsearch(txt,pat,lps)==true)
        {
            return true;
        }
        else
            return false;
    }
    
    public static boolean KMPsearch(char[] txt,char[] pat,int[] lps)
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
                   // i=i+lps[j-1];
                    j=lps[j-1];
                }
            }
            
            if(j==pat.length)
            {
                //System.out.println("Match Occur i = "+(i-j));
                return true;
               // j=lps[j-1];
            }
            
        }
        
        return false;
    }
    
     public static int[] computeLPSArray(char[] pat,int[] lps)
     {
         // for computing LPS array for given pattern
         lps[0]=0; // becuase of NO PROPER suffix and NO PROPER prefix
         int i=1,len=0;
         
         while(i<pat.length)
         {
             if(pat[i]==pat[len])
             {
                 len++;
                 lps[i]=len;
                 i++;
             }
             else // pat[i]!=pat[len]
             {
                 if(len!=0)
                 {
                     len=lps[len-1];
                     
                     // increment of i will NOT happen
                 }
                 else // len==0
                 {
                     lps[i]=0;
                     i++;
                 }
             }
         }
         return lps;
     }
    
}
