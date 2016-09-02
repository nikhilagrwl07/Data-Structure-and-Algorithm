
package revisionconnectedcomponent;

 
public class RevisionConnectedComponent {
   
    public static void main(String[] args) {
        graph g=new graph();
       
        g.vertexCount(5);
        g.addEdge(0, 0, 1);
         g.addEdge(1, 1, 2);
          g.addEdge(2, 2, 0);
          g.addEdge(3, 3, 4);
          
          g.connectedComponent(4);
          g.getoutput();
    }
}

class Edge
{
   
    int src=-1,dest=-1;
    public void setedge(int s,int d)
    {
        this.src=s;
        this.dest=d;
    }
    
    
}

class graph
{
   
    Edge edge[]=new Edge[4];
    int edgecount=0;
    int vertexcount=5;
     int vertex[]=new int[vertexcount];
     
     public void vertexCount(int n)
     {
        for(int i=0;i<n;i++)
             vertex[i]=i;
     }
     
     public void addVertex(int n)
     {
         vertex[n]=n;
      
     }
     /*
      public void edgeCount(int n)
     {
       //  this.edgecount=n;
         edge=new Edge[n];
        
     }
      */
       public void addEdge(int edgenumber ,int s,int d)
     {
        edge[edgenumber]=new Edge();
         edge[edgenumber].setedge(s,d);  
         
         System.out.println("Edge "+edge[edgenumber].src+"  "+edge[edgenumber].dest);
                
     }

       public int findset(int v)
       {
          // System.out.println("Check "+vertex[v]);
           return vertex[v];
       }
       
       public void union(int x,int y)
       {
           
           if(x<=y)   // if x is smaller
          {
               vertex[y]=x;
          }
           else   // is y is smaller
           {
               vertex[x]=y;
           }
       }
       
       public void connectedComponent(int e)
       {
          // System.out.println("Edge "+edge[2].src+"  "+edge[2].dest);
            // iterate through each edge and perform connected component
           for(int i=0;i<e;i++)
           {
               System.out.println("Edge "+(i+1)+": src="+findset(edge[i].src)+": dest="+findset(edge[i].dest));
               if(findset(edge[i].src)!=findset(edge[i].dest))
                   union(edge[i].src,edge[i].dest);
               
               System.out.println("Check Point 1 #");
           }
       }
       
       public void getoutput()
       {
           for(int i=0;i<this.vertexcount;i++)
               System.out.print(this.vertex[i]+"  ");
       }
}
