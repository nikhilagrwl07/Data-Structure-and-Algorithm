
package KruskalMST;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class kruskalMST {

    public static void main(String[] args) {
        int V=4 ; // Number of vertices
        int E=5;

        Graph g = new Graph().createGraph(V, E);
        g.edge = new Edge[E];
        g.edge[0]= new Edge(0, 1, 10);  // src ,dest, weight
        g.edge[1]= new Edge(0, 2, 6);
        g.edge[2]= new Edge(0, 3, 5);
        g.edge[3]= new Edge(1, 3, 15);
        g.edge[4]= new Edge(2, 3, 4);

          new kruskalMST().kruskalMST(g);

    }
   
    private void kruskalMST(Graph g){
        int e=0;
        int i=0;
        int V=g.V;
        Edge[] edges=g.edge;
        Edge[] result= new Edge[V];   // results ???
        Subset[] subsets = new Subset[V];   // subsets for each vertex
        List<Edge> l = Arrays.asList(edges);
        Collections.sort(l,Edge.edgeWeightComparator);

        for(int j=0;j<V;j++){
            subsets[j]= new Subset(j,0);
        }

        while(e<V-1){
            Edge nextEdge = g.edge[i++];

            int x = Graph.find(subsets,nextEdge.src);
            int y= Graph.find(subsets, nextEdge.dest);

            if(x!=y){
                result[e++]=nextEdge;
                Graph.union(subsets, x, y);
            }
        }
        System.out.println("Following are the edges in the constructed MST : ");
        for(i=0;i<e;i++){
            System.out.println(result[i].src+ " -- "+ result[i].dest + " == "+result[i].weight);
        }
    }

}

class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int weight;


    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public static final Comparator<Edge> edgeWeightComparator = new Comparator<Edge>(){

        public int compare(Edge e1, Edge e2) {
             return e1.weight-e2.weight;
        }
    };
  

    public int compareTo(Edge o1) {
        return this.weight-o1.weight;
    }

}
 class Graph{
     int V,E;
     Edge[] edge;

     public Graph createGraph(int v, int e){
         Graph g = new Graph();
         g.V=v;
         g.E=e;
         edge = new Edge[e];
        return g;
     }

      public static int find(Subset subset[], int i){
         if(subset[i].parent!=i){
             subset[i].parent=find(subset, subset[i].parent);  // uses path compression technique
         }
         return subset[i].parent;
     }

     public static void union(Subset subset[],int x,int y){
         int xRoot=find(subset, x);
         int yRoot = find(subset,y);

         if(xRoot<yRoot){
             subset[xRoot].parent=yRoot;
         }
         else if(yRoot<xRoot){
             subset[yRoot].parent=xRoot;
         }
         else if(yRoot==xRoot){
             subset[xRoot].parent=yRoot;
             subset[yRoot].rank++;
         }
         
     }
}

 class Subset{
     int parent ;
     int rank;

    public Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }

 }




