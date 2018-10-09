
package DLL2BST;

class Node
{
    int data;
    Node prev=null;
    Node next=null;
     
     public Node()
    {
        
    }
     
    public Node(int v)
    {
        this.data=v;
    }

}

class operation
{
    // adding the node to start of a doubly linked list
    Node h=null;
    
    public void root(int x)
    {        
      h=new Node(x);
    }
    
    public void push(int a)
    {
        Node newNode=new Node(a);
        
        // since putting the node at the starting means prev will always be null 
        newNode.prev=null;
        
        // since putting the node at the starting means next will always point to the head 
        newNode.next=h;
        
        //changing prev pointer of head node
        if(h!=null)
        {
            h.prev=newNode;
        }
        
        // Move the head to point to the start of the LL
        h=newNode;
    }
    
    // printing DLL
    public void printList()
    {
        if(h==null) return;
     
        Node temp=h;
       // Node tempPrevious=null;
        System.out.println("List: ");
        
        while(temp!=null)
        {
            System.out.print(temp.data+"  ");
           // tempPrevious=temp;
            temp=temp.next;
        }
        
//        System.out.println("Reverse printing ");
//        
//        while(tempPrevious!=null)
//        {
//            System.out.print(tempPrevious.data+"  ");
//           // tempPrevious=temp;
//            tempPrevious=tempPrevious.prev;
//        }
    }
    
      // Do an inorder traversal to print a tree
    // Does not print the ending "\n"
    public void printTree(Node root) {
        if (root==null)
            return;
        
        printTree(root.prev);
        System.out.print(root.data+ " ");
        printTree(root.next);
    }
    
    public int countNodes()
    {
        Node r=h;
        
        int x=0;
        
        while(r!=null)
        {
            x++;
            r=r.next;
        }
        
        return x;
    }
    
    
    public Node sortedListToBst()
    {
        Node temp=h;
        int n=countNodes();
       
//       return formBalancedBST_inPlace_nlogn(temp,n);
    return formBalancedBST_outPlace_n(temp);
    }
   
    
    // In place conversion of DLL to Balanced BST
   // Space Complexity : O(1)  
   // Time complexity: O(nlogn)   
    //In-place conversion of Sorted DLL to Balanced BST
    // The tree must be constructed in-place (No new DoublyLinkedNode should be
    //allocated for tree conversion)
    public Node formBalancedBST_inPlace_nlogn(Node head,int n)
    {
        // Base case
        if(n<=0)
            return null;
        
         else if(n==1)
         {
            head.next = null;
            head.prev = null;
            return head;
         }
        
         int i=1;
         Node current = head;
        
         while(i <= n/2)
         {
            current = current.next;
            i++;
         }
          current.prev= formBalancedBST_inPlace_nlogn(head, i-1);
          current.next = formBalancedBST_inPlace_nlogn(current.next, n-i);
                
          return current;
    }
    
    
    // Out place conversion of DLL to Balanced BST
     // Space Complexity- O(n)
     // Time complexity -O(n)
    // Out-place but O(n)time complexity
// source :: http://www.programcreek.com/2013/01/leetcode-convert-sorted-list-to-binary-search-tree-java/
    public Node formBalancedBST_outPlace_n(Node headOfLL)
    {
        if (headOfLL == null)
		return null;
 
		h = headOfLL;
		int len = getLength(headOfLL);
                
		return formBalancedBST_outPlace_n(0,len-1);
        
    }
    
    // build tree bottom-up
	public Node formBalancedBST_outPlace_n(int start, int end) 
        {
		if (start > end)
			return null;

		int mid = start + (end-start)/ 2;

		Node left = formBalancedBST_outPlace_n(start, mid - 1);
		Node rootofBST = new Node(h.data);
		h = h.next;
		Node right = formBalancedBST_outPlace_n(mid + 1, end);

		rootofBST.prev = left;
		rootofBST.next = right;

		return rootofBST;
	}
    
    // get list length
	public int getLength(Node head) {
		int len = 0;
		Node p = head;
 
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
    
}


public class DLL2BST {

   
    public static void main(String[] args) {
        
        operation op=new operation();    
        
        // creating DLL 1- 2- 3- 4- 5- 6- 7-
        op.root(7);
        op.push(6);
        op.push(5);
        op.push(4);
        op.push(3);
        op.push(2);
        op.push(1);       
        
        op.printList();
     
        // Converting list to tree
       Node root=op.sortedListToBst();
        
       System.out.println("root data :: " + root.data);
        System.out.println("\nInorder traversal of tree");
        op.printTree(root);
    }
    
   
}
