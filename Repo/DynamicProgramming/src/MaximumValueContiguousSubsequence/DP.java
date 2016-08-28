
package MaximumValueContiguousSubsequence;

import java.util.Arrays;

public class DP 
{
    public static void main(String[] args) {
        int a[]={-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(Arrays.toString(a));
        Naive(a);
        DP(a);
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

     public static void Naive(int[] t)
    {
        int N=t.length;

        if(N==0)
        {
            System.out.println(-1);
        }
        
        if(N==1)
        {
            System.out.println(t[0]>0?t[0]:-1);
        }
        
        int i,j;//,iMax=-1,jMax=-1;
        
        int sumGlobal=Integer.MIN_VALUE;
        
        for(i=0;i<N;i++)
        {
               int sumT=0,sumPrev=0;
               
            for(j=i;j<N;j++)
            {
               sumT+=t[j];
               
               if(sumPrev<sumT)
               {
                   sumPrev=sumT;
                 //  iMax=i;
                 //  jMax=j;
               }
                    
            }
            if(sumGlobal<sumPrev)
            {
                sumGlobal=sumPrev;
            }
        }
        
        System.out.println("Maximum Value Contiguous Subsequence="+sumGlobal);
     //   System.out.println("i= "+iMax+" j= "+jMax);
        
    }

}
