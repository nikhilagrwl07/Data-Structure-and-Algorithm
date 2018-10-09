
package priorityqueueusingheap;


// Java program for implementation of Heap Sort
public class MinHeapSortNew
{
    public void sort(int arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int smalltest = i;  // Initialize smalltest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[smalltest])
            smalltest = l;
 
        // If right child is larger than smalltest so far
        if (r < n && arr[r] > arr[smalltest])
            smalltest = r;
 
        // If smalltest is not root
        if (smalltest != i)
        {
            int swap = arr[i];
            arr[i] = arr[smalltest];
            arr[smalltest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, smalltest);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
 
    // Driver program
    public static void main(String args[])
    {
        int arr[] = {10,14,5,7,1,-1,0,0,0,12};
        int n = arr.length;
 
        MinHeapSortNew ob = new MinHeapSortNew();
        ob.sort(arr);
 
        System.out.println("Sorted array is");
        printArray(arr);
    }
}