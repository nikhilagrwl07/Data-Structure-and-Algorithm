/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BinaryTreeToDLL;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToDLL {
     public static void main(String[] args) {

         Node root = new Node(1);
         Node temp2 = new Node(2);
         Node temp4 = new Node(4);
         Node temp6 = new Node(6);
         Node temp7 = new Node(7);

         Node temp3 = new Node(3);
         Node temp5 = new Node(5);
         Node temp8 = new Node(8);
         Node temp9 = new Node(9);

         //-------------------------------
         Node temp11 = new Node(11);
         Node temp12 = new Node(12);
         Node temp13 = new Node(13);
         Node temp14 = new Node(14);
         Node temp15 = new Node(15);
         //-------------------------------

         BinaryTreeToDLL obj = new BinaryTreeToDLL();

         obj.insert(root, 2);
         obj.insert(root, 3);
         obj.insert(root, 4);
         obj.insert(root, 5);
         obj.insert(root, 6);
         obj.insert(root, 7);
         obj.insertAtposition(root,temp7, 8);
         obj.insertAtposition(root, temp5, 10);
         obj.insertAtposition(root, temp6, 20);

         obj.insertAtposition(root,temp8, 9);
         obj.insertAtposition(root,temp8, 10);
         obj.insertAtposition(root,temp5, 12);

         

         BinaryTreeToDLL treeToDLL = new BinaryTreeToDLL();
         Node headNodeOfDLL = treeToDLL.binaryTreeToDLL(root);
         printDLL(headNodeOfDLL);
         
    }
     
     
     public Node binaryTreeToDLL(Node root)
     {
         if(root==null)
             return root;
         
         Node r = binaryTreeToDLLUtil(root);
         
         while(r.left!=null)
         {
             r=r.left;
         }
         
         return r;
     }

    // Source: http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/        
    public Node binaryTreeToDLLUtil(Node root)
    {
        if(root==null)
            return null;

        // recurse in left subtree and find inorder predecessor of root
        if(root.left!=null)
        {
            // convert the left subtree to DLL
            Node left=binaryTreeToDLLUtil(root.left);

            // find the inorder predecessor of root of left subtree
            while(left.right!=null)
            {
                left=left.right;
            }

            // Now left contains the inorder predecessor of root
            left.right=root;
            root.left=left;
        }

        // recurse in right subtree and find inorder successor to make connect to root
        if(root.right!=null)
        {
            // convert the right subtree to DLL
            Node right=binaryTreeToDLLUtil(root.right);

            // find the inorder successor of root of left subtree
            while(right.left!=null)
            {
                right=right.left;
            }

            // Now right conatins the inorder successor of root
            right.left=root;
            root.right=right;
        }

        return root;

    }
    
    public static void printDLL(Node r){
        if(r==null) return;
        
        Node p = r;
        
        System.out.println("Priting DLL ");
        while(p!=null)
        {
            System.out.print(p.data+ "  ");
            p=p.right;
        }
        
    }

    Queue<Node> queue = new LinkedList();

    // Insert Operation
    public void insert(Node root, int x) {
        if (root == null) {
            root = new Node(x);

        } else {
            queue.add(root);

            while (!queue.isEmpty()) {
                Node t = queue.remove();

                if (t.left == null) {
                    t.left = new Node(x);
                    queue.clear();
                    return;
                } else {
                    queue.add(t.left);
                }

                if (t.right == null) {
                    t.right = new Node(x);
                    queue.clear();
                    return;
                } else {
                    queue.add(t.right);
                }
            }
        }
    }

    public void insertAtposition(Node root, Node position, int x) {
        if (position == null || root == null)
            return;
        else {
            if (root.data == position.data) {
                if (root.left == null)
                    root.left = new Node(x);

                else if (root.right == null)
                    root.right = new Node(x);
            } else {
                Queue<Node> qwe = new LinkedList<Node>();
                qwe.add(root);
                Node t;
                while (!qwe.isEmpty()) {
                    t = (Node) qwe.remove();

                    if (t.data == position.data) {
                        if (t.left == null) {
                            t.left = new Node(x);
                            break;
                        } else if (t.right == null) {
                            t.right = new Node(x);
                            break;
                        }

                        break;
                    }
                    if (t.left != null)
                        qwe.add(t.left);
                    if (t.right != null)
                        qwe.add(t.right);
                }
            }
        }
    }
    

}