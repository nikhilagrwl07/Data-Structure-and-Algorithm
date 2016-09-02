
package prim_mst_heap;

// A structure to represent a node in adjacency list
 class AdjListNode
{
    int dest;
    int weight;
    AdjListNode next=null;
    
    // A utility function to create a new adjacency list node
    public AdjListNode(int dt,int wt)
    {
      //  AdjListNode newNode=new AdjListNode();
        dest=dt;
        weight=wt;
        next=null;
        
        //return newNode;
    }
}

// A structure to represent an adjacency list
class AdjList
{
    AdjListNode head; // pointer to head of the node
}

// A structure to represent a graph. A graph is an array of adjacency lists.
// Size of array will be V (number of vertices in graph)
class Graph
{
    int V;
    AdjList array[];
    
    // A utility function that creates a graph of V vertices
    public Graph createGraph(int V)
    {
        Graph graph=new Graph();
        graph.V=V;
        
        // Create an array of adjacency lists.  Size of array will be V
        graph.array=new AdjList[V];
        
        
         // Initialize each adjacency list as empty by making head as NULL
        for (int i = 0; i < V; ++i)
            graph.array[i].head = null;
    
    return graph;
    }
    
    // Adds an edge to an undirected graph
    public void addEdge(Graph graph,int src,int dest,int weight)
    {
        // Add an edge from src to dest.  A new node is added to the adjacency
    // list of src.  The node is added at the begining
        AdjListNode newNode=new AdjListNode(dest, weight);
        newNode.next=graph.array[src].head;
        graph.array[src].head=newNode;
        
        // Since graph is undirected, add an edge from dest to src also
            newNode = new AdjListNode(src, weight);
        newNode.next = graph.array[dest].head;
        graph.array[dest].head = newNode;
        
    }
}
    // Structure to represent a min heap node
    class MinHeapNode
    {
        int  v;
        int key;
    }

// Structure to represent Min Heap
    class MinHeap
    {
        int size;      // Number of heap nodes present currently
        int capacity;  // Capacity of min heap
        int pos;     // This is needed for decreaseKey()
        MinHeapNode array[];
        
        // A utility function to create a new Min Heap Node
        public MinHeapNode MinHeap(int v,int key)
        {
            MinHeapNode newNode=new MinHeapNode();
            newNode.v=v;
            newNode.key=key;
            
            return newNode;
        }
        
        public MinHeap(int capacity)
        {
            //MinHeap minHeap=new MinHeap();
            pos=capacity;
            size=0;
            this.capacity=capacity;
            this.array=new MinHeapNode[capacity];
        }
        
        public void swapMinHeapNode(MinHeapNode a,MinHeapNode b)
        {
            MinHeapNode t=a;
            a=b;
            b=t;
        }
    }

public class Prim_MST_Heap {

    public static void main(String[] args) {
        // TODO code application logic here
    }
}
