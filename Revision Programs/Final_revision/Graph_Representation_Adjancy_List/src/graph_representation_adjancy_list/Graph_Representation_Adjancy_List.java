
package graph_representation_adjancy_list;

// adjancy list Node class

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


// adjnacy list Node class
class AdjListNode
{
    int dest;
    AdjListNode next;

        public AdjListNode()
        {            
        }
    // creating new adjancy list node
    public AdjListNode(int d) {
        dest=d;
        
        next=null;
    }
    
}

// adjnacy list class
class AdjList
{
    AdjListNode head; // pointer to head node of the list
}

// A structure to represent a graph. A graph is an array of adjacency lists.
// Size of array will be V (number of vertices in graph)

class Graph
{
    int V;
    AdjList[] array;

    public Graph(int v) {
        V=v;
        // create an array of adjancey list . Size of the list is V
        array=new AdjList[V];
//        
        for(int i=0;i<V;i++)
        {
            array[i]=new AdjList();
            array[i].head=null;
            
        }
    }
    
    // Add edge to an undirected graph
    public void addEdge(int s,int d)
    {
     // Add an edge from src to dest.  A new node is added to the adjacency
    // list of src.  The node is added at the begining
        
        AdjListNode newNode=new AdjListNode(d);
        newNode.next=array[s].head;
        array[s].head=newNode;

//        if(s!=d)
//        {
//         //Case 1 : UnDirected graph
//        newNode= new AdjListNode(s);
//        newNode.next=array[d].head;
//        array[d].head=newNode;
//        }
        // Case 2 : Directed Graph
    // Since graph is directed, NO NEED TO ADD an edge from dest to src also
//        newNode= new AdjListNode(s);
//        newNode.next=array[d].head;
//        array[d].head=newNode;

    }
    
    public void printGraph()
    {
        int v;
        for(v=1;v<V;v++)
        {
            AdjListNode pCrawl=array[v].head;
            System.out.print("Adjancey list of vertex: "+v+" \nhead");
            while(pCrawl!=null)
            {
                System.out.print(" -> "+pCrawl.dest);
                pCrawl=pCrawl.next;
            }
            
            System.out.println();
        }
    }
    
    
    public void BFS(int source)
    {
        System.out.println("Breadth First traversal starting at "+source);
        int i;
        // MArk all vertices to be unvisited
        boolean[] visited= new boolean[V];
        
        for(i=0;i<V;i++)
        {
            visited[i]=false;
        }
        
        // creating queue for BFS
        Queue<Integer> q=new LinkedList();
        
        visited[source]=true;
        
        q.add(source);
        
        while(!q.isEmpty())
        {
            // dequeue a vertex  from queue and print it
           source=q.remove();
           
           System.out.print(source+"  ");
           
           // Get all adjacent vertices of the dequeued vertex source
        // If a adjacent has not been visited, then mark it visited
        // and enqueue it
          
         AdjList p=array[source];
         AdjListNode temp=p.head;
         
         
                while(temp!=null)
                {
//                    System.out.println("\n temp ::" + temp.dest);
                   if(visited[temp.dest]==false)
                    {
                       // whenever anything goes in queue it's marked traversed
                        visited[temp.dest]=true;
                        q.add(temp.dest);
                    }
                    temp=temp.next;
                }
        }
        
    }


// DFS traversal of the vertices reachable from v. It uses recursive DFSUtil()
    public void DFS(int v)
    {
        System.out.println("\n DFS:");
        // Mark all vertices as unvisited
        boolean []visited=new boolean[V];
        
        for(int i=0;i<v;i++)
        {
            visited[i]=false;
        }
        // Call the recursive helper function to print DFS traversal
    DFSUtil(v, visited);        
    }
    
     public void DFSUtil(int v,boolean[] visited)
     {
         // Mark the current node as visited node
         //  System.out.print("Demo v = "+v+" ");
         visited[v]=true;
         System.out.print(v+" ");
         
         // Recur for all the vertices adjacent to this vertex
         AdjListNode temp=array[v].head;
         while(temp!=null)
         {
             if(visited[temp.dest]==false)  // means unvisited
             {
                 DFSUtil(temp.dest,visited);
             }
             temp=temp.next;
         }
     }
    
// The function to do Topological Sort. It uses recursive topologicalSortUtil()
public void topologicalSort()
{
    System.out.println("\nTopological Sort ------ ");
    Stack s=new Stack();
    boolean visited[]=new boolean[V];
    
    for(int i=0;i<V;i++)
        visited[i]=false;
    
    // Call the recursive helper function to store Topological Sort
    // starting from all vertices one by one
    for (int i = 0; i < V; i++)
    {
        if (visited[i] == false)
        {
            topologicalSortUtil(i, visited, s);
        }
    }
    
    // Print contents of stack
    while(!s.empty())
    {
        int p = (Integer) s.pop();
       // int p=(int) s.pop();
        
        System.out.print(p+" ");
        
   }
}

// A recursive function used by topologicalSort
    public void topologicalSortUtil(int v,boolean[] visited ,Stack s)
    {
       // Mark the current node as visited.
        visited[v]=true;
        
         // Call the recursive helper function to store Topological Sort
    // starting from all vertices one by one
     // Recur for all the vertices adjacent to this vertex
         AdjListNode temp=array[v].head;
         
         while(temp!=null)
         {
             if(visited[temp.dest]==false)  // means unvisited
             {
                 topologicalSortUtil(temp.dest,visited,s);
             }
             temp=temp.next;
         }

          s.push(v);
    }
     
}


public class Graph_Representation_Adjancy_List {

    public static void main(String[] args) {
        int v=5;
        Graph g=new Graph(v);

        
//    g.addEdge(1, 2);
     g.addEdge(1, 2);
     g.addEdge(2, 3);
     g.addEdge(2, 4);
     g.addEdge(4, 3);
     
//     g.addEdge(2, 7);
//     g.addEdge(3, 4);
//     g.addEdge(3, 7);
//     g.addEdge(3, 6);
//     g.addEdge(4, 5);
////     g.addEdge(5, 6);
//     g.addEdge(7, 8);
////     g.addEdge(5, 7); 
//     g.addEdge(6, 2);
     
//    g.addEdge(0, 1);
//           // If its undirected graph no need to 0,2 and then 2,0
//    g.addEdge(0, 2);
//    g.addEdge(1, 2);
//  //  g.addEdge(2, 0);
//    g.addEdge(2, 3);
//    g.addEdge(3, 3);

//        g.addEdge(1, 2);
//         g.addEdge(1, 5);
//          g.addEdge(5, 4);
//           g.addEdge(3, 3);
         //   g.addEdge(1, 2);


//        g.addEdge(0, 1);
//        g.addEdge(0, 4);
//        g.addEdge(1, 2);
//        g.addEdge(1, 3);
//        g.addEdge(1, 4);
//        g.addEdge(2, 3);
//        g.addEdge(3, 4);
        
        
//    g.addEdge(5, 2);
//    g.addEdge(5, 0);
//    g.addEdge(4, 0);
//    g.addEdge(4, 1);
//    g.addEdge(2, 3);
//    g.addEdge(3, 1);
        // print the adjancey list representation of the graph
        g.printGraph();
        
//       g.BFS(1);
//    
//       g.DFS(1);
   g.topologicalSort();
    }
}
