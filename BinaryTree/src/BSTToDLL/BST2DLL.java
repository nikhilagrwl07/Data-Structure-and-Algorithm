
package BSTToDLL;

public class BST2DLL{    
     // Demonstrate tree->list with the list 1..5
    public static void main(String[] args) {
 
        
        //-------------------------------------------
      BTOperation ob=new BTOperation();
        Node root = new Node(15);
       ob.treeInsert(root,16);
       ob.treeInsert(root,18);
       ob.treeInsert(root,17);
       ob.treeInsert(root,20);
       ob.treeInsert(root,6);
       ob.treeInsert(root,7);
       ob.treeInsert(root,3);
       ob.treeInsert(root,13);
       ob.treeInsert(root,9);
       ob.treeInsert(root,2);
       ob.treeInsert(root,4);
        //-------------------------------------------
       
       
//        System.out.println("tree:");
//        ob.inOrderTraversal(root);   // 1 2 3 4 5
//        System.out.println();
//        
         
        System.out.println("Inorder traversal of tree:");
        ob.inOrderTree(root);

     System.out.println("DLL traversal:");
        Node head = ob.treeToDLL(root);
        ob.printList(head);   // 1 2 3 4 5   yay!
    
    }
}

class Node
{
    int data;
    Node small;
    Node large;
     
    public Node(int v)
    {
        this.data=v;
    }
}

class BTOperation {
    
// Source: http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/        
    public Node treeToDLLUtil(Node rt)
    {
        if(rt==null)
            return rt;
        
        // recurse in left subtree and find inorder predeccessor to make connect to root
        if(rt.small!=null)
        {
            // convert the left subtree to DLL
            Node left=treeToDLLUtil(rt.small);
            
            // find the inorder predecssor of root of left subtree
            while(left.large!=null)
            {
                left=left.large;
            }
            
            // Now left conatins the inorder predecessor of root
            left.large=rt;
            rt.small=left;
        }
        
         // recurse in right subtree and find inorder successor to make connect to root
        if(rt.large!=null)
        {
            // convert the right subtree to DLL
            Node right=treeToDLLUtil(rt.large);
            
            // find the inorder successor of root of left subtree
            while(right.small!=null)
            {
                right=right.small;
            }
            
            // Now right conatins the inorder successor of root
            right.small=rt;
            rt.large=right;
        }
        
        return rt;
        
    }
    /*
     --Recursion--
     Given an ordered binary tree, recursively change it into
     a  doubly linked list which is returned.
    */
    public Node treeToDLL(Node root) 
    {
        // base case: empty tree -> empty list
        if (root==null) 
            return (null);
        

        // Recursively convert Tree to DLL NOT CDLL
        Node rt = treeToDLLUtil(root);
              
        
        // finding the leftmost of tree to pass to print the DLL
        while(rt.small!=null)
            rt=rt.small;
        
        return(rt);
    }


    /*
     Given a non-empty tree, insert a new node in the proper
     place. The tree must be non-empty because Java's lack
     of reference variables makes that case and this
     method messier than they should be.
    */
    public void treeInsert(Node root, int newData) {
        if (newData<=root.data)
        {
            if (root.small!=null) 
                treeInsert(root.small, newData);
            else 
                root.small = new Node(newData);
        }
        else 
        {
            if (root.large!=null) 
                treeInsert(root.large, newData);
            else
                root.large = new Node(newData);
        }
    }
    
    
    // Do an inorder traversal to print a tree
    // Does not print the ending "\n"
    public void printTree(Node root) {
        if (root==null) return;
        printTree(root.small);
        System.out.print(root.data+ " ");
        printTree(root.large);
    }
    
    
    // postorder travseral of tree
    public void inOrderTree(Node root)
    {
        if(root==null) return;
        
        
        inOrderTree(root.small);
        System.out.print(root.data+"  ");
        inOrderTree(root.large);
        
    }
    

    
    // Do a traversal of the list and print it out
    public void printList(Node head) {
        Node current = head;
        
        while (current!=null) {
            System.out.print(current.data + " ");
           
            current = current.large;
            
        }
        
        System.out.println();
    }
    

}
