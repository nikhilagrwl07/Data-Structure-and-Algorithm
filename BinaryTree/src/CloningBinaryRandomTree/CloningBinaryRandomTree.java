/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CloningBinaryRandomTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CloningBinaryRandomTree {
    
    public static void main(String[] args) {
    Node tree = new Node(1);
//    tree.left = new Node(2);
//    tree.right = new Node(3);
//    tree.left.left = new Node(4);
//    tree.left.right = new Node(5);
//    tree.random = tree.left.right;
//    tree.left.left.random = tree;
//    tree.left.right.random = tree.right;

// 2nd test case
    tree.left = new Node(2);
        tree.right = new Node(3);
        tree.random = tree.right;
        tree.left.random = tree;
    
    BinaryTree bt=new BinaryTree(tree);
    bt.printInorder(tree);

        System.out.println("clone treee-----------");

      //  bt.copyLeftRightNode(tree, null);
      //    bt.cloneTree(tree);
       // Node clone=bt.cloneTree(tree);
        bt.printInorder(bt.cloneTree(tree));
    }


}

class BinaryTree
{
    Node root;
    public BinaryTree(Node p)
    {
        root=p;
    }
    
    
    public void printInorder(Node t)
    {
        if(t==null)
            return;
        
        printInorder(t.left);
        int r=-1;
        if(t.random!=null)
            r=t.random.data;
        System.out.print(t.data + " " + r);
        System.out.println();
        printInorder(t.right);
        
    }

    public void copyLeftRightNode(Node t,HashMap<Node,Node> h)
    {
        if(t==null)
            return ;
        if(t!=null)
        {
        Node cloneNode=new Node(t.data);
        cloneNode.left=t.left;
        cloneNode.right=t.right;
        h.put(t, cloneNode);
        
        copyLeftRightNode(t.left, h);
        copyLeftRightNode(t.right, h);
        }
    }

    public void copyRandom(Node t,Node clone,HashMap<Node,Node> h)
    {
        if(clone==null)
            return;
        clone.random=h.get(t.random);
        copyRandom(t.left, clone.left, h);
        copyRandom(t.right, clone.right, h);
    }


    public Node cloneTree(Node root)
    {
        if(root==null)
            return null;
        Node p=root;
        HashMap<Node,Node> h=new HashMap<Node,Node>();
        copyLeftRightNode(p, h);
        copyRandom(p, h.get(p), h);
        return h.get(root);
    }
    
    
    
}


class Node
{
    int data;
    Node left;
    Node right;
    Node random;

    public Node(int data) {
        this.data = data;
        this.left=null;
        this.right=null;
        this.random=null;
    }


}
