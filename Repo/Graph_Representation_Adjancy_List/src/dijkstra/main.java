/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dijkstra;

/**
 *
 * @author admin
 */
class main {

    public static void main(String[] args) {

//
//         int V = 9;
//     Graph graph = new Graph(V);
//    graph.addEdge(0, 1, 4);
//    graph.addEdge(0, 7, 8);
//    graph.addEdge(1, 2, 8);
//    graph.addEdge(1, 7, 11);
//    graph.addEdge(2, 3, 7);
//    graph.addEdge(2, 8, 2);
//    graph.addEdge(2, 5, 4);
//    graph.addEdge(3, 4, 9);
//    graph.addEdge( 3, 5, 14);
//    graph.addEdge(4, 5, 10);
//    graph.addEdge(5, 6, 2);
//    graph.addEdge(6, 7, 1);
//    graph.addEdge( 6, 8, 6);
//    graph.addEdge( 7, 8, 7);
////
//    dijkstra(graph, 0);

        int V=6;
        Graph g =new Graph(V);
             g.addEdge(1, 2,1);
     //g.addEdge(1, 3,4);
     g.addEdge(3, 1, 10);
     g.addEdge(2, 3,3);
    g.addEdge(2, 4, 2);
//     g.addEdge(4, 2, 1);
     g.addEdge(4, 3, 5);
     g.addEdge(2, 5, 2);
     g.addEdge(5, 4, 3);
     dijkstra(g, 1);





    }

    public static void decreasekey(MinHeap minHeap,int v,int dist)
    {
        int i=minHeap.pos[v];
        minHeap.heap[i].dist=dist;
        while(i>0 && minHeap.heap[i].dist<minHeap.heap[(i-1)/2].dist)
        {
            minHeap.pos[minHeap.heap[i].v]=(i-1)/2;
            minHeap.pos[minHeap.heap[(i-1)/2].v]=i;
            Node m=minHeap.heap[i];
            minHeap.heap[i]=minHeap.heap[(i-1)/2];
            minHeap.heap[(i-1)/2]=m;
            i=(i-1)/2;
        }
    }
    
    
    public static Node extractMin(MinHeap m)
    {
        if(m.size==0)
            return null;
        
        Node root=m.heap[0];
        Node lastNode=m.heap[m.size-1];
        m.heap[0]=lastNode;
        m.pos[root.v]=m.size-1;
        m.pos[lastNode.v]=0;
        --m.size;
        sinkDownMin(m, 0);
        
        return root;
    }

     public static void sinkDownMin(MinHeap m,int index)
    {
        int p=index;
        int minchild;
        int topminidx=m.size-1;

        while((getLeft(p)<=topminidx|| getRight(p)<=topminidx) && (m.heap[getLeft(p)].dist<m.heap[p].dist || m.heap[getRight(p)].dist<m.heap[p].dist))
        {
            if(getRight(p)<=topminidx)
            {
                if(m.heap[getLeft(p)].dist<m.heap[getRight(p)].dist)
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


            if(m.heap[minchild].dist<m.heap[p].dist)
            {
                m.pos[m.heap[minchild].v]=p;
                m.pos[m.heap[p].v]=minchild;
                Node  t = m.heap[minchild];
                m.heap[minchild]=m.heap[p];
                m.heap[p]=t;
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
        return 2*i+1;
    }

    // A utility function to check if a given vertex
// 'v' is in min heap or not
    public static boolean isInMinHeap(MinHeap minHeap, int v)
{
   if (minHeap.pos[v] < minHeap.size)
     return true;
   return false;
}


    public static void dijkstra(Graph g,int s)
    {
        int V=g.V;
        int dist[]=new int[V];

        MinHeap m=new MinHeap(V);
        for(int i=0;i<V;i++)
        {
            dist[i]=Integer.MAX_VALUE;
            m.heap[i]=new Node(i,dist[i]);
            m.pos[i]=i;
        }

        m.heap[s]=new Node(s,dist[s]);
        m.pos[s]=s;
        dist[s]=0;
        decreasekey(m, s, dist[s]);

        m.size=V;

        while(m.size!=0)
        {
            Node n=extractMin(m);
            int u=n.v;

            AdjListNode temp=g.array[u].head;
            while(temp!=null)
            {
                int d=temp.vertexNumber;
               // System.out.println("destination  " + temp.vertexNumber);
                if(isInMinHeap(m, d) && dist[u]!=Integer.MAX_VALUE && temp.weight+dist[u]<dist[d])
                {
                    dist[d]=dist[u]+temp.weight;
                   // System.out.println("distance " + dist[v]);
                    decreasekey(m, d, dist[d]);
                }
                temp=temp.next;

            }

        }

        pritnArray(dist, V);
    }


    public static void pritnArray(int dist[],int v)
    {
        for(int i=0;i<v;i++)
        {
            System.out.println("i " + i + " -----> " + dist[i]);
        }
    }

}


