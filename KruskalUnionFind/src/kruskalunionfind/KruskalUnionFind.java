
package kruskalunionfind;

// Source: http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
class Edge
{
    int src,dest,weight;
}

class Graph
{
     // V-> Number of vertices, E-> Number of edges
    int V, E;
    
    // graph is represented as an array of edges. Since the graph is
    // undirected, the edge from src to dest is also edge from dest
    // to src. Both are counted as 1 edge here.
    Edge edge[]=null;
    
    public void createGraph(int v,int e)
    {
        Graph g=new Graph();
        V=v;
        E=e;
        edge=new Edge[e];        
        
        for(int i=0;i<e;i++)
            edge[i]=new Edge();
    }
}

// structure to represent a subset for union-find
class subset
{
    int parent;
    int rank;    
    
    // A utility function to find set of an element i
// (uses path compression technique)
    int find(subset subsets[],int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
        {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        
        return subsets[i].parent;
    }
    
    
    // A function that does union of two sets of x and y
// (uses union by rank)
void Union( subset subsets[], int x, int y)
{
    int xroot = find(subsets, x);
    int yroot = find(subsets, y);
 
    // Attach smaller rank tree under root of high rank tree
    // (Union by Rank)
    if (subsets[xroot].rank < subsets[yroot].rank)
        subsets[xroot].parent = yroot;
    else if (subsets[xroot].rank > subsets[yroot].rank)
        subsets[yroot].parent = xroot;
 
    // If ranks are same, then make one as root and increment
    // its rank by one
    else
    {
        subsets[yroot].parent = xroot;
        subsets[xroot].rank++;
    }
}


}

public class KruskalUnionFind {

    static void srtEdge(Edge[] e)
    {
        int min=-1;
     for(int i=0;i<e.length-1;i++)   
     {
         int p=e[i].weight;
         
         for(int j=i;j<e.length;j++)
         {
             if(p>e[j].weight)
                 min=j;                 
             
         }
          // swap two edge objects
                 Edge temp;
                 temp=e[i];
                 e[i]=e[min];
                 e[min]=temp;
     }
        
    }
    // The main function to construct MST using Kruskal's algorithm
 static void KruskalMST(Graph g)
 {
     int V=g.V;
     Edge result[]=new Edge[V];  // This will store resultant MST
     
      int e = 0;  // An index variable, used for result[]
    int i = 0;  // An index variable, used for sorted edges
 
   
//    System.out.println("Before sorting:");
//    for(int j=0;j<g.E;j++)
//        System.out.print(g.edge[j].weight+"  ");
//    
//     System.out.println();   
   
     
     srtEdge(g.edge);   
    
//     System.out.println("After sorting:");
//      for(int j=0;j<g.E;j++)
//        System.out.print(g.edge[j].weight+"  ");
//    
//     System.out.println();
     
     
    
    subset s[]=new subset[V];
      // Create V subsets with single elements
    for (int v = 0; v < V; ++v)
    {
        s[v]=new subset();
        
        s[v].parent = v;
        s[v].rank = 0;
    }
 
    subset ob=new subset();
    // Number of edges to be taken is equal to V-1
    while(e<V-1)    
    {        
           Edge next_edge=g.edge[i++];
           int x=ob.find(s,next_edge.src);
           int y=ob.find(s,next_edge.dest);
           
           // If including this edge does't cause cycle, include it
        // in result and increment the index of result for next edge
        if (x != y)
        {
            result[e++] = next_edge;
            ob.Union(s, x, y);            
        }
        // Else discard the next_edge
    }
    
      // print the contents of result[] to display the built MST
    System.out.println("Following are the edges in the constructed MST");
    
    for(i=0;i<e;i++)
        System.out.println(result[i].src+"  "+result[i].dest+"  "+result[i].weight);
 
 
 }
    public static void main(String[] args) {
        /* Let us create following weighted graph
             10
        0--------1
        |  \     |
       6|   5\   |15
        |      \ |
        2--------3
            4       */
    int V = 4;  // Number of vertices in graph
    int E = 5;  // Number of edges in graph
     Graph g= new  Graph();
     g.createGraph(V, E);
     
      // add edge 0-1
    g.edge[0].src = 0;
    g.edge[0].dest = 1;
    g.edge[0].weight = 10;
    
    
     // add edge 0-2
    g.edge[1].src = 0;
    g.edge[1].dest = 2;
    g.edge[1].weight = 6;
 
    // add edge 0-3
    g.edge[2].src = 0;
    g.edge[2].dest = 3;
    g.edge[2].weight = 5;
 
    // add edge 1-3
    g.edge[3].src = 1;
    g.edge[3].dest = 3;
    g.edge[3].weight = 15;
 
    // add edge 2-3
    g.edge[4].src = 2;
    g.edge[4].dest = 3;
    g.edge[4].weight = 4;
    
    KruskalMST(g);
    
    }
}
