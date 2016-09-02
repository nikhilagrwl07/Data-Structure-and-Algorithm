
package searchinrotatedarray;

import java.util.Arrays;


public class SearchInRotatedArray {

    public static void main(String[] args) {
        
//         int a[]={10,14,16,17,1,2,5,6,9};
         int a[]={10,14,16,17,18,19,20};
//          int a[]={17,15};
         System.out.println("Array: "+Arrays.toString(a));
        
        int k=findPivot(a,0,a.length-1);
        System.out.println("Pivot element= "+k);
    }
    
    
    public static int findPivot(int arr[], int low, int high)
    {
       // base cases
       if (high < low)  return -1;
       if (high == low) return low;

       int mid = low + (high - low)/2;
       
       if (mid < high && arr[mid] > arr[mid + 1])
           return mid;
       if (mid > low && arr[mid] < arr[mid - 1])
           return (mid-1);
       if (arr[low] >= arr[mid])
           return findPivot(arr, low, mid-1);
       
       return findPivot(arr, mid + 1, high);
    }
    
  
}
