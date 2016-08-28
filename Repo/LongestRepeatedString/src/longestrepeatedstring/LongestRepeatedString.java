
package longestrepeatedstring;

import java.util.Arrays;


public class LongestRepeatedString {

    public static void main(String[] args) {
       
        String str="nikhilagrnikhil";
        
        longestRepeatedString(str);
    }
    
    // Source: http://people.cs.pitt.edu/~kirk/cs1501/Pruhs/Fall2006/Assignments/repeatedstrings/index.html
    public static void longestRepeatedString(String str)
    {
        String[] s=new String[str.length()];
        
        
        int i=0,j,M=str.length();
        
        for(i=0;i<M;i++)
        {
          //  for(j=i;j<M;j++)
           // {
                System.out.println("t  ::: " + str.substring(i,M));
                // calculating substring
                s[i]=str.substring(i,M);
                //s[i]+=i;
           // }
        }
        
       // printArray(s);
        Arrays.sort(s);
       printArray(s);

        int maxlen=-1,len=0,startL=-1,startR=-1;
        
        // Finding the duplicates
        for(i=0;i<=s.length-2;i++)
        {
           // System.out.print("i = "+i);
            
            char[] c1=s[i].toCharArray();
            char[] c2=s[i+1].toCharArray();
            
     //       System.out.println(s[i].length());
            int l=Math.min(s[i].length(), s[i+1].length());
             //System.out.println(", l = "+l);
            
            
            len=0;
            for(j=0;j<l;j++)
            {
                if(c1[j]==c2[j])
                  len++;       
                else
                    break;
            }
            if(maxlen<len)
            {
                maxlen=len;
               startL=i;
               
            }
        }
        
        System.out.print("---------------\nLongest Repeating Substring: ");
        
         for(int k=0;k<maxlen;k++)
         {
             System.out.print(s[startL].toCharArray()[k]);
         }
         
        System.out.println("\nMax Len= "+maxlen);
     
    }
    
    public static void printArray(String[] s)
    {
        int i,M=s.length;
        
      for(i=0;i<M;i++)
      {
           System.out.println(s[i]);
      }
        
    }
}
