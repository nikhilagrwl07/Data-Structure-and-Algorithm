package RV2;


public class DijkstraUsingAdjancyMatrix {
    public static final int V=9;
    public static boolean []isTraversed = new boolean[V];
    public static int[] distance = new int[V];
    
    public static void initilze()
    {
        for(int i=0 ;i<V;i++)
        {
            isTraversed[i]= false;
            distance[i]=Integer.MAX_VALUE;
        }
    }
    public static void printGraph(int[][] g)
    {
        for(int i=0;i<g.length;i++)
        {
            for(int j=0;j<g[i].length;j++)
            {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
          System.out.println();
    }
     public static void printOutput(int startVertex ,int[] a)
    {
        System.out.println("Start Vertex :  "+ startVertex);
        System.out.println("Vertex  :   Distance");

        for(int i=0;i<a.length;i++)
        {
                System.out.println(i + "               " + a[i]);
        }
    }

    public static int minDistance(int[][] g , int startVertx)
    {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<V;i++)
        {
            if(min>g[startVertx][i] && g[startVertx][i]!=0 && isTraversed[i]==false)  // giving direct distance between any u,v combination
            {
                min=i;
            }
        }
        return min;
    }

    public static void shorstestPathAdjMatrix(int[][] g , int startVertex)
    {
        initilze();
        distance[startVertex] = 0;
        // traversing each Node
        for(int i=0;i<V;i++)
        {
            // 1. find min-distance of current Node with all other Node in G
            // 2. update the current
                int endVertex = minDistance(g, i);
                if(endVertex!=Integer.MAX_VALUE)
                {
                    isTraversed[endVertex]=true;
                    distance[endVertex] = distance[startVertex]+g[startVertex][endVertex];
                }
        }
    }

    // undirected weighted graph
    public static void main(String args[])
    {
        int[][] graph={
                      {0, 4, 0, 0, 0, 0, 0, 8, 0},
                      {4, 0, 8, 0, 0, 0, 0, 11, 0},
                      {0, 8, 0, 7, 0, 4, 0, 0, 2},
                      {0, 0, 7, 0, 9, 14, 0, 0, 0},
                      {0, 0, 0, 9, 0, 10, 0, 0, 0},
                      {0, 0, 4, 0, 10, 0, 2, 0, 0},
                      {0, 0, 0, 14, 0, 2, 0, 1, 6},
                      {8, 11, 0, 0, 0, 0, 1, 0, 7},
                      {0, 0, 2, 0, 0, 0, 6, 7, 0}
                       };
           printGraph(graph);
           shorstestPathAdjMatrix(graph,0);
           printOutput(0 , distance);
     }

}
