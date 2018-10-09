
package TernaryTree2DLL;



public class TernaryTree2DLL{    
     // Demonstrate tree->list with the list 1..5
    public static void main(String[] args) {
 
        
        //-------------------------------------------
      BTOperation ob=new BTOperation();
        
        TernaryTreeNode r5 = new TernaryTreeNode(5);
        TernaryTreeNode r6 = new TernaryTreeNode(6);
        TernaryTreeNode r7 = new TernaryTreeNode(7);
        TernaryTreeNode r8 = new TernaryTreeNode(8);
        TernaryTreeNode r9 = new TernaryTreeNode(9);
        TernaryTreeNode r10 = new TernaryTreeNode(10);
        TernaryTreeNode r11 = new TernaryTreeNode(11);
        TernaryTreeNode r12 = new TernaryTreeNode(12);
        TernaryTreeNode r13 = new TernaryTreeNode(13);
        
        TernaryTreeNode r2 = new TernaryTreeNode(2,r5,r6,r7);
        TernaryTreeNode r3 = new TernaryTreeNode(3,r8,r9,r10);
        TernaryTreeNode r4 = new TernaryTreeNode(4,r11,r12,r13);
        TernaryTreeNode root = new TernaryTreeNode(1, r2, r3, r4);
        
        
//       ob.treeInsert(root,16);
//       ob.treeInsert(root,18);
//       ob.treeInsert(root,17);
//       ob.treeInsert(root,20);
//       ob.treeInsert(root,6);
//       ob.treeInsert(root,7);
//       ob.treeInsert(root,3);
//       ob.treeInsert(root,13);
//       ob.treeInsert(root,9);
//       ob.treeInsert(root,2);
//       ob.treeInsert(root,4);
        //-------------------------------------------
       
       
        System.out.println("tree:");
//        ob.inOrderTraversal(root);   // 1 2 3 4 5
//        System.out.println();
        
         
        System.out.println("Inorder traversal of tree:");
        ob.inOrderTree(root);

     
      TernaryTreeNode head = ob.treeToList(root); //    treeToDLL(root);
//        TernaryTreeNode head = ob.toList(root);
      System.out.println("DLL traversal: ");
        ob.printList(head);   // 1 2 3 4 5   yay!
    
    }
}

class TernaryTreeNode
{
    int data;
    TernaryTreeNode left;
    TernaryTreeNode middle;
    TernaryTreeNode right;
     
    public TernaryTreeNode(int v)
    {
        this.data=v;
    }

    public TernaryTreeNode(int v , TernaryTreeNode small, TernaryTreeNode middle , TernaryTreeNode large) {
        this.data=v;
        this.left = small;
        this.middle = middle;
        this.right=large;
    }
    
}

class BTOperation {

       public TernaryTreeNode treeToList(TernaryTreeNode root) 
    {
        // base case: empty tree -> empty list
        if (root==null) 
            return(null);
        
        // Recursively do the subtrees (leap of faith!)
        TernaryTreeNode aList = treeToList(root.left);
        TernaryTreeNode bList = treeToList(root.middle);
        TernaryTreeNode cList = treeToList(root.right);
        
        // Make the single root node into a list length-1
        // in preparation for the appending
        root.left = root;
        root.right = root;
        
        // At this point we have three lists, and it's
        // just a matter of appending them together
        // in the right order (aList, root, bList)
         
         aList=append(aList, bList);
         aList=append(aList, cList);
         aList = append(aList,root );
      
         
       // root = append(root, bList);
       
        
        return(aList);
    }

       
        public TernaryTreeNode append(TernaryTreeNode a, TernaryTreeNode b) 
        {
        // if either is null, return the other
        if (a==null) return(b);
        if (b==null) return(a);
        
        // find the last node in each using the .previous pointer
        TernaryTreeNode aLast = a.left; //  small;
        TernaryTreeNode bLast = b.left; //  small;
        
        // join the two together to make it connected and circular
        join(aLast, b);
        join(bLast, a);
        
        return(a);
    }
        
  public void join(TernaryTreeNode a, TernaryTreeNode b) {
        a.right = b;
        b.left = a;
    }



    /*
     Given a non-empty tree, insert a new node in the proper
     place. The tree must be non-empty because Java's lack
     of reference variables makes that case and this
     method messier than they should be.
    */
    public void treeInsert(TernaryTreeNode root, int newData) {
        if (newData<=root.data)
        {
            if (root.left!=null) 
                treeInsert(root.left, newData);
            else 
                root.left = new TernaryTreeNode(newData);
        }
        else 
        {
            if (root.right!=null) 
                treeInsert(root.right, newData);
            else
                root.right = new TernaryTreeNode(newData);
        }
    }
    
    
    // Do an inorder traversal to print a tree
    // Does not print the ending "\n"
    public void printTree(TernaryTreeNode root) {
        if (root==null) return;
        printTree(root.left);
        System.out.print(root.data+ " ");
        printTree(root.right);
    }
    
    
    // postorder travseral of tree
    public void inOrderTree(TernaryTreeNode root)
    {
        if(root==null) return;
        
        
        inOrderTree(root.left);
        inOrderTree(root.middle);
        inOrderTree(root.right);
        System.out.print(root.data+"  ");
        
    }
    

    
    // Do a traversal of the list and print it out
    public void printList(TernaryTreeNode head) {
//        System.out.println(" head :: " + head.right.right.data);
        TernaryTreeNode current = head;
        
        while (true) 
        {
            System.out.print(current.data + " ");
           
            current = current.right;
            
            if(current==head)
            {
                break;
            }
        }
        
        System.out.println();
    }
    

}
