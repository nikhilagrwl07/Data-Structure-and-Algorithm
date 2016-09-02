
package bitonicarraysearch;

import java.util.Arrays;

public class BitonicArraySearch {

    public static void main(String[] args) {
       
        int a[]={1,2,5,6,9,10,14,16,17,15,12,10,3,2,1};
        //int b[]={15,12,10,3,2,1};
        
        // int a[]={1,2,5,6,9,10,14,16};
        System.out.println("Array: "+Arrays.toString(a));
        
        int k=bitonicSearch(a);
        System.out.println("Bitonic element= "+k);
    }
    
    public static int bitonicSearch(int[] a)
    {
        int N=a.length;
        
        if(N==0)
            return -1;
        if(N==1)
            return a[0];
        if(N==2)
            return Math.max(a[0], a[1]);
        
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
                else if(a[mid-1]>a[mid] && a[mid]>a[mid+1])
                {
                    high=mid-1;
                }
                else
                    return Integer.MIN_VALUE;
            }
            
        }
        
          return Integer.MIN_VALUE;        
    }
}
