
package revisiontopologicalsort;

import java.util.Stack;

public class RevisionTopologicalSort {
    Stack stk;
//	Vertex [] stkArray;
//	int c;
    
    public static void main(String[] args) {
       RevisionTopologicalSort ts=new RevisionTopologicalSort();
       
       // loading the graph 
       int numVertex=6;
       Vertex V[]=new Vertex[numVertex+1];
       
       V[1]=new Vertex('1');
       V[2]=new Vertex('2');
       V[3]=new Vertex('3');
       V[4]=new Vertex('4');
       V[5]=new Vertex('5');
       V[6]=new Vertex('6');
       
       //connecting he nodes
       //1--> 2,3
              V[1].setOuts(V[2]);
              V[1].setOuts(V[3]);
       
              //2--> 3,4
              V[2].setOuts(V[3]);
              V[2].setOuts(V[4]);
       
                 //3->5
		V[3].setOuts(V[5]);
		
		
		//4->6
		V[4].setOuts(V[6]);
		
		//5->4,6
		V[5].setOuts(V[6]);
		V[5].setOuts(V[4]);
       
         // Checking the graph that It is connected properly by visiting each vertex
                int j,k;
              for(j=1;j<=numVertex;j++)                
              {
                  System.out.print(V[j].getName()+"==>");
                  
                  for(k=1;k<=V[j].numOuts;k++)                  
                  {
                      System.out.print(V[j].getOuts(k).getName()+"  ");
                  }
                  System.out.println();
              }
              
                int i;
             for(i=1;i<=numVertex;i++) 
             {
                 if(!V[i].isVisited())
                    ts.dfs(V[i]);
             }
             
             // Pop till the stack gets empty
             while(!ts.stk.isEmpty())
             {
                 System.out.println("Vertex"+((Vertex)ts.stk.pop()).getName()+"is popped out");
             }
             
    }
    
    
              public void dfs(Vertex v)
              {
                   System.out.println("Visiting vetex: "+v.getName());
                   v.setboolean();
                   
                   int outNums=v.getOutsNum();       
                  Vertex[] vOuts=new Vertex[outNums+1];
                  
                  for(int i=1;i<=outNums;i++)
                  {
                      vOuts[i]=v.getOuts(i);
                  }
                  
                  for(int i=1;i<=outNums;i++)
                  {
                      Vertex w=vOuts[i];
                      System.out.println(v.getName()+" is looking at "+w.getName());
                                           
                      if(!w.isVisited())
                      {
                          dfs(w);
                      }
                  }
                  
                    stk.push(v);
                    System.out.println("STACK"+v.getName()+"Pushed");
                  
              }
}

class Vertex
{
    char name;
    Vertex[] outs;
    int numOuts;
    int N;
    int L;
    boolean visited=false;
    
    public Vertex(char label)
    {
        this.name=label;
        outs=new Vertex[100];
        numOuts=0;
    }
    
    public char getName()
    {
        return name;
    }
    
    public void setOuts(Vertex v)
    {
        numOuts++;
        outs[numOuts]=v;
    }        
    
    public int getOutsNum()
    {
        return numOuts;
    }
    
    public Vertex getOuts(int i)
    {
        return outs[i];
    }
    
    public boolean isVisited()
    {
        return visited;
    }
    
    public void setboolean()
    {
        visited=true;
    }
   /* 
    public void setN(int v)
    {
        N=v;
    }
    
    public void setL(int v)
    {
        L=v;
    }
    
    public int getL()
    {
        return L;
    }
    
     public int getN()
    {
        return N;
    }
     
    public void display()
    {
        System.out.println(name+"\n");
         System.out.println("N:"+N+"L:"+L);
    }
    * 
    */
}

