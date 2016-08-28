

package Sorting;

import java.util.Arrays;

public class IterativeInsertionSort {

    public static void main(String[] args) {
       int a[]= {10,40,-10,50,100,-1000, 0, 0, 0};
       System.out.println("before sort :: "+ Arrays.toString(a));
        insertionSort(a);
          System.out.println("after sort :: "+ Arrays.toString(a));
    }

    public static void insertionSort(int a[]){
        if(a.length==0 || a.length==1) return;

        for(int i=1;i<a.length;i++){

            int key = a[i];
            int j=i-1;

            while(j>=0 && a[j]>key){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }

    }
    

}
