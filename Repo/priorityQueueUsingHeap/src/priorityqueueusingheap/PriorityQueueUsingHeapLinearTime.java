//http://algs4.cs.princeton.edu/24pq/
package priorityqueueusingheap;

public class PriorityQueueUsingHeapLinearTime {
    
    private static int a[]={10,14,5,7,1,-1,8,12};
    private static int topindex=0;
    private static int maxHeap[]=new int[a.length+1];
     
    public static void main(String[] args) {
        
  //  System.out.println("Before HeapSort:");
  // printout();
   constructMaxHeap(); 
   printout();   
  // int inputValue=7;
  // System.out.println("Element less than "+inputValue + " are :: ");
   //findElementLessThanK(inputValue);
//   System.out.println("After HeapSort:");
//   heapSort();
   
   // System.out.println("Deleted number="+delMax());  
   //printout();   
    }
    
    public static void constructMaxHeap()
    {
      int i;
      
      maxHeap[0]=Integer.MIN_VALUE;
      
       for(i=0;i<a.length;i++)
       {
          maxHeap[i+1]=a[i];
          //insert(i);
          topindex++;
        //  System.out.println(maxHeap[i+1]+"  ");
       }
       sinkDownInLinearTime();
       
    }
    
    public static void sinkDownInLinearTime()
    {
        
        for(int l =(maxHeap.length-1)/2 ; l>0; l--)
        {
            sinkDownInLinearTime(l);
        }
    }
    
    public static void sinkDownInLinearTime(int i)
    {
        int p=i;
        int maxchild;
        //System.out.println("p " + p + " topindex " +topindex);
       // System.out.println("left " + getLeft(p));
       // System.out.println("rigth " + getRight(p));
       // System.out.println("parent " + maxHeap[p]);
        if(getRight(p)<=topindex)
        {
            
        while((getLeft(p)<=topindex || getRight(p)<=topindex ) && (maxHeap[getLeft(p)]>maxHeap[p] || maxHeap[getRight(p)]>maxHeap[p]))
        {
           //  System.out.println("inside while p = " +p);

            if(getRight(p)<=topindex)
            {
                if(maxHeap[getLeft(p)]>maxHeap[getRight(p)])
                {
                    maxchild=getLeft(p);
                }
                else
                    maxchild=getRight(p);
            }
            else

                   maxchild=getLeft(p);
           // System.out.println("max child " + maxchild);
            if(maxHeap[maxchild]>maxHeap[p])
            {
                int t=maxHeap[maxchild];
                maxHeap[maxchild]=maxHeap[p];
                maxHeap[p]=t;
                p=maxchild;
            }
            

            if(getRight(p)>topindex && getLeft(p)<=topindex)
            {
//                System.out.println("inside insider if " + p);
                if(maxHeap[p]<maxHeap[getLeft(p)])
                {
                    int k=maxHeap[getLeft(p)];
                    maxHeap[getLeft(p)]=maxHeap[p];
                    maxHeap[p]=k;

                }
                 break;
            }
        
           
        }
        }

        else 
        {
             maxchild=getLeft(p);

            if(maxHeap[maxchild]>maxHeap[p])
            {
                int t=maxHeap[maxchild];
                maxHeap[maxchild]=maxHeap[p];
                maxHeap[p]=t;
                p=maxchild;
            }
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
        sinkDownInLinearTime(1);
        
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
         System.out.println("Printing the heap");
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
     
     public static void findElementLessThanK(int value)
     {
         findElementLessThanKUtil(value, 1);
     }
     
     public static void findElementLessThanKUtil(int value, int rootIndex)
     {
         //System.out.println("rootIndex :: "+ rootIndex);
         if(rootIndex>topindex || rootIndex<1)
             return;
         
         if(maxHeap[rootIndex]<value)
             System.out.println(maxHeap[rootIndex]+ "");
         
         
         findElementLessThanKUtil(value, getLeft(rootIndex));
         findElementLessThanKUtil(value, getRight(rootIndex));
         
         
     }
    
}
