
package sorting;

public class QuickSort {

    public static void main(String[] args) {
       
//        int arr[]={5,5,6,6,6 ,1,1,2,2,2,3,4,5};  //
//        int arr[] = {40, 20, 10, 80, 60, 50, 7, 30, 40,7,40};
//        int arr[] ={1,2,3,4,5,6,7,8};
            int arr[] = {4,8,5,6,9,10,6,10,1,2,1,2,2,1,15,14,17, 0 , 0};
       for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
       
      System.out.println(); 
     System.out.println("After recursive QuickSort:");
//       
        int lo=0;
        int hi=arr.length-1;
        
//        quickSort(arr,lo,hi);
//        quickSortlognSpaceOptimized(arr,lo,hi);
        quickSortlognSpaceOptimizedInWorstCaseAlso(arr,lo,hi);
        
       for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
    }

// Quick Sort with NO partitioning method    
// Source : Programming Interview Exposed book
public static void quickSort(int A[], int l, int h)
{
        int pivot=l;  //(l+h)/2;
        int pivotValue=A[pivot];
        
        int i=l,j=h;
        while(i<=j)
        {
            while(A[i]<pivotValue)
                    i++;
            
            while(A[j]>pivotValue)
                    j--;
            
            if(i<j)
            {
                //swap a[i] with a[j] and change i and j
                int t=A[j];
                A[j]=A[i];
                A[i]=t;
                
                i++;
                j--;
                
            }       
            else if(i==j)
            {
                i++;
                j--;
            }
            
        }
        
        
        if(l<j)        
            quickSort(A,l,j);
 
        if(i<h)        
            quickSort(A,i,h);
}


public static void quickSortlognSpaceOptimized(int arr[],int low,int high)
{
    while (low < high)
    {
        /* pi is partitioning index, arr[p] is now
           at right place */
        int pi = partition(arr, low, high);
 
        // Separately sort elements before
        // partition and after partition
        quickSort(arr, low, pi - 1);
 
        low = pi+1;
    }
    
}

public static void quickSortlognSpaceOptimizedInWorstCaseAlso(int arr[], int low, int high)
{
    while (low < high)
    {
        /* pi is partitioning index, arr[p] is now
           at right place */
        int pi = partition(arr, low, high);
 
        // If left part is smaller, then recur for left
        // part and handle right part iteratively
        if (pi - low < high - pi)
        {
            quickSort(arr, low, pi - 1);
            low = pi + 1;
        }
 
        // Else recur for right part
        else
        {
            quickSort(arr, pi + 1, high);
            high = pi - 1;
        }
    }
}


public static void quickSort2(int a[],int l,int h)
{
    if(l<h)
    {
        int p=partition(a,l,h); // partitioning index
        
//        for(int i=0;i<a.length;i++)
//        {
//            System.out.print(a[i]+" ");
//        }
//        System.out.println("");
        
        quickSort2(a, l, p-1);
        quickSort2(a, p+1, h);
        
    }
    
}

public static int partition(int arr[],int l,int h)
{
    int x = arr[h];    // pivot
    int i = (l - 1);  // Index of smaller element
 
    for (int j = l; j <=h-1; j++)
    {
        // If current element is smaller than or equal to pivot 
        if (arr[j] <= x)
        {
            i++;    // increment index of smaller element
//            System.out.println("i = " + i + " j = " + j);
//            System.out.println("a[i] = " + arr[i] + "  a[j] = " + arr[j]);
            swap(arr,i, j);  // Swap current element with index
        }
    }
    
    swap(arr, i+1, h ) ; 
    return (i + 1);
  
    
}
    public static void swap(int arr[], int a, int b)
    {
        int c=arr[a];
        arr[a]=arr[b];
        arr[b]=c;
    }

} 