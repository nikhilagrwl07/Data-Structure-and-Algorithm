
package minheap;

public class Main {

    public static void main(String[] args) {
     int arr[] = {10,14,5,7,1,-1,8};
     System.out.println("Before Building Heap !!!! ");
     for(int i=0 ; i<arr.length ; i++)
     {
         System.out.print(arr[i] + "   ");
     }
     System.out.println();
     MaxHeap heap = new MaxHeap();
     heap.buildMaxHeap(arr.length + 1 , arr);
     MaxHeap.printOut("After building max Heap");
     System.out.println("Heap Sort !!!! ");
     heap.HeapSort();

    }

}

class MaxHeap
{
    static  int HeapArray[];
    static int topIndex =0 ;

    int left(int index){
        return 2*index;
    }

    int right(int index){
        return 2*index + 1;
    }

    public void buildMaxHeap(int heapSize, int inputArray[])
    {
        topIndex = heapSize-1;
       // HeapArray = minHeap;
        HeapArray = new int[heapSize];

        // giving constant value to 0th element
        HeapArray[0]= Integer.MIN_VALUE;

        // copying the Heaparray from inputArray
        for(int i =1 ;i< heapSize; i++)
        {
            HeapArray[i]=inputArray[i-1];
        }

        int indexMaxHeap = heapSize -1;

        // sinkUp for each element
        while(indexMaxHeap > 0)
        {
            sinkUp(indexMaxHeap);
            indexMaxHeap--;
        }

    }

    public void sinkUp(int indexMaxHeap)
    {
        while(indexMaxHeap/2 > 0 && HeapArray[indexMaxHeap/2] < HeapArray[indexMaxHeap])
        {
            swap(indexMaxHeap, indexMaxHeap/2);
            indexMaxHeap = indexMaxHeap/2;
        }
    }

    public void HeapSort()
    {
        // taking out 1st element and replacing with last element
        // calling each time sinkDown()

        while(topIndex>0)  // Complexity = O(nlogn)
        {
            System.out.print(HeapArray[1] + "   ");
            HeapArray[1] = HeapArray[topIndex];
            topIndex--;
            sinkDown(1);

        }
    }

    public void sinkDown(int index)
    {
        int maxChildIndex;
        while((right(index) <= topIndex || left(index) <= topIndex ) && ((HeapArray[right(index)] > HeapArray[index]) || (HeapArray[left(index)] > HeapArray[index])))
        {
            if(HeapArray[right(index)] > HeapArray[index])
            {
                if(HeapArray[right(index)] > HeapArray[left(index)])
                {
                    maxChildIndex = right(index);
                }
                else
                {
                     maxChildIndex = left(index);
                }
            }
            else
            {
              maxChildIndex = left(index);
            }
            
            if(HeapArray[maxChildIndex] > HeapArray[index])
            {
                swap(index, maxChildIndex);
                index = maxChildIndex;
            }
        }
    }


    public void swap(int a, int b)
    {
        int t = HeapArray[a];
        HeapArray[a]= HeapArray[b];
        HeapArray[b]= t;
    }

    public static void printOut(String s)
    {
        System.out.println(s);
        for(int i=1 ; i< HeapArray.length;i++)
            System.out.print(HeapArray[i]+"   ");

        System.out.println();
    }

}