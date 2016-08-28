
package kthsmallestelement;

import java.util.Arrays;


public class KthSmallestElement {

    public static void main(String[] args) {
       
        // taking unsorted array intentionally
        int a[]={50,30,60,40,10,20,70,100};
        
        System.out.println("Initial array= "+Arrays.toString(a));
        
        int k=2;
        
       findKthSmallestElement(a,k);
        
      // findMedian(a);
        
        System.out.println("After array= "+Arrays.toString(a));
    }
    
    public static void findMedian(int a[])
    {
        int N;
        
            if(a.length%2==0)
               N=(a.length/2);
            else
                N=a.length/2+1;


            int median=selectionAlgo(a,0,a.length-1,N);
        
        System.out.println("Median= "+median);
        
    }
    
    public static void findKthSmallestElement(int a[],int kth)
    {
          
        int kthsmallest=selectionAlgo(a,0,a.length-1,kth);
        
         System.out.println(kth+"th smallest element= "+kthsmallest);
        
         int nMinuskthsmallest=selectionAlgo(a,0,a.length-1,a.length-kth+1);
         
         System.out.println(kth+"th largest element= "+nMinuskthsmallest);
    }
    
    public static int selectionAlgo(int a[],int left,int right,int kth)
    {
        if(left>right ||kth>a.length)
            return -1;
        
        if(left==right)
            return a[left];
        
        if(left==right-1)
            return (a[left]+a[right])/2;
            
        while(true)
        {
            int pivotIndex=partition(a,left,right);
            
           // System.out.println("PivotIndex = "+pivotIndex);
            
            int len=pivotIndex-left+1;
            
            if(kth==len)
                return a[pivotIndex];
            else if(kth<len)
                right=pivotIndex-1;
            else
            {
                kth=kth-len;
                left=pivotIndex+1;
            }
        }
        
    }
    
    public static int partition(int a[],int l ,int r)
    {
        int pivot=a[r],i=l-1;
        
        for(int j=l;j<=r-1;j++)
        {
            if(a[j]<=pivot && i!=j)
            {
                i++;
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }
        
        int t=a[i+1];
        a[i+1]=a[r];
        a[r]=t;
        
        return i+1;
        
    }
}
