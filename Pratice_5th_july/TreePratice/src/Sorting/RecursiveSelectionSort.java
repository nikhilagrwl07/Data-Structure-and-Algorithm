package Sorting;

import java.util.Arrays;

public class RecursiveSelectionSort {

    public static void main(String[] args) {

        int a[]= {10,40,-10,50,100,-1000, 0, 0, 0};
        System.out.println("before sort :: "+ Arrays.toString(a));
         sort(a, 0,a.length-1);
         System.out.println("after sort :: "+ Arrays.toString(a));

    }

    public static void sort(int[] a, int s, int e){

        if(s==e) return;
        
        int minIndex= midIndex(s, a);

        // swap minIndex and start
        int data = a[minIndex];
        a[minIndex] = a[s];
        a[s]=data;
        sort(a, ++s , e);

    }

    public static int midIndex(int s, int a[]){

        int temp= a[s];
        int minIndex =s;
        for(;s<a.length;s++){
            if(temp > a[s]){
                temp=a[s];
                minIndex=s;
            }

        }
        return minIndex;
    }


}
