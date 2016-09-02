
package connectsamelevelnodes;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



// sample class for node structure of binary tree
class Node
{
    int data;
    Node left;
    Node right;
    Node nextRight;
    public Node()
    {
        left=null;
        right=null;
        nextRight=null;
    }
}

class BinaryTree
{
    Node root=null;
    
    public void insert(int x)
    {
        if(root==null)
        {
            root =new Node();
            root.data=x;
        }
        else
        {
            Queue<Node> q=new LinkedList();
            q.add(root);
            
            while(!q.isEmpty())
            {
                Node t=q.remove();
               
                // performing operation on left subtree
                if(t.left==null)
                {
                    t.left=new Node();
                    t.left.data=x;
                    q.clear();
                    return;   // exit after this point of time
                }
                else
                {
                    q.add(t.left);
                }
                
                // performing operations on right subtree
                if(t.right==null)
                {
                    t.right=new Node();
                    t.right.data=x;
                    q.clear();
                    return;
                }
                else
                {
                    q.add(t.right);
                }
                
            }
        }
    }
 
     // Preorder traversal 
    
    public void rPreOrder()
    {
        System.out.println("\nRecursive Preorder traversal :");
        rPreOrder(root);
        
        System.out.println("\nEextended Preorder traversal :");
        ExtendedPreOrder(root);
        
    }
    
    public void rPreOrder(Node r)   // VLR
    {
        if(r==null)
            return;
       System.out.print(r.data+"  "); 
        rPreOrder(r.left);
        rPreOrder(r.right);
    }
    
     public void ExtendedPreOrder(Node r)   // VLR
    {
         if(r==null)
             return;
         
            System.out.print(r.data+"  "); 
       
//       if(r.left!=null)
//         rPreOrder(r.left);
//       
//       if(r.right!=null)
//        rPreOrder(r.right);
       
       if(r.left!=null && r.right!=null)
       {
           r.left.nextRight=r.right;
           r.right.nextRight=null;
            rPreOrder(r.left);
       }
       else if(r.left==null && r.right!=null)
       {
           r.right.nextRight=null;
            rPreOrder(r.right);
       }
       else
       {
           r.nextRight=null;
       }
    }
     
     public void LevelOrder()
    {
        System.out.println("\nLevel Order traversal using 1 queue:");
        LevelOrderUsingQueue(root);
    }

    public void LevelOrderUsingQueue(Node r)
    {
        if(r==null)
            return;
        
        Queue<Node> q=new LinkedList<>();
        
        q.add(r);
        
        while(!q.isEmpty())
        {
            Node p=q.remove();
            
           // System.out.print(p.data+"  ");
            
            if(p.nextRight==null)
                System.out.println(p.data+"-->  NULL  ");
            else
                System.out.println(p.data+"-->  "+p.nextRight.data);
            
             if(p.left!=null)
                q.add(p.left);
             
            if(p.right!=null)
                q.add(p.right);
           
            
        }
    }
}


public class ConnectSameLevelNodes {

  
    public static void main(String[] args) {
         BinaryTree ob=new BinaryTree();
        ob.insert(1);
        ob.insert(2);
        ob.insert(3);
        ob.insert(4);
        ob.insert(5);
        ob.insert(6);
        ob.insert(7);
        
        ob.rPreOrder();
        ob.LevelOrder();
    }
}
