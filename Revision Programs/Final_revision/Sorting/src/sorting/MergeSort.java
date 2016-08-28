/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;


import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
    	
        int[] list = {14, 32, 67, 76, 23, 41, 58, 85,-1,-1,32};
        
        System.out.println("before:\n " +Arrays.toString(list));     
        
        mergeSort(list,0,list.length-1);
       
        // Performing insertion sort
        
     //  insertionSort(list,0,list.length-1);
        
//        for(int i=0;i<list.length;i++)
//        {
//            insertionSort(list,0,i);
//         //System.out.println(Arrays.toString(list));
//            int result= findingMedian(list,0,i);
//            
//            System.out.println("0 - "+i+" Median = "+result);
//            
//            
//        }
        
        
        System.out.println("after: \n " + Arrays.toString(list));
        
        
    }

    public static void insertionSort(int a[],int start,int end)
    {
        int i,j,temp,val,check =-1,k;
       
        for(i=start;i<=end;i++)
        {
            j=start;
            
            while(j<i)
            {
                if(a[j]>a[i])
                {
                    check=1;
                    break;
                }
            j++;
                
            }
            val=a[i];
            temp=j;
            k=i-1;
            while(k>=j && check==1)
            {
                a[k+1]=a[k];
                k--;
            }
            a[temp]=val;
        // System.out.println("i = "+ i+" "+ Arrays.toString(a));
        }
        
    }
    
    public static int findingMedian(int a[],int s,int e)
    {
        if(s==e)
            return a[s];
        int l;
        
        if(e==0)
           l=e-s+2;
        else
            l=e-s+1;
        
        System.out.print("  length  ="+l+"  ");
        if(l%2!=0)
            return a[l/2];
        else
            return (a[l/2]+a[(l/2)-1])/2;
    
    }
 
    
    public static void mergeSort(int a[],int low, int high)
  {
       if (low < high) { 
       
              int mid = low + (high -low)/2;
          
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
       
       
       if (h > mid)
       { 
            for (k=j; k<=high; k++) 
            {  
              b[i] = a[k]; 
              i++;
            }
       } 
       else 
       {
        for (k=h; k<=mid; k++) 
        {
          b[i] = a[k]; 
          i++;
        }
       }
       
       for (k=low; k<=high; k++)
            a[k] = b[k];
   }
  
   
 }