
// Helpful link : http://www.mathblog.dk/disjoint-set-data-structure/
package RV2.DisjointSets;

public class UnionFindinUndirectedGraph {
   // static int V=5;
    static int[] parent; 

    public static void initilze(int l)
    {
        parent=new int[l];

        // initilzing parent as itself
        for(int i=0;i<l;i++)
        {
            parent[i]=i;
        }
    }
    public static void addingEdges(int i,int j)
    {
        parent[i]=j;
    }
    public static int find(int i)
    {
        while(i!=parent[i])
        {
            i=parent[i];
        }
       
        return i;
    }
    public static void union(int i,int j)
    {
        int iPrarent = find(i);
        int jParent = find(j);
        
        if(iPrarent!=jParent)
        {
            addingEdges(iPrarent, jParent);
        }
    }

    
    public static void printGraph(int V)
    {
        System.out.println("-----Graph------");
        for(int l=0;l<V;l++)
        {
           System.out.println(l + " :: "+ parent[l]);
        }
        System.out.println("-----Graph------");

    }

    public static void main(String args[])
    {
        int v=7;
        initilze(v+1); // initial intilization
        // adding egdges
        addingEdges(6, 7);
        addingEdges(6, 5);
        addingEdges(5, 7);
        addingEdges(7, 2);
      //  addingEdges(5, 2);
        addingEdges(1, 2);
        addingEdges(0, 4);
        addingEdges(4, 3);
        System.out.println("\n ######## Before union ########");
        printGraph(v+1);
        union(3, 2);
        System.out.println("######## After union ########");
        printGraph(v+1);

    }
}
