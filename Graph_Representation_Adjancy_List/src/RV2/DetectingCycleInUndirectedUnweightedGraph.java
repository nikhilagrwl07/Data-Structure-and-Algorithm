
package RV2;

public class DetectingCycleInUndirectedUnweightedGraph {
    public static final int V= 3;

    public static boolean isNested(int[] V,int s, int e)
    {
        while(V[s]!=-1)
        {
             //System.out.println(s);
            if(V[s]==e)
                return true;
            else    //if(V[s]!=e)
             {
                System.out.println(s);
                 s=V[s];
             }
        }
        return false;
    }
    public static boolean detectCycle(int[][] g)
    {
        int [] vertex= new int [V];
        for(int i=0;i<V;i++)
        {
            vertex[i]=-1;
        }
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(g[i][j]==1)
                {
                    if(i<=j) // unvisited
                    {
                        if(vertex[i]==-1)
                        {
                           vertex[i]=j;
                        }
                        else
                        {
                           if(isNested(vertex, i, j))
                           {
                               return true;
                           }
                        }
                       
                    }
                    else if(j<i) // unvisited
                    {
                        if(vertex[j]==-1)
                        {
                           vertex[j]=i;
                        }
                        else
                        {
                           if(isNested(vertex, i, j))
                           {
                                return true;
                           }
                        }
                    }
                }
            }
        }

        return false;
    }
    public static void main(String args[])
    {
        int[][] g={
                  {0,1,0},
                  {1,0,1},
                  {0,1,0}
                  };
          System.out.println("Is cycle present = "+ detectCycle(g));
        
    }
}
