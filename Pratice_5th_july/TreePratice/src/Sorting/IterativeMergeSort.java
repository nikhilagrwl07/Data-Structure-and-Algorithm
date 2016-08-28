
package Sorting;

import java.util.Arrays;

public class IterativeMergeSort {

    public static void main(String[] args) {
           int a[]= {10,40,-10,50,100,-1000, 0, 0, 0};
           System.out.println("before sort :: "+ Arrays.toString(a));
          mergeSort(a, 0 , a.length-1);
          System.out.println("after sort :: "+ Arrays.toString(a));
    }

    public static void mergeSort(int a[], int l, int h){
        if(l<h){
            int m = (l+h)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,h);
            merge1(a,l,m,h);
        }
    }

    public static void merge1(int a[], int low , int mid , int high ){
        int low1 =low;
        int mid1= mid+1;
        int temp[] = new int[a.length];
        int index=low;
        while((low1<=mid) && (mid1<=high)){
            
            if(a[low1]< a[mid1])
            {
                temp[index]=a[low1];
                low1++;
            }
            else
            {
                temp[index]=a[mid1];
                mid1++;
            }
            index++;
        }

        // remaining to be copied
        if(low1<mid){
            for(int i=low1;i<=mid;i++){
                temp[index]=a[i];
                index++;
            }
        }
        else
        {
            for(int i=mid1;i<=high;i++){
                temp[index]=a[i];
                index++;
            }
        }

        // copying temp to main array
        for(int i=low;i<=high;i++)
            a[i]=temp[i];

    }
  }
