
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
    private static int distance[]=null;
    
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
        
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                edgeWeight[i][j]=0;
            }
        }
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
//        if(u!=d)
//        {
//         //Case 1 : UnDirected graph
//        newNode= new AdjListNode(u);
//        newNode.next=array[d].head;
//        array[d].head=newNode;
//        }
        // Case 2 : Directed Graph
    // Since graph is directed, NO NEED TO ADD an edge from dest to src also
//        newNode= new AdjListNode(u);
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
            distance = new int[V];
            
        // Step 1 : initlizing an array with some weights
        for(int i=1;i<=V-1;i++)
            distance[i]= Integer.MAX_VALUE;

        distance[source]=0;

        // Step 2 : Relaxation  step
        for(int u=1;u<=V-1;u++) // For all vertices
        {
            AdjListNode pCrawl=array[u].head;
            while(pCrawl!=null)
            {
               
             if(distance[u] != Integer.MAX_VALUE && 
                     distance[u]+ edgeWeight[u][pCrawl.dest] < distance[pCrawl.dest] &&
                     edgeWeight[u][pCrawl.dest]>0)
             {
                distance[pCrawl.dest] = distance[u]+ edgeWeight[u][pCrawl.dest];
             }
                pCrawl=pCrawl.next;
            }
        }
        // Step 3: check for negative-weight cycles.  The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        //  path, then there is a cycle.
        
        for(int u=0;u<V;u++)
        {
            for(int v=0;v<V;v++)
            {
                if(edgeWeight[u][v]!=0)
                {
                    if(distance[u]!=Integer.MAX_VALUE &&
                            distance[u]+edgeWeight[u][v]<distance[v])
                    {
                        System.out.println("Graph contains negative weight cycle");
                    }
                }
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
             if(distance[s]+ edgeWeight[s][pCrawl.dest] < distance[pCrawl.dest])
             {
                return s;
             }
                pCrawl=pCrawl.next;
            }
        }
        return -1;
    }

    public void printNegativeWeightCycle(){
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
            System.out.println(i+"      "+ distance[i]);
        }
    }

}


public class BellmanFordShortestPath {
 public static void main(String[] args) {
      int v=6;
      Graph g=new Graph(v);

      // Directed Graph
      g.addEdge(1, 2,1);
      //g.addEdge(1, 3,4);
      g.addEdge(3, 1, 10);
      g.addEdge(2, 3,3);
      g.addEdge(2, 4, 2);
      g.addEdge(4, 2, 1);
      g.addEdge(4, 3, 5);
      g.addEdge(2, 5, 2);
      g.addEdge(5, 4, 3);

     // g.printGraph("Graph");
      g.bellmanFord(1);
      g.printBellmanFordDistance("After Bellman Ford algo");
//      g.isGraphContainsNegativeWeightCycle();
//      g.printNegativeWeightCycle();
 }
}
