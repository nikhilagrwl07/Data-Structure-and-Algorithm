
package BT2DLL;

import java.util.LinkedList;
import java.util.Queue;


public class BTLeafNodeToDLL {

    public static void main(String[] args) {

          Tree t=new Tree();
         t.root = new Node(1);
        t.root.left = new Node(2);
        t.root.right = new Node(3);
        t.root.left.left = new Node(4);
        t.root.left.right = new Node(5);
        t.root.right.left = new Node(6);
        t.root.right.right = new Node(7);

        t.levelOrderQueue(t.root);
        
        t.leafToDll(t.root, null,false,false);
        
        System.out.println("\nPrinting LL...");
        t.printLeafToDll(t.headStart);

        System.out.println("\nInorder traversal after pruning the....");
        t.rInorder(t.root);
       // System.out.println("the given tree is bst " + t.checkBST(t.root));


    }



}

class Tree{
    
    Node root;
    Node head;
    Node headStart;
    
    public void leafToDll(Node node , Node parentOfRoot, boolean l , boolean r)
    {
      // Node1 headStart=null;
        if(node==null)
            return ;
        
        if(node.left==null && node.right==null)
        { 
            if(head==null)
            {
                head=node;
                headStart=head;

                if(parentOfRoot!=null && l)
                {
//                    System.out.println("Check 1 "  + parentOfRoot.left.data);
                   parentOfRoot.left=null;
                }
                else if(parentOfRoot!=null && r)
                {
//                     System.out.println("Check 2 " + parentOfRoot.right.data);
                     parentOfRoot.right=null;
                }
            }
            else if(head!=null)
            {
                
                node.left=head;
                head.right=node;
                if(parentOfRoot!=null && l)
                {
//                    System.out.println("Check 1 "  + parentOfRoot.left.data);
                   parentOfRoot.left=null;  
                }
                else if(parentOfRoot!=null && r)
                {
//                     System.out.println("Check 2 " + parentOfRoot.right.data);
                     parentOfRoot.right=null; 
                }

              //  node.right=null;
                head=node;
            }

          return;
        }
      leafToDll(node.left, node,true,false);
      leafToDll(node.right,node,false,true);
    }

    public  void printLeafToDll(Node node)
    {
        while(node!=null)
        {
            System.out.print(node.data + " ");
            node=node.right;
        }
    }

public void levelOrderQueue(Node root)
{
    if(root==null)
        return;
    
      
    Queue<Node> q=new LinkedList<Node>();
   
    q.add(root);
   
  
   while(!q.isEmpty())
    { 
        
        Node tt=(Node) q.remove();   
       
        
        System.out.print(tt.data+"  ");
        
        if(tt.left!=null)
            q.add(tt.left);
        
        if(tt.right!=null)
            q.add(tt.right);    
        
    }

}

    
    
    public void rInorder(Node root)
    {
        if(root==null) return;

        rInorder(root.left);
        System.out.println(root.data);
        rInorder(root.right);
    }
    
}



class Node
{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }


}