/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ropemergingcost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author nikhil.agrawal
 */
public class ropeMergingCost {
    
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //  String str = br.readLine();
            System.out.println("Please enter length of arrray :: ");

            int len = Integer.valueOf(br.readLine()).intValue();
            
            int a[]= new int[len];
            
            for(int i=0;i<len;i++)
            {
                System.out.println("Please enter values:: ");
                a[i]=Integer.valueOf(br.readLine()).intValue();
            }
            
            System.out.println("Before sorting Arrays ::: "+ Arrays.toString(a));
            mergeSort(a,0,a.length-1);
            
            System.out.println("MinCost ::: "+ computeMinCost(a));
            
    }
    
    
    public static int computeMinCost(int[] rope)
    {
    
        int len = rope.length;
        int sum =0;
        
        for(int i=0;i<len;i++)
        {
            if(i==0 || i==1)
            {
              sum += (rope[i] * (len-1));
            }
            else
            {
                sum += (rope[i] * (len-i));
            }
            
        }
        return sum;
        
    }
    
    
   public static void mergeSort(int a[],int low, int high)
  {
       if (low < high) { 
       
              int mid = (low + high)/2;
          
              mergeSort(a,low, mid);
              mergeSort(a,mid+1, high);
              
              merge(a,low, mid, high);
       }
   }
      
       public static void merge(int a[],int low, int mid, int high)
   {
       int b[]=new int[a.length];    // This is where extra Space Complexity of O(n) is required which is maximum in last merge 
       int h = low, i = low, j = mid+1, k;
       
       while ((h <= mid) && (j <= high)) 
       {
          if (a[h] <= a[j])
           { 
           b[i] = a[h]; h++;
           }
           
          else 
          {
          	 b[i] = a[j]; j++; 
          }
          i++;
       }
       
       
       if (h > mid){
        for (k=j; k<=high; k++)
        {
            b[i] = a[k];
            i++;
         }
       }
       else {
           for (k = h; k <= mid; k++) {
               b[i] = a[k];
               i++;
           }
       }
       for (k=low; k<=high; k++)
            a[k] = b[k];
   }
    
    


}
