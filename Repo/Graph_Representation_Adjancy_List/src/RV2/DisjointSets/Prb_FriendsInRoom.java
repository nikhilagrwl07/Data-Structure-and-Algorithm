
package RV2.DisjointSets;

public class Prb_FriendsInRoom {
    // static int V=5;
    static int[] parent;
    // adding extra array for rank where rank[i]= height of i
    static int[] rank;
    public static void initilze(int l)
    {
        parent=new int[l];
        rank = new int[l];
        // initilzing parent as itself
        for(int i=0;i<l;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
    }
    public static void addingEdges(int i,int j)
    {
        parent[i]=j;
    }

    // finding and returning repsentation of element
    public static int find(int i)
    {
        if(parent[i]==i)
            return i;
        else
        {
            // recursively finding parent of i
            int parentOfi= find(parent[i]);
            // caching parent of i
            parent[i]=parentOfi;
            // returning the result
            return parentOfi;
        }
    }

    // for returning the union of two sets
    public static void union(int i, int j)
    {
        if(i==j)
           return;
        // finding the represntatives of i & j
        int iRep = find(i);
        int jRep = find(j);

        if(iRep == jRep)
            return;

        int iRank = rank[i];
        int jRank = rank[j];

        // finding the rank of iRep and jRep
        if(iRank < jRank)
        {
            parent[iRep]= jRep;
        }
        else if(iRank > jRank)
        {
            parent[jRep] = iRep;
        }
        else // rank[iRep] = rank[jRep]
        {
            parent[iRep] =jRep;
            rank[jRep]++;
        }

    }

    public static void main(String args[])
    {
        int v=5;
        initilze(v+1); // initial intilization
        // adding egdges
          union(1, 2);
          union(5, 4);
          union(5 , 1);
          
//        addingEdges(6, 7);
//        addingEdges(6, 5);
//        addingEdges(5, 7);
//        addingEdges(7, 2);
//      //  addingEdges(5, 2);
//        addingEdges(1, 2);
//        addingEdges(0, 4);
//        addingEdges(4, 3);
       // System.out.println("\n ######## Before union ########");
        printGraph(v);
       // union(3, 2);
        //System.out.println("######## After union ########");
       // printGraph(v+1);

    }

    public static void printGraph(int V)
    {
        System.out.println("-----Graph------");
        boolean[] isVisited = new boolean[V+1];
        
        for(int i=1;i<=V;i++)
            isVisited[i]=false;

        for(int l=1;l<=V;l++)
        {
            System.out.println("\n parent --> "+ l);
            int l2=l;
           while(!isVisited[l2] && l2!=parent[l2]) // not visited
           {
               isVisited[l2]= true;
               l2=parent[l2];
               System.out.print(l2 + "  ");
           }
            
        }
    }

}
