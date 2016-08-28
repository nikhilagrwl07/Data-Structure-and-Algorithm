
package priorityqueueusingheap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KMinimumElementInStream {

    private static int a[];
    private static int topindex=0;
    private static int maxHeap[]; //=new int[a.length+1];
     
    public static void main(String[] args) {
        try {

            //  System.out.println("Before HeapSort:");
            //printout();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //  String str = br.readLine();
            System.out.println("Please enter length of arrray :: ");

            int len = Integer.valueOf(br.readLine()).intValue();

            a= new int[len];
            maxHeap = new int[a.length+1];   
            maxHeap[0]=Integer.MIN_VALUE;
            int indexOfarray = 0;
            
            while(true)
            {
                  System.out.println("Start entering value in input array  :: ");
                  
                int val = Integer.valueOf(br.readLine()).intValue();
                  if(indexOfarray>=0 && indexOfarray <len)
                  {
                      a[indexOfarray]=val;
                      
                      insert(indexOfarray);
                      
                      indexOfarray++;
                        topindex++;
                  }
                  else
                  {
                     if(val>maxHeap[1])
                    {
                        System.out.println("Entered value is greater than max value..");
                    }
                    else
                    {
                        maxHeap[1]=val;
                        sinkdown();
                    }
                  }
                
                printout();
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(KMinimumElementInStream.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public static void constructMaxHeap()
    {
      int i;
      
       for(i=0;i<a.length;i++)
       {
          insert(i);
          topindex++;
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
          System.out.println(" Printing maxHeap \n ");
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
