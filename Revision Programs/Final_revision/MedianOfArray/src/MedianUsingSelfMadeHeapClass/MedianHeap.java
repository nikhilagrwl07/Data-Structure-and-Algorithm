
package MedianUsingSelfMadeHeapClass;

class MedianHeap {
    public static int minHeap[];
    public static int maxHeap[];

    public static void main(String[] args) {

        int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        printMedian(A, A.length);

    }

    public static void printMedian(int a[],int  n)
    {
       minHeap right=new minHeap();
       MaxHeap left=new MaxHeap();
       int m=0;

       for(int i=0;i<n;i++)
       {
           m=getMedian(a[i], m, right, left);
           System.out.println("median  " +m);
       }



    }


    public static int getMedian(int e,int m,minHeap right,MaxHeap left)
    {
      //  System.out.println(" e  " +e);
        int len=compare(left.length(),right.length());
       // System.out.println("len " + len);
        switch(len)
        {
            case 0:
                if(e<m)
                {
                    left.insert(e);
                    m=left.getTop();
                }
                else
                {
                    right.insert(e);
                    m=right.getTop();
                }
                break;

            case -1:
                if(e<m)
                {
                    left.insert(e);
                }
                else
                {
                    left.insert(right.extractTop());
                    right.insert(e);
                }
              //  System.out.println("left top  " + left.getTop() + " right top " + right.getTop());
                 m=Average(left.getTop(), right.getTop());
                // System.out.println("m  " + m);
                break;

            case 1:

                if(e>m)
                {
                    right.insert(e);
                }
                else
                {
                    right.insert(left.extractTop());
                    left.insert(e);

                }
              //  System.out.println("left top  " + left.getTop() + " right top " + right.getTop());
                m=Average(left.getTop(), right.getTop());
               // System.out.println("m  " + m);
                break;
        }

        return m;
    }

    public static int Average(int a, int b)
    {
        return (a + b) / 2;
    }

    public static int compare(int a,int b)
    {
        if(a==b)
            return 0;
        return a<b?-1:1;
    }


}

class minHeap{
    int minHeap[];
    int topindex=0;
   // int i=1;

    public minHeap()
    {
        minHeap=new int[128];
        minHeap[0]=Integer.MAX_VALUE;
    }

    public int length()
    {
        return topindex;
    }

    public void insert(int p)
    {
        topindex++;
        minHeap[topindex]=p;
        
        swimUp(topindex);
       // i++;

    }

    public void swimUp(int i)
    {
        while(i/2>0 && minHeap[i/2]>minHeap[i])
        {
            int t=minHeap[i/2];
            minHeap[i/2]=minHeap[i];
            minHeap[i]=t;
            i=i/2;
        }
    }

    public int getTop()
    {
        return minHeap[1];
    }

    public int extractTop()
    {
        int r=minHeap[1];
        minHeap[1]=minHeap[topindex];
        topindex--;
        sinkDownMin();
       // i=topindex;
        return r;
    }

    public void sinkDownMin()
    {
        int p=1;
        int minchild;
        while((getLeft(p)<=topindex || getRight(p)<=topindex) && 
                (minHeap[getLeft(p)]<minHeap[p] || minHeap[getRight(p)]<minHeap[p]))
        {
            if(getRight(p)<=topindex)
            {
                if(minHeap[getLeft(p)]<minHeap[getRight(p)])
                {
                    minchild=getLeft(p);
                }
                else
                {
                    minchild=getRight(p);
                }
            }
            else
                minchild=getLeft(p);


            if(minHeap[minchild]<minHeap[p])
            {
                int t=minHeap[minchild];
                minHeap[minchild]=minHeap[p];
                minHeap[p]=t;
                p=minchild;
            }
        }
    }

    public int getLeft(int i)
    {
        return 2*i;
    }

    public int getRight(int i)
    {
        return 2*i+1;
    }

}

class MaxHeap{

    int maxHeap[];
    int topindex=0;
   // int i=0;

    public MaxHeap()
    {
        maxHeap=new int[128];
        maxHeap[0]=Integer.MIN_VALUE;
    }

     public int length()
    {
        return topindex;
    }

    public void insert(int p)
    {
        topindex++;
        maxHeap[topindex]=p;
        
        swimUp(topindex);
       // i++;

    }

    public void swimUp(int i)
    {
        while(i/2>0 && maxHeap[i/2]<maxHeap[i])
        {
            int t=maxHeap[i/2];
            maxHeap[i/2]=maxHeap[i];
            maxHeap[i]=t;
            i=i/2;
        }
    }

    public int getTop()
    {
        return maxHeap[1];
    }

     public int getLeft(int i)
    {
        return 2*i;
    }

    public int getRight(int i)
    {
        return 2*i+1;
    }

     public int extractTop()
    {
        int r=maxHeap[1];
        maxHeap[1]=maxHeap[topindex];
        topindex--;
        sinkDown();
       // i=topindex;
        return r;
    }

    public void sinkDown()
    {
        int p=1;
        int maxchild;
        while((getLeft(p)<=topindex || getRight(p)<=topindex) && (maxHeap[getLeft(p)]>maxHeap[p] || maxHeap[getRight(p)]>maxHeap[p]))
        {
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

            if(maxHeap[maxchild]>maxHeap[p])
            {
                int t=maxHeap[maxchild];
                maxHeap[maxchild]=maxHeap[p];
                maxHeap[p]=t;
                p=maxchild;
            }
        }
    }
}