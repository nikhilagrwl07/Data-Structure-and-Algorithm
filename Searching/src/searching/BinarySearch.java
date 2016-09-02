/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package searching;

/**
 *
 * @author nikhil.agrawal
 */
public class BinarySearch {
     public static void main(String[] args) {

//         int x = 10;
//         int y = (int) (x * Math.pow(10, 16000000));
         
//         System.out.println("y :: " + y);
//         int a[]={1,1,1,2,2,2, 3,4,5,5,5,5,5,6,7,8};
//         int a[]={1,1,1,1,1,1,1,1,1};
          int a[]={1,2,3,4,5,6,7,8,9,9};
      System.out.println("index of element (iterative) :: " + binarySearch(a, 9));
//      System.out.println("index of element (recursive) :: " + recursiveBinarySearch(a, 0, a.length-1, 1));
    
    }

     
 // for each call there is 3 number of comparsions    
public static int binarySearch(int n[], int a)
{
    
    if(n.length==0 || n.length==1)
        return -1;
    
    int low=0, high =n.length-1, mid;
    
        while(low<=high)
        {
            mid = low+((high-low)/2) ;
            if(n[mid] == a)
            {
                return mid;
            }
            else if(n[mid]>a)
            {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
    return -1;
}

public static int recursiveBinarySearch(int a[], int l,int h , int x)
{
    
    if(l<=h)
    {
      int m= l+ (h-l)/2;
      
      if(a[m]==x) 
          return m;
      else if(a[m]<x)
          return recursiveBinarySearch(a, m+1, h, x);
      else
          return recursiveBinarySearch(a, l, m-1, x);
    }
    
    return -1;
    
}


     
}
