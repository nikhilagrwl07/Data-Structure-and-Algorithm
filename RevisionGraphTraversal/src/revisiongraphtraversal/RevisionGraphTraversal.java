// BFS and DFS traversal for undirected graph

package revisiongraphtraversal;
import java.util.*;

public class RevisionGraphTraversal {

    public static void main(String[] args) {
       Node nA=new Node('A');
        Node nB=new Node('B');
         Node nC=new Node('C');
          Node nD=new Node('D');
           Node nE=new Node('E');
            Node nF=new Node('F');
             Node nG=new Node('G');
           
         // Creating a graph g 
             graph g=new graph();
             g.addNode(nA);
              g.addNode(nB);
               g.addNode(nC);
                g.addNode(nD);
                 g.addNode(nE);
                 g.addNode(nF);
                   g.addNode(nG);
                   
          g.setRootNode(nA);   
          g.connectNode(nA, nB);       
          g.connectNode(nA, nC);       
          g.connectNode(nA, nD);       
          g.connectNode(nB,nE);
          g.connectNode(nB,nF);
	  g.connectNode(nC,nF);
          g.connectNode(nC,nG);
          
        // Performing the traversal of the graph
          System.out.println("Depth First Traversal of the graph\n");
          g.dfs();
    }
}

class graph
{
    public Node rootNode;
    ArrayList nodes=new ArrayList();
    public int[][] matrix;      // represent the graph as 2-D matrix
    int size;
    
    public void setRootNode(Node n)
    {
        this.rootNode=n;
    }
    
    public Node getRootNode()
    {
        return this.rootNode;
    }
     
    public void addNode(Node n) 
    {
        this.nodes.add(n);
    }
    
    // This method will be used for connecting the nodes
    public void connectNode(Node start,Node end)
    {
        if(this.matrix==null)
        {
            this.size=nodes.size();
            matrix=new int[size][size];
        }
        int startIndex=nodes.indexOf(start);
        int endIndex=nodes.indexOf(end);
        matrix[startIndex][endIndex]=1;
        matrix[endIndex][startIndex]=1;
        
    }
    
    public Node getUnVisitedChildNode(Node n)
    {
        int index=nodes.indexOf(n);
        int j=0;
        
        while(j<nodes.size())
        {
            if(matrix[index][j]==1 && ((Node)nodes.get(j)).visited ==false)
            {
                return (Node)nodes.get(j);
            }
            
            j++;
        }
        
        return null;
    }
    
    // Depth first traversal of graph= depth first traversal of tree
    public void dfs()
    {
        Stack st=new Stack();
        st.push(rootNode);
        rootNode.visited=true;
        printNode(rootNode);
        
        while(!st.isEmpty())
        {
            Node n=(Node) st.peek();
             Node child=getUnVisitedChildNode(n);
             
             if(child!=null)
             {
                  child.visited=true;
                   printNode(child);
                 st.push(child);
          
             }
             else
             {
                 st.pop();
             }
            
        }
        clearNode();
    }

    public void clearNode()
    {
        int j=0;
        while(j<nodes.size())
        {
            Node n=(Node) nodes.get(j);
            n.visited=false;
            j++;
        }
    }
    
    
    public void printNode(Node n)
    {
        System.out.print(n.label+"   ");
    }
}




class Node
{
    public boolean visited=false;
    char label;
    public Node(char c)
    {
        this.label=c;
    }
}
