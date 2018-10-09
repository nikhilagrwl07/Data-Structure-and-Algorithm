
package nArrayTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author admin
 */
public class nArrayTree {

    public static final int nArray=3;
    public static void main(String[] args) {

    nArrayTreeImplement t=new nArrayTreeImplement();
   // Node root=new Node(1,3);
    t.insert( 1, 3);
    t.insert( 3, 3);
    t.insert( 4, 3);
    t.insert( 5, 3);
    t.insert( 6, 3);
    t.insert( 7, 3);
    t.insert( 12, 3);
    t.insert( 12, 3);
    t.insert( 12, 3);


        System.out.println("level order traversal");
        t.levelOrder();
    }
}

class nArrayTreeImplement{
    Node root;

     

    public void insert(int x,int k)
    {
        Queue<Node> queue=new LinkedList<>();
        
        if(root==null)
        {
            root=new Node(x,k);
        }
        else
        {
            queue.add(root);
            while(!queue.isEmpty())
            {
                Node t=queue.remove();

                for(int i=0;i<k;i++)
                {
                    Node child = t.children[i];
                    
                    if(child.x ==-1)  // means data is empty but node is created
                    {
                        child = new Node(x, k);
                        t.children[i]= child;
                        queue.clear();
                        break;
                    }
                    else
                    {
                        queue.add(child);
                    }
                }
                
            }
        }
    }
    
    
    public void levelOrder()
    {
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node t=q.remove();
            if(t!=null)
            {
            for(int i=0;i<3;i++)
            {
                if(t.children[i]!=null && t.children[i].x!=-1)
                {
                   // System.out.print(" -- "+ t.children[i].x);
                    q.add(t.children[i]);
                }
            }
            System.out.print(t.x +" ");
            }
        }
    }
    
    
    
    
}

class Node
{
    int x;
    Node children[];

    public Node(int val)
    {
        x = val;
    }

    public Node(int d,int k) {
        this.x=d;
        this.children=new Node[k];
        for(int i=0;i<k;i++)
        {
            children[i]=new Node(-1);
        }
    }

   

}
