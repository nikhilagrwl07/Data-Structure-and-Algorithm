
package FindingNumberOfTimesArrayisRotated;

/**
 *
 * @author nikhil.agrawal
 */
public class FindingNumberOfTimesArrayisRotated {
    
    public static void main(String[] args) {
        int a[] = {3, 3, 1, 2 , 3,3,3,3};
//        int a[]= {1,2,3,4,5,6,7,8,9};
//        int a[]= {8,8,8, 1,2,3,4,5,6,7,8};
//        int a[]={0,0,0,2,2,2,3,3,3,4,4,4};
//        int a[]={0, 0,0,0,0,0,0};
//                int a[] = {9, 1, 2 , 3, 4 ,5,6,7,8};
        
//        int times = numberOftimeArrayisRotated(a);
//        System.out.println("times :: " + times);
       System.out.println(timesOfRotation(a, 0, a.length-1, 0, a.length-1));
        
//        printNumberOfRotations(a);
        
    }
    
    public static int numberOftimeArrayisRotated(int a[])
    {
        if(a==null) return -1;
        if(a.length==1) return 0;
        
        int l=0, h= a.length-1,m;
        
        
        if(a[h]>a[l]) 
        {
            return 0;
        }
        else
        {
            while(l<=h)
            {
                
                m= l + (h-l)/2;
                int prev = (m - 1 + a.length) % a.length; //if mid is at 0, consider last element as previous
                int next = (m + 1) % a.length; // if mid is the last element, consider next element as the first

                System.out.println(l + " " + m + " " + h );
                if(a[m]>a[next] && a[m] > a[prev]) 
                {
                    return next;
                }
                else if(a[m]<a[prev] && a[m] < a[next])
                {
                    return m;
                }
                else if(a[prev]<a[m] && a[m] < a[next])
                {
                    if(a[l]<a[m])
                    {
                        l=next;
                    }
                    else
                    {
                        h=prev;
                    }
                }
                else
                {
                    if(a[l] == a[m] && a[m] ==a[h])
                    {
                        return 0;
                    }
                }
               
            }
            return -1;
        }
        
    }
    
    
    public static int timesOfRotation(int a[],int l,int h,int strt,int end)
     {
         if(a.length==0)
             return -1;
         if(a.length==1)
             return 0;
         
         if(l<=h)
         {
             int m=l+(h-l)/2;
             System.out.println("mid "+ m);

             if(m==end && a[m]>a[m-1])
                 return 0;

             if(m==strt && a[m]>a[m+1])
                 return m+1;

             if(a[m]>a[m-1] && a[m]>a[m+1])
                 return m+1;
             

             
             if(a[l]<=a[m])
                 return timesOfRotation(a, m+1, h,strt,end);

             else if(a[m]<=a[h])
                 return timesOfRotation(a, l, m-1,strt,end);

         }
         return -1;


     }

    
    
    public static void printNumberOfRotations(int a[])
    {
        int rotation= findRotations(a, 0, a.length-1);
        System.out.println("number of rotation :: " + rotation);
    }
    
    public static int findRotations(int[] arr, int low, int high)
    {
        if( arr[low] <= arr[high] )
		return low;
	int len = arr.length;
	int mid = (low + high) / 2;
	int prev = (mid - 1 + len) % len; //if mid is at 0, consider last element as previous
	int next = (mid + 1) % len; // if mid is the last element, consider next element as the first

	if( arr[mid] < arr[prev] && arr[mid] < arr[next] )
		return mid;
	
	if( arr[low] <= arr[mid] ) // if left half is sorted, search in the right half
		return findRotations(arr, mid+1, high);
	else
		return findRotations(arr, low, mid-1); // search in
        
    }


}
