
package lexicographicpermutationsofstring;

import java.util.Arrays;


//Source: http://www.geeksforgeeks.org/lexicographic-permutations-of-string/
public class LexicographicPermutationsOfString {

    // A utility function two swap two characters a and b
 void  swap (char st[],int a, int b)
{
    char p=st[a];
    st[a]=st[b];
    st[b]=p;
}

void print(char s[])
{
    for(int i=0;i<s.length;i++)
        System.out.print(s[i]);
    
    System.out.println();
}
    
 char[] reverse(char[] str,int s,int e)
{
    if(str.length==0) 
        return null;
    
    while(s<e)
    {
        swap(str,s,e);
        s++;
        e--;       
    }
    return str;
}

public  char[] sortString(char[] str,int s,int e)
{
    if(str.length==0) 
        return null;
    
    for(int i=s;i<e;i++)
    {
        int pp=i;
        for(int j=i+1;j<=e;j++)
        {
            if(str[pp]>str[j])
                pp=j;
        }
        swap(str,i,pp);
    }
    return str;
}
    // This function finds the index of the smallest character
// which is greater than 'first' and is present in str[l..h]
    int findCeil(char str[], char first,int l,int h)
    {
        // initialize index of ceiling element
    int ceilIndex = l;
    
    // Now iterate through rest of the elements and find
    // the smallest character greater than 'first'
    for (int i = l+1; i <= h; i++)
      if (str[i] > first && str[i] < str[ceilIndex])
            ceilIndex = i;
 
    return ceilIndex;
    }
    
    // print all permutations of str in sorted order
    void sortedPermutations(char str[])
    {
        
        int size=str.length;
        
        // in-built function for sorting the string       
        Arrays.sort(str);
        str=sortString(str, 0, str.length-1);
//        for(int k=0;k<str.length;k++)
//            System.out.print(str[k]);
//        
//        System.out.println();
        // Print all permutations one by one
        boolean isFinished=false;
        
        while(!isFinished)
        {
            // print the permuations
            System.out.println(str);
            
            // Find the rightmost character which is smaller than its next
        // character. Let us call it 'first char'
            int i;
        for ( i = size - 2; i >= 0; --i )
           if (str[i] < str[i+1])
              break;
        
        // If there is no such chracter, all are sorted in decreasing order,
        // means we just printed the last permutation and we are done.
        if ( i == -1 )
            isFinished = true;
        else
        {
            // Find the ceil of 'first char' in right of first character.
            // Ceil of a character is the smallest character greater than it
            int ceilIndex = findCeil( str, str[i], i + 1, size - 1 );
            
               // Swap first and second characters
            swap( str, i, ceilIndex);
            
         //   System.out.println(" i= "+i+" ceilIndex= "+ceilIndex);
            
            // Sort the string on right of 'first char'
         //   Arrays.sort(str,i+1,size-1);
            str=sortString(str, i+1, size-1);
           // System.out.println("check = "+str);
        }
        
        
        }
    }
    
    
    void sortedPermutations_SelfMade(char str[])
    {
        if(str.length==0)
             return;
       
        
        int N=str.length,i=0,j,secondIndex=-1,firstIndex=N-1;
        
        // the finding first character
        boolean isfinished=false;
        
      //  Arrays.sort(str);
        str=sortString(str, 0, str.length-1);
        
        System.out.println(str);
        
        while(!isfinished)
        {
            firstIndex=N-1;
            
           for(i=N-1;i>0;i--)
           {
               if(str[i]>str[i-1])
               {
                 //  firstch=1;  
                  firstIndex=i-1;
                   break;
               }
           }
          
        //   System.out.print("firstIndex = "+firstIndex);
           //  int Secondch=0;
             
           if(firstIndex!=N-1)
           {
              for(j=firstIndex+1;j<=N-1;j++)
               {
                   if(str[j]>str[firstIndex])
                  {
                    secondIndex=j;
                    // Secondch=1;                   
                   }
                }
           }
           else
           {
               secondIndex=N-1;
                    // Secondch=1; 
           }
           
          //  System.out.println(" SecondIndex ="+secondIndex);
           
           if(firstIndex!=secondIndex)
           { //   System.out.println("1st = "+firstch+" 2nd = "+Secondch);
               
               // swapping the value
               swap(str,firstIndex,secondIndex);
               
               
            //   System.out.println("Check point 1: ");
            //   print(str);
               // sorting the value after the first index
           //   str=sortString(str, firstIndex+1, N-1);
             //  Arrays.sort(str,firstIndex+1,N-1);
               str=reverse(str,  firstIndex+1, N-1);
               
                print(str);
                //System.out.println(str.toString());
           
           }
           else 
               isfinished=true;
            
        }
        
    }
    
 void combine(String instr, StringBuffer outstr, int index)
{
    for (int i = index; i < instr.length(); i++)
    {
        outstr.append(instr.charAt(i));
        System.out.println(i+ " "+ outstr);
        combine(instr, outstr, i + 1);
        outstr.deleteCharAt(outstr.length() - 1);
    }
} 
 
 void combinationTwoString(String str)
 {
     comb2("",str);
 }
 void comb2(String prefix,String str)
 {
     System.out.println(prefix);
     
     for(int i=0;i<str.length();i++)
            comb2(prefix+str.charAt(i),str.substring(i+1));
 }
    
    public static void main(String[] args) {
       
        char str[]="CAB".toCharArray();
      
        LexicographicPermutationsOfString ob=new LexicographicPermutationsOfString();
        
        //  System.out.println( ob.reverse(str, 0, str.length-1));
        //   System.out.println("-------------------");
          
//        char[] t2="CCBA".toCharArray();
//       Arrays.sort(t2,1,3);
        
       // sortString(str, 1, 3);
        
     //  System.out.println(sortString(t2, 1, 3));
        ob.sortedPermutations(str);
        
        System.out.println("-------------------");
         ob.sortedPermutations_SelfMade(str);
         
//         System.out.println("-------------------");
//         ob.combine("abc", new StringBuffer(), 0);
//         
//          System.out.println("-------------------");
//         ob.combinationTwoString("abc");
    }
}
