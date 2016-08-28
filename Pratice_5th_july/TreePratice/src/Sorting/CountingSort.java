
package Sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
         int a[]={1,7,3,6,3,9,9,9,9,9,1,1,1,1,5,5,5,50,2,2,2,2,4,4,4,4,7,7,7,34,5,27,12,77,23,78,65,34,71,45};
        int b[]=new int[a.length];
        int k=100;

        System.out.println("Before counting sort :: "+ Arrays.toString(a) );
        countingSort(a, b, k);
    System.out.println("after counting sort :: "+ Arrays.toString(b) );

    }

    public static void countingSort(int[] input , int[] output , int range ){

        int frequncy[] = new int[range];

        for(int i=0;i<range;i++)
            frequncy[i]=0;

        for(int i=0;i<input.length; i++){
            frequncy[input[i]] = frequncy[input[i]]+1;
        }
        // cumulative frequency
        for(int i=1;i<range;i++){
            frequncy[i] += frequncy[i-1];
        }
          
        for(int j=0;j<input.length;j++){
               output[--frequncy[input[j]]]=input[j];
        }
    }

}
