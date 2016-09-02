
package dynamicprogramming;

import java.util.Arrays;


public class LongestIncresingSubsequence {
    
     public static void main(String[] args) {
    
      int arr[] = { 0, 8, 4, 12, 2, 10, 6, 14};// 1, 9, 5, 13, 3, 11, 7, 15 };    
      
        System.out.println("Initial Array = "+Arrays.toString(arr));
       LIS(arr);
    }
     
     public static void LIS(int a[])
     {
         System.out.println("Maximum length of LIS = "+LISutil_BottomUp(a));
     }
     
     
     // Bottom Up DP approach
     // instead of that also complexity=O(n^2)
     public static int LISutil_BottomUp(int a[])
     {
         // contains LIS length till index i as LIS[i]
         int lis[]=new int[a.length];
        
         lis=initialze(lis);
                  
         int i,j;
         
         for(i=0;i<a.length;i++)
         {
                int maxIndex=-1;
                 int maxValue=-1;
             
             for(j=0;j<i;j++)
             {
                 if(a[j]<=a[i] && maxValue<lis[j])
                 {
                         maxValue=lis[j];
                         maxIndex=j;
                 }
             }
             
             if(maxIndex!=-1)
                lis[i]=lis[maxIndex]+1;
             
         }
         System.out.println("LIS Array = "+Arrays.toString(lis));
         
         int max=Integer.MIN_VALUE;
         
         for(i=0;i<lis.length;i++)
         {
             if(max<=lis[i])
             {
                 max=lis[i];
             }
         }
             
         return max;
     }
     
     
     public static int[] initialze(int[] l)
     {
         for(int i=0;i<l.length;i++)
             l[i]=1;
         
         return l;
     }
     
}