
package nearlysortedarray_heap;

import java.util.Arrays;

class MinHeap
{
    int harr[]; // pointer to arrays element in array
    int heap_size; // size of heap
    
    // to get index of left child of node at index i
    int left(int i) { return (2*i + 1); }
 
    // to get index of right child of node at index i
    int right(int i) { return (2*i + 2); }
 
    
    public MinHeap(int a[],int size)
    {
        heap_size=size;
        harr=a; // stores the addrress of array
        
        int i=(heap_size-1)/2;
        while(i>=0)
        {
            MinHeapify(i);
            i--;
        }
    }
    
    // Method to remove minimum element from the heap
    public int extractMin()
    {
        int root=harr[0];
        
        if(heap_size>1)
        {
            harr[0]=harr[heap_size-1];
            heap_size--;
            MinHeapify(0);
        }
        
        return root;
    }
    
    // method to replace root with x and return the old element
    public int replaceMin(int x)
    {
        int root=harr[0];
        harr[0]=x;
        
        if(x>root)
            MinHeapify(0);
        
        return root;
    }
    
    // A recursive method to minHeapify the Min Heap at given index
    // this method assumes that the Tree is already minHeap
    public void MinHeapify(int i)
    {
        int l=left(i);
        int r=right(i);
        
        int smallest =i;
        
        if(l<heap_size && harr[l]<harr[smallest])
            smallest=l;
        
        if(r<heap_size && harr[r]<harr[smallest])
            smallest=r;
        
        
        if(smallest!=i)
        {
            swap(harr,smallest,i);
            MinHeapify(smallest);
        }
    }
    
  
    public void swap(int a[],int b,int c)
    {
        int t=a[b];
        a[b]=a[c];
        a[c]=t;
    }
    

      
    public void findKthSmallestElement(int k)
    {
        
        if(k>heap_size || k<=0)
        {
            System.out.println("NOT possible");
            return;
        }
        int x=-1;
        for(int i=k;i>=1;i--)
        {
             x=extractMin();
        }
        
        System.out.println(k+"th smallest element= "+x);
    }
}



public class NearlySortedArray_Heap {

      // given an array with n elements ,each element is K units aways
    // from its correct position. Sort the array in O(nlogk) times    
    public void sortK(int a[],int k)    
    {
        int N=a.length;
         // Create a Min Heap of first (k+1) elements from
    // input array
        
    int heapArray[] = new int[k+1];
        
    // filling heapArray with first k+1 elements 
    for(int i=0;i<=k &&i<N;i++)  // i<N condition is needed for case k>n
    {
        heapArray[i]=a[i];
    }
    
    MinHeap hp=new MinHeap(heapArray, k+1);
    
     // i is index for remaining elements in arr[] and ti
    // is target index of for cuurent minimum element in
    // Min Heapm 'hp'.
    for(int i = k+1, ti = 0; ti < N; i++, ti++)
    {
        // If there are remaining elements, then place
        // root of heap at target index and add arr[i]
        // to Min Heap
        if (i < N)
            a[ti] = hp.replaceMin(a[i]);
 
        // Otherwise place root at its target index and
        // reduce heap size
        else
            a[ti] = hp.extractMin();
    }
    
    }
    
    public void printArray(int a[],String s)
    {
        System.out.println(s);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+"  ");
        
        System.out.println();
    }
  
    
    
    public static void main(String[] args) {
       
        
        NearlySortedArray_Heap ob=new NearlySortedArray_Heap();
        
        int k=3;
        int arr[] = {2, 6, 3, 12, 56, 8};
        
        
        ob.printArray(arr,"Nearly Unsorted Array");
        ob.sortK(arr,k);
        
        ob.printArray(arr,"Sorted Array");
        
        
        
        // Finding kth smalles element of an array using heap(competition with partition algo)
        
         int a[]={50,30,60,40,10,20,70,100};
         
          System.out.println("Initial array= "+Arrays.toString(a));
          
         MinHeap mP=new MinHeap(a, a.length);
         
         int kth=7;
         
         mP.findKthSmallestElement(kth);
        
    }
}
