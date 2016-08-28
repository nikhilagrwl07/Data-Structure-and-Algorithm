
package MaximumValueContiguousSubsequence;

import java.util.Arrays;

public class DP 
{
    public static void main(String[] args) {
        int a[]={-2, -3, 4, -1, -2, 1, 5, -3};
//            int a[]={1,1,-3,1,5,-6,-1};
        System.out.println(Arrays.toString(a));
        Naive(a);
        DP(a);
    }
    
    
   public static void DP(int[] a)
   {
       if(a.length==0 || a.length ==1) 
       {
           System.out.println("only one element");
           return;
       }
       
       
       int sumTillNow =0;
       int current=0;
       int start=-1, end =-1;
       
       
       for(int i=0;i<a.length;i++)
       {
          
          if(a[i]>0) 
          {
              //start=i;
              
              current+=a[i];
              
              if(sumTillNow<current)
              {
                 sumTillNow =current ;
              }
             
          }
          else
          {
             
              if(current+a[i]>0)
              {
               current +=a[i];
              }
              else
              {
                   current=0;
              }
             
          }
          
          //if(sumTillNow)
          sumTillNow = Math.max(sumTillNow, current);
          
          
           
          System.out.println( a[i] + " :: " +current  + " :: " + sumTillNow);
       }
      System.out.println("Maximum sum = " + sumTillNow);
       
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
