/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graph_representation_adjancy_list;

/**
 *
 * @author nikhil.agrawal
 */
// Java program to print DFS traversal from a given given graph
import java.io.*;
import java.util.*;
 
// This class represents a directed graph using adjacency list
// representation
class DetectionOfCycleOfDirectedGraph
{
    private int V;   // No. of vertices
 
    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
 
    // Constructor
    DetectionOfCycleOfDirectedGraph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    
    void printAdjancyList()
    {
        
        System.out.println("Printing adjacency list graph");
        
        for(int i=1;i<V;i++)
        {
            System.out.print("Head :: " + i + " :: ");
            Iterator<Integer> it = adj[i].listIterator();
        
            while (it.hasNext())
            {
                int n = it.next();
                System.out.print(n + " ");
            }
            System.out.println("");
        }
    }
 
    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
      //  adj[w].add(v);
    }
 
    // A function used by DFS
    boolean isCylicUtil(int v,boolean visited[] , boolean recurStack[])
    {
        
        // Mark the current node as visited and print it
        if(visited[v]==false)
        {
           visited[v] = true;
           recurStack[v] = true;
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (visited[n]==false && isCylicUtil(n, visited, recurStack))
                return true;
            else if(recurStack[n])
            {
                return true;
            }
                
        }  
        }
        
        recurStack[v]=false;
        return false;
       
    }
 
    // The function to do DFS traversal. It uses recursive DFSUtil()
    boolean isCylic()
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        for(int i=1;i<V;i++)
        {
              if(isCylicUtil(i, visited, recStack))
              {
                  System.out.println("Graph is cyclic");
                  return true;
              }
                  
        }
      
        System.out.println("Graph is NOT cyclic");
        return false;
    }
 
    public static void main(String args[])
    {
        DetectionOfCycleOfDirectedGraph g = new DetectionOfCycleOfDirectedGraph(4);
 
//    Graph g(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
        
//      g.addEdge(1, 2);
//      
//      g.addEdge(1, 8);
//      g.addEdge(1, 6);
//      g.addEdge(2, 3);
//      g.addEdge(2, 7);
//      g.addEdge(3, 4);
//      g.addEdge(3, 7);
//      g.addEdge(4, 5);
//      g.addEdge(5, 6);
//      g.addEdge(7, 6);
//      g.addEdge(5, 7);
// 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.printAdjancyList();
        g.isCylic();
    }
}
// This code is contributed by Aakash Hasija