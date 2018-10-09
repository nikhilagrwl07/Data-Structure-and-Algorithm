
package BST2CDLL;

public class BST2CDLL{
     // Demonstrate tree->list with the list 1..5
    public static void main(String[] args) {
    
        // first build the tree shown in the problem document
        // http://cslibrary.stanford.edu/109/
        //http://cslibrary.stanford.edu/109/TreeListRecursion.html#java


        BTOperation ob=new BTOperation();
        Node root = new Node(4);
        ob.treeInsert(root, 2);
        ob.treeInsert(root, 1);
        ob.treeInsert(root, 3);
        ob.treeInsert(root, 5);
        ob.treeInsert(root, -1);
        ob.treeInsert(root, 6);

        //-------------------------------------------
//      BTOperation ob=new BTOperation();
//        Node root = new Node(15);
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

//        System.out.println("Inorder traversal:");
//        ob.inOrderTree(root);
        
//        int l=3,r=5;
//        System.out.println("Values within "+l+" to "+ r +" : ");
//        Node p=root;
//        ob.printRange(p,l,r);
//        System.out.println("Height of node 4 = "+ob.height(root));
        
//        System.out.println("list:");
//        Node head = ob.treeToList(root);
//        ob.printList(head);

//        if(ob.isbalanced(root))
//            System.out.println("BST is height balanced BST");
//        else
//               System.out.println("BST is NOT height balanced BST");

//        if(ob.isBinaryTreeBalance(root, new Height()))
//            System.out.println("BST is height balanced BST");
//        else
//            System.out.println("BST is NOT height balanced BST");

       //  Converting sorted array to BST
        int a[]={1,2,3,4,5,6,7,8};

        Node start=ob.arrayToBST(a,0,a.length-1);
        System.out.println("Inorder traversal:");
        ob.inOrderTree(start);
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

     /*
     helper function -- given two list nodes, join them
     together so the second immediately follow the first.
     Sets the .next of the first and the .previous of the second.
    */
    public void join(Node a, Node b) {
        a.large = b;
        b.small = a;
    }

    
    /*
     helper function -- given two circular doubly linked
     lists, append them and return the new list.
    */
    public Node append(Node a, Node b) {

        // if either is null, return the other
        if (a==null) return(b);
        if (b==null) return(a);
        
        // find the last node in each using the previous pointer
        Node aLast = a.small;
        Node bLast = b.small;
        
        // join the two together to make it connected and circular
        join(aLast, b);
        join(bLast, a);
        
        return(a);
    }

    
    /*
     --Recursion--
     Given an ordered binary tree, recursively change it into
     a circular doubly linked list which is returned.
    */
    public Node treeToList(Node root) 
    {
        // base case: empty tree -> empty list
        if (root==null) 
            return (null);
        
        // Recursively do the subtrees (leap of faith!)
        Node aList = treeToList(root.small);
        Node bList = treeToList(root.large);
        
        // Make the single root node into a list length-1
        // in preparation for the appending
        root.small = root;
        root.large = root;
        
        // At this point we have three lists, and it's
        // just a matter of appending them together
        // in the right order (aList, root, bList)
        
       aList = append(aList, root);
       aList=append(aList, bList);
       return(aList);
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

    // postorder travseral of tree
    public void inOrderTree(Node root)
    {
        if(root==null) return;
        
        
        inOrderTree(root.small);
        System.out.print(root.data+"  ");
        inOrderTree(root.large);
        
    }
    
     // Do a traversal of the list and print it out
    public int countNodes(Node head) {
            int count=0;
        Node current = head;
        
        while (true) {
            //System.out.print(current.data + " ");
            current = current.large;
            count++;
            if (current == head)
                break;
        }
        
       return count;
    }
    
    // Do a traversal of the list and print it out
    public void printList(Node head) {
        Node current = head;
        
        while (true) {
            System.out.print(current.data + " ");
           
            current = current.large;
            
            if (current == head)
                break;
        }
        
        System.out.println();
    }
    
  
    public int height(Node root)
    {
       if(root==null) return 0;
       
       return 1+Math.max(height(root.small),height(root.large));
    }
    
    // function to check whether given BST is height balanaced BST or not
    //O(n^2) complexity because at node we try to find balancing as well as height of that node so
    //each node is visited twice.
    public boolean isbalanced(Node root)
    {
            
       if(root==null)       
       {
           // returning true because the empty BST is always height balanced BST         
           return true;
       }
       // if difference between left and right subtree is greater than 2 then it is not a balanced
       return (isbalanced(root.small) && isbalanced(root.large) && Math.abs(height(root.small)-height(root.large))<=1);
       
       
    }

    //O(n) Time complexity as calculating height in same recursion
    public boolean isBinaryTreeBalance(Node root, Height height){

        if(root==null)
            return true;

        Height leftSubTreeHeight= new Height(), rightSubTreeHeight = new Height();

        boolean isleftSubtreeBalanced = isBinaryTreeBalance(root.small, leftSubTreeHeight);
        boolean isrightSubtreeBalanced = isBinaryTreeBalance(root.large, rightSubTreeHeight);

        height.height=Math.max(leftSubTreeHeight.height,rightSubTreeHeight.height)+1;

        if(Math.abs(leftSubTreeHeight.height - rightSubTreeHeight.height)>=2)
            return false;

        return isleftSubtreeBalanced && isrightSubtreeBalanced;
    }


    // converting an sorted array to BST
    public Node arrayToBST(int[] arr,int s,int e)
    {
        if(e<s) 
            return null;
        
        int mid=s+(e-s)/2;
        
        Node root=new Node(arr[mid]);
        
        root.small=arrayToBST(arr, s, mid-1);
        root.large=arrayToBST(arr, mid+1, e);
        
        return root;
        
    }
    
    // Print all values of BST in range between k1 and k2
    public void printRange(Node r,int k1,int k2)
    {
        if(r==null) return ;
        
        if(r.data<k1)
             printRange(r.large,k1,k2);
        if(r.data>=k1 && r.data<=k2)
        {
             printRange(r.small,k1,k2);
            System.out.println(r.data);
            printRange(r.large,k1,k2);
        }
        if(r.data>k2)
             printRange(r.small,k1,k2);
        
       }


}
