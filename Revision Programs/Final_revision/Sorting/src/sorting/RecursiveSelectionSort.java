
package sorting;

import java.util.Arrays;

public class RecursiveSelectionSort {

    public static void main(String[] args) {
        int arr[]={10,5,50,6,20,89,-1};
        int i;
        int l=arr.length;
        
        System.out.println("before:\n " +Arrays.toString(arr));   
        recursiveSelectionSort(arr,0,l-1);
        
        System.out.println("After :\n " +Arrays.toString(arr));   
      
    }

        // recursive version
    public static void recursiveSelectionSort(int n[],int s,int e)
    {
        if(s==e)
            return ;
        
        //call mindIndex function to obtain the minmum
        int m=minIndex(n,s);
        int i;
        // swap n[m] with n[s]
        int t=n[m];
        n[m]=n[s];
        n[s]=t;
  
        recursiveSelectionSort(n,++s,e);
        
    }
    
    public static int minIndex(int n[],int s)
    {
        int i,temp=Integer.MAX_VALUE,index=0;
        
        for(i=s;i<n.length;i++)
        {
            if(temp > n[i])
            {
                index=i;
                temp=n[i];
            }
        }
        return index;
    }
    
}