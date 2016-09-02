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
class GraphDSFUtil
{
    private int V;   // No. of vertices
 
    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
 
    // Constructor
    GraphDSFUtil(int v)
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
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
 
    public static void main(String args[])
    {
        GraphDSFUtil g = new GraphDSFUtil(6);
 
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
        
        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.printAdjancyList();
        g.DFS(5);
    }
}
// This code is contributed by Aakash Hasija