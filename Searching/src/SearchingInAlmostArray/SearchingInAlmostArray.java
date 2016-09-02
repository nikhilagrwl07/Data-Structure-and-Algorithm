package SearchingInAlmostArray;

/**
 *
 * @author nikhil.agrawal
 */
public class SearchingInAlmostArray {
    
    public static void main(String[] args) {
    
        int arr[] = {3, 2, 10, 4, 40, 30};
         int x = 3;
         int index = searchInAlmostArray(arr, 0, arr.length-1, 1, x);
         
         System.out.println("Index found :: " + index);
        
    }
    
    
    // Assumption :: Condersing deviation = 1 for now
    public static int searchInAlmostArray(int a[], int low , int high , int deviation , int x )
    {
        
        if(low>high) return -1;
        
        
        int mid = low + (high-low)/2;
        System.out.println(low + " : " + mid + " : " + high);
        
        if(a[mid]==x)
        {
            return mid;
        }
        
        if(low!=mid  && a[mid-deviation]==x)
        {
            return mid-deviation;
        }
        
        if(high!=mid  && a[mid+deviation]==x)
        {
            return mid+deviation;
        }
        
        
        if(x<a[mid])
        {
            return searchInAlmostArray(a, low, mid-deviation-1, deviation, x);
        }
        
        else
        {
            return searchInAlmostArray(a, mid+deviation+1, high, deviation, x);
        }
        
//        return -1;
        
    }


}
