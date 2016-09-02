//http://algs4.cs.princeton.edu/24pq/
package priorityqueueusingheap;

public class PriorityQueueUsingHeap {
    
    private static int a[]={10,14,5,7,1,-1,8};
    private static int topindex=0;
    private static int maxHeap[]=new int[a.length+1];
     
    public static void main(String[] args) {
        
   // System.out.println("Before HeapSort:");
    //printout(); 
   constructMaxHeap(); 
   printout();   
   System.out.println("After HeapSort:");
   heapSort();
   
   // System.out.println("Deleted number="+delMax());  
   //printout();   
    }
    
    public static void constructMaxHeap()
    {
      int i;
      maxHeap[0]=Integer.MIN_VALUE;
      
       for(i=0;i<a.length;i++)
       {
          insert(i);
          topindex++;
        //  System.out.println(maxHeap[i+1]+"  ");
       }
       
       
    }
    
    public static void insert(int i)
    {
        
        if(i==0)
        {
          maxHeap[i+1]=a[i];
        }
        
        else
        {
            // swim up 
            swimUp(i+1);
        }
        
    }
    
    public static void swimUp(int p)    
    {
        maxHeap[p]=a[p-1];
        
        while(p/2 > 0 && maxHeap[p/2] < maxHeap[p])
        {
            // swap maxHeap[p/2]<maxHeap[p]
            int t=maxHeap[p/2];
            maxHeap[p/2]=maxHeap[p];
            maxHeap[p]=t;
            
            p=p/2;
        }
    }
    
    public static int delMax()
    {
        
        int r=maxHeap[1];
        maxHeap[1]=maxHeap[topindex];
        topindex--;
        // call sink down function
        sinkdown();
        
        return r;
    }

    public static int getLeft(int i)
    {
        return 2*i;
    }

    public static int getRight(int i)
    {
        return 2*i + 1;
    }
    public static void sinkdown()
    {
        int p=1;
        int maxchild;
       while( (getRight(p)<=topindex || getLeft(p)<=topindex) && ( (maxHeap[getLeft(p)]>maxHeap[p]) || (maxHeap[getRight(p)]>maxHeap[p])) )
       {
           if(getRight(p)<=topindex)
           {               
               if(maxHeap[getLeft(p)] > maxHeap[getRight(p)])
                   maxchild=getLeft(p);
               else
                    maxchild=getRight(p);
           }
           else
           {
                maxchild=getLeft(p);
           }
           
           if(maxHeap[maxchild]>maxHeap[p])
           {
             int t=maxHeap[maxchild];
             maxHeap[maxchild]=maxHeap[p];
             maxHeap[p]=t;
             p=maxchild;
           }
       }
    }
    
     public static void printout()
     {
          int i;
    // show the max Heap constructed
        for(i=1;i<=topindex;i++)
         System.out.print(maxHeap[i]+"  ");
        
         System.out.println();
     }
     
     
     public static void heapSort()
     {
         while(topindex>0)
         {
            System.out.print(delMax()+"  ");  
             
         }
     }
    
}
