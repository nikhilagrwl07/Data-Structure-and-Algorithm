
package sorting;
import java.util.Stack;

public class QuickSort {

    public static void main(String[] args) {
       
        int arr[]={40, 20, 10, 80, 60, 50, 7, 30, 40,7,40};
            
       for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
       
      System.out.println(); 
     System.out.println("After recursive QuickSort:");
//       
        int lo=0;
        int hi=arr.length-1;
        
      //  quickSort(arr,lo,hi);
        quickSort2(arr,lo,hi);
        
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

public static void quickSort2(int a[],int l,int h)
{
    if(l<h)
    {
        int p=partition(a,l,h); // partitioning index
        quickSort2(a, l, p-1);
        quickSort2(a, p+1, h);
        
    }
    
}

public static int partition(int a[],int l,int h)
{
    int pivot=h;
    int pivotValue=a[h];
    int i=l-1;
    
    for(int j=l;j<=h-1;j++)
    {
        if(a[j]<=pivotValue)
        {
            i++;
            int t=a[i];
            a[i]=a[j];
            a[j]=t;
            
        }
    }
    
    int t=a[i+1];
    a[i+1]=a[pivot];
    a[pivot]=t;
    
    return pivot;
    
}


} 