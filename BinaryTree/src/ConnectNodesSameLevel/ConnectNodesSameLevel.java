
package ConnectNodesSameLevel;

import java.util.LinkedList;
import java.util.Queue;


public class ConnectNodesSameLevel{
     // Demonstrate tree->list with the list 1..5
    public static void main(String[] args) {
    
        // first build the tree shown in the problem document
        // http://cslibrary.stanford.edu/109/
        //http://cslibrary.stanford.edu/109/TreeListRecursion.html#java
        
        
//        BTOperation obj=new BTOperation();
//        Node root = new Node(4);
//        obj.treeInsert(root, 2);
//        obj.treeInsert(root, 1);
//        obj.treeInsert(root, 3);
//        obj.treeInsert(root, 5);
//        obj.treeInsert(root, -1);
//        obj.treeInsert(root, 6);
        
        //-------------------------------------------
      BTOperation ob=new BTOperation();
        Node root = new Node(15);
         ob.treeInsert(root,17);
     //  ob.treeInsert(root,16);
       ob.treeInsert(root,19);
       ob.treeInsert(root,18);
       ob.treeInsert(root,20);
       ob.treeInsert(root,6);
       ob.treeInsert(root,8);
       ob.treeInsert(root,7);
       ob.treeInsert(root,3);
      // ob.treeInsert(root,13);
      // ob.treeInsert(root,9);
       ob.treeInsert(root,2);
      // ob.treeInsert(root,4);
//       ob.treeInsert(root,22);
        //-------------------------------------------
       
       
        //System.out.println("tree:");
//        ob.inOrderTraversal(root);   // 1 2 3 4 5
//        System.out.println();
        
         
//        System.out.println("Inorder traversal:");
//        ob.inOrderTree(root);
//        
//        System.out.println("Level order traversal:");
//        ob.levelOrderTraversla(root);
         root.rightnext=null;
        ob.connectNodesAllTrees(root);
        
        
       // System.out.println("\nPrint right next:");
      //  ob.connectNodesSameLevel(root);
       // root.rightnext=null;
        
      //  ob.connectNodeRightPreOrder(root);
        
//        ob.printNextRight(root);

      
    
    }
}

class Node
{
    int data;
    Node small;
    Node large;
    Node rightnext;
    
    public Node(int v)
    {
        this.data=v;
    }

}

class BTOperation {

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
    
    
    // Inorder travseral of tree
    public void inOrderTree(Node root)
    {
        if(root==null) return;
        
        
        inOrderTree(root.small);
        System.out.print(root.data+"  ");
        inOrderTree(root.large);
        
    }
    
    
    
    // Iterartive Level Order traversal
    public void levelOrderTraversla(Node root)
    {
        if(root==null) return;
        
        Node rt=root;
        Queue<Node> q=new LinkedList();
        
        q.add(rt);

        while(!q.isEmpty())
        {
            Node t=q.remove();
           
            System.out.print(t.data+" ");
                
                if(t.small!=null)
                    q.add(t.small);
                
                if(t.large!=null)
                    q.add(t.large);
        }
    }
    
    
    // Connecting nodes at same level using level order traversal
public void connectNodesSameLevel(Node root)
{
    if(root==null) return;

    Node rt=root;
    Queue<Node> q=new LinkedList();

    Node temp=new Node(-1);
    Node x=null;
    q.add(rt);
    q.add(temp);

    while(true)
    {
        Node t=q.remove();

        while(t.data!=-1)
        {
            x=q.remove();

            if(x.data==-1)
                t.rightnext=null;
            else
                t.rightnext=x;

            if(t.small!=null)
                q.add(t.small);

            if(t.large!=null)
                q.add(t.large);

            t=x;
            x=null; 
        }

        if(q.isEmpty())
            break;

        q.add(temp);
    }
}
   

// Recursive implementation for nextRight of each node
// set nextRight for every node else than root node
// This method works only for complete Binary tree
public void connectNodeRightPreOrder(Node root)
{
    if(root==null)
        return;
    
    if(root.small!=null)
    {
        root.small.rightnext=(root.large==null?null:root.large);
    }
    
    if(root.large!=null)
    {
        if(root.rightnext==null)
        {
        root.large.rightnext=null;
        }
        else
        {
        root.large.rightnext=root.rightnext.small==null?null:root.rightnext.small;
        }
        
    }
    
    connectNodeRightPreOrder(root.small);
    connectNodeRightPreOrder(root.large);
}

// Recursive Solution for connecting nodes
// Space complexity - O(1)
// Works for all kind of tree (NOT only for complete binary tree)

    public void connectNodesAllTrees(Node rt)
    {
        if(rt==null)
            return;
        
        // before setting nextright of all cildren set for current level
        if(rt.rightnext!=null)
            connectNodesAllTrees(rt.rightnext);
        
        
        // set nextright pointer of root's left child
        if(rt.small!=null)
        {
            if(rt.large!=null)
            {
                rt.small.rightnext=rt.large;
                rt.large.rightnext=getNextRight(rt);
            }
            else
            {
                rt.small.rightnext=getNextRight(rt);
            }
             connectNodesAllTrees(rt.small);
        }
        else if(rt.large!=null)
        {
            rt.large.rightnext=getNextRight(rt);
            connectNodesAllTrees(rt.large);
        }
        else
            connectNodesAllTrees(getNextRight(rt));
    }
    
    
    public Node getNextRight(Node t)
    {
        if(t==null) 
            return null;
        
        Node temp=t.rightnext;
        
        while(temp!=null)
        {
            if(temp.small!=null)
                return temp.small;
            
            if(temp.large!=null)
                return temp.large;
            
        temp=temp.rightnext;
        }
        
        return null;
    }

    // performing Inorder traversal
    public void printNextRight(Node root)
    {
        
        if(root==null) return;
        
        Node rt=root;
        Queue<Node> q=new LinkedList();
        
        Node temp=new Node(-1);
        
        q.add(rt);
        q.add(temp);
        
        while(true)
        {
            Node t=q.remove();
           
            while(t.data!=-1)
            {
                if(t.rightnext!=null)
                    System.out.println(t.data+"-->"+t.rightnext.data);
                else
                    System.out.println(t.data+"--> null");
                
               // System.out.print(t.data+" ");
                
                if(t.small!=null)
                    q.add(t.small);
                
                if(t.large!=null)
                    q.add(t.large);
                
                q.add(temp);
                
                t=q.remove();
            }
            
            if(q.isEmpty())
                break;
            
        }
        
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
    // NOTE: for impleneting this with O(n) complexity in java is NOT possible without 
    //using wrapper class
    public boolean isbalanced(Node root)
    {
            
       if(root==null)       
       {
           // returning true because the empty BST is always height balanced BST         
           return true;
       }           
             System.out.println("for node "+root.data+": Left height= "+height(root.small)+": Right height= "+height(root.large));   //Math.abs(height(root.small)-height(root.large)));
       // if difference between left and right subutree is greater than 2 then it is not a balanced
       return (isbalanced(root.small) && isbalanced(root.large) && Math.abs(height(root.small)-height(root.large))<=1);
       
       
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
