
package stringalgorithm;


public class Horspool {
    
      public static final int no_of_char=127;
      
    public static void main(String[] args) {
      
        char[] txt="AABAACAADAABAAABAA".toCharArray();
        char[] pat="AABA".toCharArray();
        
        int[] shift=new int[no_of_char];
        computeShift(shift,pat);
        
                
        search(pat,txt,shift);   
        
    }
    
        public static void search(char[] pat,char[] txt,int[] shift)
        {
            int i=0;
            int N=txt.length;
            int M=pat.length;
            int j;
            System.out.println();
            
            while(i<=N-M)
            {
               
                j=M-1;
                // reverse checking in txt so that y adding i+j
                // System.out.println("\n j = "+j+" i+j= "+(i+j)); 
                 
                while(j>=0 && pat[j]==txt[i+j] )
                {
                    j--;
                }
                
                // System.out.println("After: j ="+j);
                 
                if(j==-1)
                {
                    System.out.println("Pattern occur i = "+i);
                    //j=0;    
                }
               
                if(j==M-1)
                    i=i+shift[txt[i+j]];
                else // taking shift= last matched letter
                    i=i+shift[txt[i+j+1]];
                
            }
                
        }
    
    // computing the shifting array
    public static void computeShift(int[] shift,char[] pat)
    {
        // initiailze the array
        int M=pat.length;
        int i,index,j;
        
        // default shiting 
        for(i=0;i<shift.length;i++)
          shift[i]=M;
        
         // accessing each of the charcter of 127 charcters and finding the index
            for(j=pat.length-2;j>=0;j--)
            {
                index=M-1-j;
             //   System.out.println("c = "+pat[j]+" index = "+index);
                
                if(shift[pat[j]]==M || shift[pat[j]]>index)
                {
               //     System.out.println("pat[j]= "+pat[j]);
                    shift[pat[j]]=index;
                }
            }
            
        
      //  printArray(shift);
        
    }
    
    public static void printArray(int[] s)
    {
        for(int i=0;i<s.length;i++)
            System.out.print(s[i]+" ");
    }
}
