
package graph_representation_adjancy_list;

// adjancy pathfromStoT Node class

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


// adjnacy pathfromStoT Node class
class AdjListNode
{
    int value;
    AdjListNode next;

        public AdjListNode()
        {            
        }
    // creating new adjancy pathfromStoT node
    public AdjListNode(int d) {
        value=d;
        next=null;
    }
    
}

// adjnacy pathfromStoT class
class AdjList
{
    AdjListNode head; // pointer to head node of the pathfromStoT
}

// A structure to represent a graph. A graph is an array of adjacency lists.
// Size of array will be V (number of vertices in graph)



class GraphDFS
{
    int V;
    AdjList[] array;

    public GraphDFS(int v) {
        V=v;
        // create an array of adjancey pathfromStoT . Size of the pathfromStoT is V
        array=new AdjList[V];
        visited = new boolean[v];

        for(int i=0;i<V;i++)
        {
            array[i]=new AdjList();
            array[i].head=null;
             visited[i]=false;
        }
        
    }
    
    // Add edge to an undirected graph
    public void addEdge(int s,int d)
    {
     // Add an edge from src to value.  A new node is added to the adjacency
    // pathfromStoT of src.  The node is added at the begining
        
        AdjListNode newNode=new AdjListNode(d);
        newNode.next=array[s].head;
        array[s].head=newNode;
//
//        if(s!=d)
//        {
//         //Case 1 : UnDirected graph
//        newNode= new AdjListNode(s);
//        newNode.next=array[d].head;
//        array[d].head=newNode;
//        }
        // Case 2 : Directed GraphDFS
    // Since graph is directed, NO NEED TO ADD an edge from value to src also
//        newNode= new AdjListNode(s);
//        newNode.next=array[d].head;
//        array[d].head=newNode;

    }
    
    public void printGraph()
    {
        int v;
        for(v=0;v<V;v++)
        {
            AdjListNode pCrawl=array[v].head;
            System.out.print("Adjancey list of vertex: "+v+" \nhead");
            while(pCrawl!=null)
            {
                System.out.print(" -> "+pCrawl.value);
                pCrawl=pCrawl.next;
            }
            
            System.out.println();
        }
    }

    boolean doesPathExist= false;
    List<AdjListNode> pathfromStoT_BFS = new ArrayList<AdjListNode>();

    public void BFS(int source ,int destination)
    {
        System.out.println("Breadth First traversal starting at "+source);
        int i;
        int intial_source = source;
        // MArk all vertices to be unvisited
        boolean[] visited= new boolean[V];
        
        for(i=0;i<V;i++)
        {
            visited[i]=false;
        }
        
        // creating queue for BFS
        Queue<Integer> q=new LinkedList();
        
        visited[source]=true;

        if(intial_source==destination)
        {
            System.out.println("Source & destination are same.");
            doesPathExist=true;
            return;
        }

        q.add(source);
      
        while(!q.isEmpty())
        {
            // dequeue a vertex  from queue and print it
           source=q.remove();
            System.out.print(source + " ");
           // Get all adjacent vertices of the dequeued vertex source
        // If a adjacent has not been visited, then mark it visited
        // and enqueue it
         AdjList p=array[source];
         AdjListNode temp=p.head;
         
                while(temp!=null && !doesPathExist)
                {
                    if(visited[temp.value]==false)
                    {
//                        pathfromStoT_BFS.add(temp);
//                        if(temp.value==destination){
//                          doesPathExist=true;
//                        }
                       
                        visited[temp.value]=true;
                        q.add(temp.value);
                    }
                    temp=temp.next;
                }
        }


//        if(doesPathExist){
//            System.out.println("Path exits");
//            for(AdjListNode adjListNode : pathfromStoT_BFS){
//                System.out.print(adjListNode.value+ " ");
//            }
//        }
//        else
//            System.out.println("Path does NOT exits");
        
    }

    boolean []visited=new boolean[V];
  
// DFS traversal of the vertices reachable from startNodeId. It uses recursive DFSUtil()
    public void DFS(int startNodeId)
    {
        System.out.println("DFS:");
        // Mark all vertices as unvisited
       
        for(int i=0;i<visited.length;i++)
        {
            visited[i]=false;
        }
        // Call the recursive helper function to print DFS traversal
        DFSUtil2(startNodeId, visited);
    }
    
 
     
    public void DFSUtil2(int startNodeId,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[startNodeId] = true;
        System.out.print(startNodeId+" ");
        // Recur for all the vertices adjacent to this vertex
          AdjListNode temp=array[startNodeId].head;
          
         while(temp!=null)
         {
             if(visited[temp.value]==false)  // means unvisited
             {
                
                 DFSUtil2(temp.value,visited);
             }
            
             temp=temp.next;
         }
        
    }

    List<Integer> pathfromStoT= new ArrayList();
        
     public void findingPathUsingDFSUtil(int startNodeId,boolean[] visited , int destinationNodeId)
     {
         // Mark the current node as visited node
         //  System.out.print("Demo startNodeId = "+startNodeId+" ");
         visited[startNodeId]=true;
         System.out.print(startNodeId+" ");
         if(startNodeId==destinationNodeId){
             isPathExist=true;
             return;
         }
         
         // Recur for all the vertices adjacent to this vertex
         AdjListNode temp=array[startNodeId].head;
         while(temp!=null)
         {
             if(visited[temp.value]==false)  // means unvisited
             {
                 if(!isPathExist){
                     pathfromStoT.add(temp.value);
                 }
                 findingPathUsingDFSUtil(temp.value,visited,destinationNodeId);
             }
             temp=temp.next;
         }
      }

     public void DFS_Iterative(int source  ,int destination){

         if(source==destination){
             System.out.println("source & destination are same.");
             return;
         }
         boolean[] visited= new boolean[V];
        // when source and destination are different
        for(int i=0;i<V;i++)
        {
            visited[i]=false;
        }
        visited[source]=true;
        boolean isComplete=false;
        List<Integer> pathFromStoT= new ArrayList<Integer>();

        while(!isComplete){

            if(source==destination){
                isComplete=true;
                pathFromStoT.add(source);
                break;
            }
            AdjListNode headOfSource = array[source].head;
            AdjListNode  beforeHeadOfsource = array[source].head;
            while(true)
            {
                if(headOfSource==null)
                {
                    headOfSource=beforeHeadOfsource.next;
                }
                else
                {
                    beforeHeadOfsource.value= source;
                }
                source = headOfSource.value;
                if(source==destination){
                     pathFromStoT.add(source);
                     break;
                }
                else{
                    headOfSource=array[headOfSource.value].head;
                }

            }


        }

     }
    
// The function to do Topological Sort. It uses recursive topologicalSortUtil()
public void topologicalSort()
{
    System.out.println("\nTopological Sort ------ ");
    Stack s=new Stack();
//    boolean visited[]=new boolean[V];
    
    for(int i=0;i<V;i++)
        visited[i]=false;
    
    // Call the recursive helper function to store Topological Sort
    // starting from all vertices one by one
    for (int i = 1; i < V; i++)
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
             if(visited[temp.value]==false)  // means unvisited
             {
//                 System.out.print(temp.value + " ... ");
                 topologicalSortUtil(temp.value,visited,s);
             }
             temp=temp.next;
         }

          s.push(v);
    }

    int[][] tableVertexDistance = new int[V][V];
    int previousVertex[] = new int [V];

    // Shortest path in undirected unweighted GraphDFS
    public void ShorstedPathAnddistanceInUnWeightedGraph(int source)
    {
        tableVertexDistance = new int [V][V];
        previousVertex = new int [V];
     //   System.out.println("Breadth First traversal starting at "+source);
        int i;
        // MArk all vertices to be unvisited
       // boolean[] visited= new boolean[V];

        for(i=0;i<V;i++)
        {
           // visited[i]=false;
          //  System.out.println("i= "+i);
            tableVertexDistance[i][0]=i;
            tableVertexDistance[i][1]= -1;
        }
        tableVertexDistance[source][1] = 0;   // initilzing the source,1 with distance 0

        // creating queue for BFS
        Queue<Integer> q=new LinkedList();

       // visited[source]=true;

        q.add(source);

        while(!q.isEmpty())
        {
            // dequeue a vertex  from queue and print it
           source=q.remove();

        //   System.out.print(source+"  ");

           // Get all adjacent vertices of the dequeued vertex source
        // If a adjacent has not been visited, then mark it visited
        // and enqueue it

         AdjList p=array[source];
         AdjListNode temp=p.head;

         while(temp!=null)
                {
         //           System.out.print(temp.value+ "  ");
                    if(tableVertexDistance[temp.value][1] == -1)
                    {
                        tableVertexDistance[temp.value][1]= tableVertexDistance[source][1]+1;
                        previousVertex[temp.value]=source;
                        q.add(temp.value);
                    }
                    
                    temp=temp.next;
                }
        }

    }
    public void displayDistance(int source)
    {
        System.out.println("Source Vertex :: "+ source);
        for(int i=0;i<V;i++)
        {
            System.out.println("Vertex :: "+ i + " :: Distance :: "+ tableVertexDistance[i][1]);
        }
    }
    public void displayPreviousVertex()
    {
        System.out.println("Previous Vertex :: ");
        for(int i=0;i<V;i++)
        {
            System.out.println("Vertex :: "+ i + " :: previous vertex :: "+ previousVertex[i]);
        }
    }

    public void displayPath(int startVertex , int endVertex){
        if(startVertex <0 || startVertex > V || endVertex <0 || endVertex >V)
        {
            System.out.println("Invalid vertex . ");
            return;
        }
        // assuming here source vertex as 1
        System.out.println("Path from source vertex "+ startVertex + " to end vertex ::  "+ endVertex);
        if(previousVertex[endVertex] == startVertex)
        {
            System.out.println(startVertex + " --> "+endVertex);
        }
        else
        {
        while(previousVertex[endVertex] != startVertex)
        {
            System.out.print(endVertex + " --> ");
           // System.out.println(previousVertex[endVertex] + " ");
            endVertex= previousVertex[endVertex];
        }
            System.out.println(endVertex + " --> "+ startVertex);
        }
       
    }

   public boolean isPathExist=false;
   
   public void isTherePathFromStoT_DFS(int s , int t){
        DFS(s);
        if(isPathExist){
            System.out.println("Path Exist");
        }
        else{
             System.out.println("Path does NOT Exist");
        }

    }
    public void displayPaths(){
        System.out.println("Display path from s to t");
        for(int i=0;i<pathfromStoT.size();i++){
            System.out.print(pathfromStoT.get(i)+ " ");
        }
    }

    public boolean isDirectlyConnected(int s, int d){

        if(s==d) return true;

        AdjList adjList = array[s];
        AdjListNode adjListNode= adjList.head;
        while(adjListNode!=null){

            if(adjListNode.value==d){
                return true;
            }
            adjListNode= adjListNode.next;
        }
        return false;
    }
    public void countNumberOfSimplePath(int s , int d){
        int numberOfPaths=0;
        if(s==d){
            System.out.println("source & destination are same.");
        }
        else
        {
            for(int i=1;i<V;i++){
                System.out.println(i+ " :: ");
            
                if(isDirectlyConnected(s, i) && !visited[i]){
                        DFS(s);
                        if(isPathExist){
                            System.out.println("***** Path ***** ");
                            displayPaths();
                            numberOfPaths++;
                            isPathExist=!isPathExist;
                        }
                    }

            }
        }

        System.out.println("Number of paths = "+ numberOfPaths);

    }
}



public class Graph_Representation_Adjancy_List {

    public static void main(String[] args) {
        int v=6;
        GraphDFS g=new GraphDFS(v);

//    g.addEdge(0, 1);
//           // If its undirected graph no need to 0,2 and then 2,0
//    g.addEdge(0, 2);
//    g.addEdge(1, 2);
//  //  g.addEdge(2, 0);
//    g.addEdge(2, 3);
//    g.addEdge(3, 3);
        
        
        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
           g.printGraph();
        
//      g.addEdge(1, 2);
//      g.addEdge(1, 6);
//      g.addEdge(3, 1);
//      g.addEdge(1, 2);
//      g.addEdge(3, 4);
//      g.addEdge(3, 7);
//      g.addEdge(4, 1);
//      g.addEdge(1, 3);
//      g.addEdge(7, 6);
//      g.addEdge(5, 7);
    //  g.addEdge(6, 5);
//   
      //1 6 7 5 3 4 2 
      //1 6 2 7 3 4 5 
   //  g.countNumberOfSimplePath(1, 5);
    // g.isTherePathFromStoT_DFS(1,5);
    // g.displayPaths();
   //  g.DFS_Iterative(1, 5);
     //g.DFS(1,5);
//    g.BFS(1, 5);
//       g.isTherePathFromStoT_DFS(4,5);
//      g.displayPaths();

//        g.addEdge(1, 2);
//         g.addEdge(1, 5);
//          g.addEdge(5, 4);
//           g.addEdge(3, 3);
//         //   g.addEdge(1, 2);


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
        // print the adjancey pathfromStoT representation of the graph
       // g.printGraph();
//        g.ShorstedPathAnddistanceInUnWeightedGraph(7);
//        g.displayDistance(1);
//        g.displayPreviousVertex();
//        g.displayPath(7, 1);

//      g.BFS(1);
    
       g.DFS(5);
       System.out.println("------------------------");
   g.topologicalSort();
    }
}
