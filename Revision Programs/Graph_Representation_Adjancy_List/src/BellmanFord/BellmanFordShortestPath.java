
package BellmanFord;

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


class Graph
{
    int V;
    AdjList[] array;
    int edgeWeight[][];
     private static int distVal[]=null;
    
    public Graph(int v) {
        V=v;
        // create an array of adjancey list . Size of the list is V
        array=new AdjList[V];

        for(int i=0;i<V;i++)
        {
            array[i]=new AdjList();

        }

        // initialze each list as empty by making head as null
        for(int i=0;i<V;i++)
        {
            array[i].head=null;  //new AdjListNode();
            //null;
        }
        edgeWeight = new int[V][V];
    }

     // Add edge to an undirected graph
    public void addEdge(int s,int d ,int w)
    {
     // Add an edge from src to dest.  A new node is added to the adjacency
    // list of src.  The node is added at the begining

        AdjListNode newNode=new AdjListNode(d);
        newNode.next=array[s].head;
        array[s].head=newNode;

        edgeWeight[s][d] = w;
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

    public void printGraph(String message)
    {
        System.out.println("** "+ message+ " **");
        int v;
        for(v=0;v<V;v++)
        {
            AdjListNode pCrawl=array[v].head;
            System.out.print("Adjancey list of vertex: "+v+" \nhead");
            while(pCrawl!=null)
            {
                System.out.print(" -> "+pCrawl.dest + " (W="+edgeWeight[v][pCrawl.dest]+ ")");
                pCrawl=pCrawl.next;
            }

            System.out.println();
        }
    }

 
    public void bellmanFord(int source){
            distVal = new int[V];
        // Step 1 : initlizing an array with some weights
        for(int i=1;i<=V-1;i++)
            distVal[i]= Integer.MAX_VALUE;

        distVal[source]=0;

        // Step 2 : Relaxation  step
        for(int s=1;s<=V-1;s++) // For all vertices
        {
            AdjListNode pCrawl=array[s].head;
            while(pCrawl!=null)
            {
               
             if(distVal[s] != Integer.MAX_VALUE && distVal[s]+ 
                     edgeWeight[s][pCrawl.dest] < distVal[pCrawl.dest])
             {
                distVal[pCrawl.dest] = distVal[s]+ edgeWeight[s][pCrawl.dest];
             }
                pCrawl=pCrawl.next;
            }
        }
    }

    public void isGraphContainsNegativeWeightCycle(){

        if(isGraphContainsNegativeWeightCycleUtils()!=-1)
            System.out.println("Graph contains -ive weight cycle");
         else
             System.out.println("Graph does NOT contains -ive weight cycle");
        
    }

    int cycle[] ;
    public int isGraphContainsNegativeWeightCycleUtils(){

        cycle = new int[V+1];
        for(int i=0;i<=V;i++)
            cycle[i]=-1;

        for(int s=1;s<=V-1;s++) // For source vertices
        {
            AdjListNode pCrawl=array[s].head;
            while(pCrawl!=null)   // for sink vertices
            {
              cycle[s]=pCrawl.dest;  // source index contains dest vetex
             if(distVal[s]+ edgeWeight[s][pCrawl.dest] < distVal[pCrawl.dest])
             {
                return s;
             }
                pCrawl=pCrawl.next;
            }
        }
        return -1;
    }

    public void printNegativeWeightCycle(){
//        
//        for(int i=1;i<cycle.length;i++)
//        {
//            System.out.print(cycle[i] + " ");
//        }
//        
        int sourceVertex = isGraphContainsNegativeWeightCycleUtils();
        if(sourceVertex != -1){
            System.out.println("Printing cycle");
          
            while(sourceVertex!=-1 && sourceVertex!=cycle[sourceVertex]){
                System.out.print(sourceVertex+ "    ");
                sourceVertex=cycle[sourceVertex];
            }
              System.out.print(sourceVertex+ "  ");
        }
        else
        {
             System.out.println("Negative weight cycle is not present");
        }
    }


    public void printBellmanFordDistance(String s){
        System.out.println("******* " + s +" *******");
        System.out.println("Vertex      Distance from Source Vertex");
        for(int i=1;i<=V-1;i++){
            System.out.println(i+"      "+ distVal[i]);
        }
    }

}


public class BellmanFordShortestPath {
 public static void main(String[] args) {
      int v=6;
      Graph g=new Graph(v);

      // Directed Graph
      g.addEdge(1, 2,-1);
      //g.addEdge(1, 3,4);
      g.addEdge(3, 1, -10);
      g.addEdge(2, 3,3);
      g.addEdge(2, 4, 2);
      g.addEdge(4, 2, 1);
      g.addEdge(4, 3, 5);
      g.addEdge(2, 5, 2);
      g.addEdge(5, 4, -3);

      g.printGraph("Graph");
      g.bellmanFord(1);
      g.printBellmanFordDistance("After Bellman Ford algo");
      g.isGraphContainsNegativeWeightCycle();
      g.printNegativeWeightCycle();
 }
}
