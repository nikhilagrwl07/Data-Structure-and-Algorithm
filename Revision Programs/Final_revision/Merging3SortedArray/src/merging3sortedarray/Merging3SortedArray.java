/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package merging3sortedarray;

public class Merging3SortedArray {
    
    private static int minHeap[]; //=new int[a.length+1];
    
     private static int a[] = {30, 40, 50};
       private static  int b[]={35, 45} ;
      private static   int c[] = {10, 60, 70, 80, 100};
      private static int topindex=0;
        
     public static void main(String[] args) {
        
        merge3Array(a, b, c);
        
    }
     
     
  
         
     public static void merge3Array(int[] a, int[] b , int[] c)
     {
         int i=0,j=0,k=0;
         System.out.println("Merged Array Output ::: ");
         int min = 0;
         boolean flag =false;
         minHeap=new int[4];
         minHeap[0]=Integer.MAX_VALUE;
         
         int[] temp = new int[3];
         temp[0]=a[0];
         temp[1]=b[0];
         temp[2]=c[0];
         
        constructMinHeap(temp);
        printout();
        
        boolean A=true, B = true, C=true;
        
         while(true)
         {
            int p = minHeap[1];
            if(p==a[i] && A)
            {
                if(i<=a.length-2 )
                {
                    i++;
                    
                minHeap[1]=a[i];
                sinkdown();
                }
                else if(i==a.length-1)
                {
                    A=false;
                    // TODO:: 
                }
                
            }
            
            else if(p==b[j] && B)
            {
                if(j<=b.length-2 )
                {
                    j++;
                    
                minHeap[1]=b[j];
                sinkdown();
                }
                else if(j==b.length-1)
                {
                    B=false;
                    // TODO:: 
                }
                
            }
            
            else if(p==c[k] && C)
            {
                if(k<=c.length-2 )
                {
                    k++;
                    
                minHeap[1]=c[k];
                sinkdown();
                }
                else if(k==c.length-1)
                {
                    C=false;
                    // TODO:: 
                }
                
            }
            if(A==false)
            {
                if(B && C)
                {
                    if(b[j]<c[k])
                    {
                        minHeap[1]=b[j];
                        j++;
                         sinkdown();
                    }
                    else
                    {
                        
                    }
                }
                if(B && !C)
                {
                    
                }
                if(!B && C)
                {
                    
                }
            }
            
            
             
             
         }
         
           
         
     }
     
    
     
    public static void constructMinHeap(int[] temp)
    {
      int i;
       for(i=0;i<a.length;i++)
       {
          insert(i , temp);
          topindex++;
       }
       
       
    }
    
        
     public static void printout()
     {
          int i;
          System.out.println("Heap printout  ::: ");
    // show the max Heap constructed
        for(i=1;i<=topindex;i++)
         System.out.print(minHeap[i]+"  ");
        
         System.out.println();
     }
     
     
     
    public static void insert(int i ,int[] a)
    {
        
        if(i==0)
        {
          minHeap[i+1]=a[i];
        }
        
        else
        {
            // swim up 
            swimUp(i+1, a);
        }
        
    }
       
    public static void swimUp(int p ,int[] a)    
    {
        minHeap[p]=a[p-1];
        
        while(p/2 > 0 && minHeap[p/2] > minHeap[p])
        {
            // swap minHeap[p/2]<minHeap[p]
            int t=minHeap[p/2];
            minHeap[p/2]=minHeap[p];
            minHeap[p]=t;
            
            p=p/2;
        }
    }
     
     
  
    public static void sinkdown()
    {
        int p=1;
        int minchild;
       while( (getRight(p)<=topindex || getLeft(p)<=topindex) && ( (minHeap[getLeft(p)]<minHeap[p]) || (minHeap[getRight(p)]<minHeap[p])) )
       {
           if(getRight(p)<=topindex)
           {               
               if(minHeap[getLeft(p)] < minHeap[getRight(p)])
                   minchild=getLeft(p);
               else
                    minchild=getRight(p);
           }
           else
           {
                minchild=getLeft(p);
           }
           
           if(minHeap[minchild]<minHeap[p])
           {
             int t=minHeap[minchild];
             minHeap[minchild]=minHeap[p];
             minHeap[p]=t;
             p=minchild;
           }
       }
    }
    
      public static int getLeft(int i)
    {
        return 2*i;
    }

    public static int getRight(int i)
    {
        return 2*i + 1;
    }
     
     public static void printArray(int[] p , int s , int d)
     {
         for(int i=s;i<=d;i++)
         {
             System.out.print(p[i]+ " ");
         }
     }
     
     public static int minElement(int a , int b , int c)
     {
         
         if(a<b)
         {
             if(a<c)
                 return a;
             else
                 return c;
         }
         else
         {
             if(b<c)
                 return b;
             else
                 return c;
         }
     }


}

