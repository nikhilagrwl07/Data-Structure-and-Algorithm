
package Sorting;

import java.util.Arrays;

public class IterativeQuickSort {

    public static void main(String[] args) {
          int arr[]={40, 20, 10, 80, 60, 50, 7, 30, 40,7,40};

        System.out.print("Before quick Sort :: "+ Arrays.toString(arr));

        int lo=0;
        int hi=arr.length-1;

        quickSort(arr,lo,hi);
        //quickSort2(arr,lo,hi);

        System.out.print("\nAfter quick Sort :: "+ Arrays.toString(arr));
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


}
