
package OccurenceOfElement;

public class FirstOccurenceOfElement {
    
    public static void main(String[] args) {

        int a[] = {0,1,1,1,2,3,4,5,6,7,7,7, 8};
        int first = firstOccurence(a, 0, a.length-1, 1);
        System.out.println("first occurence :: " + first);
        int last2 = lastOccurence(a, 0, a.length-1, 1, a.length-1);
        
        
        System.out.println("last occurence index :: " + last2);
    }
    
    
    public static int firstOccurence(int[] a , int low , int high, int element)
    {
        if(low<=high)
        {
            int mid = low + (high-low)/2;
            if((mid==0 || a[mid-1]<element) && a[mid]== element)
                return mid;
            else if(a[mid]<element)
                return firstOccurence(a, mid+1, high, element);
            else
                return firstOccurence(a, low, mid-1, element);
            
        }
        else
            return -1;
    }
    


public static int lastOccurence(int arr[], int low, int high, int x, int n)
{
  if(high >= low)
  {
      
    int mid = low + (high-low)/2;
//    System.out.println(low + " : " + mid + " : " + high);
    if( ( mid == n || x < arr[mid+1]) && arr[mid] == x )
      return mid;
    else if(x < arr[mid])
      return lastOccurence(arr, low, (mid -1), x, n);
    else
      return lastOccurence(arr, (mid + 1), high, x, n);      
  }
  return -1;
}



public static int firstOccurenceOfAnElement(int a[], int l , int h , int x)
{
    if(l<=h)
    {
        int mid = l+(h-l)/2;
        System.out.println(l + " " + mid + " " + h );
        if(a[mid]==x)
        {
            if(mid==l)
                return l;
            else{
                if(a[mid-1] !=a[mid])
                {
                    return mid;
                }
                else
                {
                    return firstOccurenceOfAnElement(a, l, mid-1, x);
                }
            }
            
        }
        else if(a[mid]<x)
        {
            return firstOccurenceOfAnElement(a, mid+1, h, x);
        }
        else {
            return firstOccurenceOfAnElement(a, l, mid-1, x);
        }
        
        
    }
    return -1;
    
}

public static int lastOccurenceOfAnElement(int a[], int l , int h , int x)
{
    if(l<=h)
    {
        int mid = l+(h-l)/2;
        System.out.println(l + " " + mid + " " + h );
        if(a[mid]==x)
        {
            if(mid==h)
                return h;
            else{
                if(a[mid] !=a[mid+1])
                {
                    return mid;
                }
                else
                {
                    return lastOccurenceOfAnElement(a, mid+1, h, x);
                }
            }
            
        }
        else if(a[mid]<x)
        {
            return lastOccurenceOfAnElement(a, mid+1, h, x);
        }
        else {
            return lastOccurenceOfAnElement(a, l, mid-1, x);
        }
        
        
    }
    return -1;
    
}




}
