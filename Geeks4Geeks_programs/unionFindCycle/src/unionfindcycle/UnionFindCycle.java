
package unionfindcycle;

public class UnionFindCycle {
private int[] id;
public boolean isCycle=false;

    public UnionFindCycle(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = -1;
    }
    
    public boolean connected(int id1, int id2) {
        return id[id1] == id[id2];
    }
    
    public void union(int id1, int id2) {
    
        if (id[id2]==-1) 
               id[id1]=id2;
        else
            id[id1]=id[id2];
                      
        
    }
    
    public void isCycle()
    {
            // Iterate through all edges of graph, find subset of both
    // vertices of every edge, if both subsets are same, then there is
    // cycle in graph.
        int e=6;
        for(int i=1;i<=e;i++)
        {
            
        }
        
        
    }
      public static void main(String[] args) {        
             UnionFindCycle q = new UnionFindCycle(8);
        q.union(1, 4);
        q.union(1, 7);
        q.union(1, 2);
        
        q.union(2, 3);
        q.union(2, 5);
        q.union(3, 6);
        
        
        q.isCycle();
       // for (int i = 0; i < 10; i++)
        //    System.out.print(q.id[i] + " ");
    
    }
}


