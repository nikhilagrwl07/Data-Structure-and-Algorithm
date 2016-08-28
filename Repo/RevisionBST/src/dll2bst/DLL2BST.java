
package dll2bst;

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
        if (root==null) return;
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
       
       return formBalancedBST_inPlace_nlogn(temp,n);
   // return formBalancedBST_outPlace_n(temp,0,n-1);//formBalancedBST_inPlace_nlogn(temp,n);
    }
   
    
    // In place conversion of DLL to Balanced BST
   // Space Complexity : O(1)  
   // Time complexity: O(n)   
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
    public Node formBalancedBST_outPlace_n(Node list,int start,int end)
    {
        if(start>end) return null;
        
        int mid=start+(end-start)/2;
      
        Node leftchild=formBalancedBST_outPlace_n(list, start, mid-1);
        
        Node parent =new Node();
                
        parent.data=list.data;
        parent.prev=leftchild;
        list=list.next;
        
        parent.next=formBalancedBST_outPlace_n(list, mid+1,end);
        return parent;
        
    }
    
}



public class DLL2BST {

   
    public static void main(String[] args) {
        
        operation op=new operation();    
        
        // creating DLL 7->6->5->4->3->2->1
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
        
        System.out.println("\nInorder traversal of tree");
        op.printTree(root);
    }
    
   
}
