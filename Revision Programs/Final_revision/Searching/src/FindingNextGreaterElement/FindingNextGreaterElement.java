package FindingNextGreaterElement;

/**
 *
 * @author nikhil.agrawal
 */
public class FindingNextGreaterElement {
    
    public static void main(String[] args) {
//         int r[]={1,2,3,4,4,6,8,8,8,8,8,9,9,10,10,12,12,12,12,12,12,15,17,17,17,17,18};
     int r[] = {12, 12,16,16, 16, 22, 30, 35, 39, 42,45, 48, 50, 53, 55, 56};
        System.out.println("NGE 1 : " + findNextLargest(r, 0, r.length-1,12,0,r.length-1));
        System.out.println("NGE 2 : " + findCrossOver(r, 0, r.length-1,12));
    }
    
    
    
   public static int findCrossOver(int arr[], int low, int high, int x)
    {
        // Base cases
        if (arr[high] <= x) // x is greater than all
            return high;
        if (arr[low] > x)  // x is smaller than all
            return low;
 
        // Find the middle point
        int mid = (low + high)/2;  /* low + (high - low)/2 */
 
        /* If x is same as middle element, then return mid */
        if (arr[mid] <= x && arr[mid+1] > x)
            return mid;
 
        /* If x is greater than arr[mid], then either arr[mid + 1]
          is ceiling of x or ceiling lies in arr[mid+1...high] */
        if(arr[mid] < x)
            return findCrossOver(arr, mid+1, high, x);
 
        return findCrossOver(arr, low, mid - 1, x);
    }
    
    public static int findPreviousSmaller(int a[],int l,int h,int d,int strt,int end)
     {
         if(l<=h)
         {
         if(d>a[end])
             return a[end];
         
         if(d<a[strt])
             return -1;
         
         int mid=l+(h-l)/2;
//             System.out.println("mid "+ mid);

         if(mid==strt && a[mid]==d)
             return -1;

         if(mid==l && d<a[mid])
             return a[mid-1];

         if(mid==h && d>a[mid])
             return a[mid];
         
         if(a[mid]==d && a[mid-1]<d)
             return a[mid-1];
         
         
         else if(d<=a[mid])
             return findPreviousSmaller(a, l, mid-1, d,strt,end);
         else
             return findPreviousSmaller(a, mid+1, h, d,strt,end);
         }
         
         return -1;
     }
    
    
    public static int findNextLargest(int a[],int l,int h,int d,int strt,int end)
     {
         if(l<=h)
         {
//             System.out.println("l = " + l  + " : h = " + h + " s = " + strt);
             if(d<a[strt])
                 return a[strt];

             if(d>a[end])
                 return -1;

             
             int m=l+(h-l)/2;
//             System.out.println("mid " + m);
             

             if(m==end && d==a[m])// for checking the end case when mid is equal to end(a.length-1)
                 return -1;


             if(a[m]==d && a[m+1]!=d)
                 return a[m+1];

             if( m==l && d<a[m])//for elements not present and if they are less then middle element
                 return a[m];

             if(m==h && a[m+1]>d)//for elements not present and if they are more then middle element
                 return a[m+1];

             if(d<a[m])
                 return findNextLargest(a, l, m-1, d,strt ,end);
             else
                 return findNextLargest(a, m+1, h, d,strt ,end);
         }

         return -1;
     }


}
