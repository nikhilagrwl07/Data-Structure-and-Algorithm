/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BT2DLL;

/**
 *
 * @author nikhil.agrawal
 */
public class BT2DLL {
     public static void main(String[] args) {
        
         Node1 r4 = new Node1(4, null, null);
         Node1 r5 = new Node1(5, null, null);
         Node1 r2 = new Node1(2, r4, r5);
         Node1 r6 = new Node1(6, null, null);
         Node1 r7 = new Node1(7, null, null);
         Node1 r3 = new Node1(3, r6, r7);
         
         Node1 root = new Node1(1, r2, r3);
        
         Node1 DLL_head = bt2DLL(root);
         
         printDLL(DLL_head);
         
    }
     
     
     public static Node1 bt2DLL(Node1 root)
     {
         
         if(root==null) return root;
         
         Node1 r = bt2DLLUtil(root);
         
         while(r.left!=null)
         {
             r=r.left;
         }
         
         return r;
     }
 
     @SuppressWarnings("empty-statement")
     static Node1 bt2DLLUtil(Node1 root){
         
        
         if(root==null) 
             return root;
         
         
         
         if(root.left!=null)
         {
             // traversing to left most node of the tree
             Node1 left=bt2DLLUtil(root.left);
             
             // finding the inorder predecessor of the root
             for(;left.right!=null;left=left.right);
             
             
             // connecting  the root and left most 
             left.right=root;
             root.left=left;
             
         }
         
          if(root.right!=null)
         {
             // traversing to right most node of the tree
             Node1 right=bt2DLLUtil(root.right);
             
             // finding the inorder successor of the root
             for(;right.left!=null;right=right.left);
             
             
             // connecting  the root and left most 
             right.left=root;
             root.right=right;
         }
         return root;
    }
    
    public static void printDLL(Node1 r){
        if(r==null) return;
        
        Node1 p = r;
        
        System.out.println("Priting DLL ");
        while(p!=null)
        {
            System.out.print(p.data+ "  ");
            p=p.right;
        }
        
    }
    

}










class Node1
{
    int data;
    Node1 left;
    Node1 right;
     
    public Node1(int v)
    {
        this.data=v;
    }

    public Node1(int data, Node1 left, Node1 right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    
    
}