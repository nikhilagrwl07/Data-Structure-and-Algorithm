/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;


import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
    	
        int[] list ={5,5,6,6,6 ,1,1,2,2,2,3,4};
        
//        int[] list =null;
        
//        int[] list = {10,40,-10,50,200,-1000,0,30};
//        
        System.out.println("before:\n " +Arrays.toString(list)); 
//        
        mergeSort(list);
       
//        mergeSortIterativeInPlace(list);
        
         System.out.println("after: \n " + Arrays.toString(list));
       
        
        
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
 
    public static void mergeSort(int a[])
    {
        if(a==null) 
            return;
        if(a.length==1) 
            return;
        
        mergeSortUtil(a, 0, a.length-1);
    }
    
    public static void mergeSortUtil(int a[],int low, int high)
  {
       if (low<high)
       { 
              int mid = low + (( high-low)/2);
//              System.out.println(low + " "+ mid + " " + high);
              mergeSortUtil(a,low, mid);
              mergeSortUtil(a,mid+1, high);
              
              merge(a,low, mid, high);
       }
   }
  
    
    
    /* Iterative mergesort function to sort arr[0...n-1] */
static void mergeSortIterativeInPlace(int arr[])
{
   int curr_size;  // For current size of subarrays to be merged
                   // curr_size varies from 1 to n/2
   int left_start; // For picking starting index of left subarray
                   // to be merged
 int n=arr.length;
   // Merge subarrays in bottom up manner.  First merge subarrays of
   // size 1 to create sorted subarrays of size 2, then merge subarrays
   // of size 2 to create sorted subarrays of size 4, and so on.
   for (curr_size=1; curr_size<=n-1; curr_size = 2*curr_size)
   {
       // Pick starting point of different subarrays of current size
       for (left_start=0; left_start<n-1; left_start += 2*curr_size)
       {
           // Find ending point of left subarray. mid+1 is starting 
           // point of right
           int mid = left_start + curr_size - 1;
 
           int right_end = Math.min(left_start + 2*curr_size - 1, n-1);
 
           // Merge Subarrays arr[left_start...mid] & arr[mid+1...right_end]
           mergeInPlace(arr, left_start, mid, right_end);
       }
   }
}


static void mergeInPlace(int arr[], int l, int m, int r)
{
    
        int i, j, k;
	int n1 = m - l + 1;
	int n2 = r - m;

        if( n1<0 || n2 <0)
            return;
        
        
      //  System.out.println(n1 + " :: " + n2);
	/* create temp arrays */
	int L[] = new int[n1];
        int R[] = new int[n2];
               

	/* Copy data to temp arrays L[] and R[] */
	for (i = 0; i < n1; i++)
		L[i] = arr[l + i];
	for (j = 0; j < n2; j++)
		R[j] = arr[m + 1+ j];

	/* Merge the temp arrays back into arr[l..r]*/
	i = 0;
	j = 0;
	k = l;
	while (i < n1 && j < n2)
	{
		if (L[i] <= R[j])
		{
			arr[k] = L[i];
			i++;
		}
		else
		{
			arr[k] = R[j];
			j++;
		}
		k++;
	}

	/* Copy the remaining elements of L[], if there are any */
	while (i < n1)
	{
		arr[k] = L[i];
		i++;
		k++;
	}

	/* Copy the remaining elements of R[], if there are any */
	while (j < n2)
	{
		arr[k] = R[j];
		j++;
		k++;
	}
}


    static int b[]=new int[12];
       
   public static void merge(int a[],int low, int mid, int high)
   {
           // This is where extra Space Complexity of O(n) is required which is maximum in last merge 
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
