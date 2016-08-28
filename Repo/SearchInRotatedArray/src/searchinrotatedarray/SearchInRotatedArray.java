
package searchinrotatedarray;

import java.util.Arrays;


public class SearchInRotatedArray {

    public static void main(String[] args) {
        
       //  int a[]={10,14,16,17,1,2,5,6,9};
          int a[]={17,15};
         System.out.println("Array: "+Arrays.toString(a));
        
        int k=pivotElement(a);
        System.out.println("Pivot element= "+k);
    }
    
    // increaseing and then increasing
    public static int pivotElement(int[] a)
    {
        int low=0,high=a.length-1;
        
        while(low<=high)
        {
            if(low==high)
                return a[low];
            else if(low==high-1)
                return Math.max(a[low], a[high]);
            else
            {
                int mid=low+(high-low)/2;

              //  System.out.println("mid = "+mid+" low= "+low+" High= "+high);

                if(a[mid-1]<a[mid] && a[mid]>a[mid+1])
                {
                    return a[mid];
                }
                else if(a[mid-1]<a[mid] && a[mid]<a[mid+1])
                {
                    low=mid+1;
                }
                else  if(a[mid-1]>a[mid] && a[mid]<a[mid+1])
                {
                    return a[mid-1];
                }
            }
            
        }
        
       return Integer.MIN_VALUE;
    }
}
