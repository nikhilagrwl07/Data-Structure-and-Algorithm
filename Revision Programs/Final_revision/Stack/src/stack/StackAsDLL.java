
package stack;

public class StackAsDLL {

    public static void main(String[] args) {
        
        Stack obj=new Stack();
        obj.push(2);        
        
        obj.push(6);
       obj.push(4);
       obj.push(1);
       obj.push(5);
       obj.push(10);
       obj.display();
      // obj.getminimum();
       
    //   System.out.println("Finding the middle element: ");
       obj.findmiddle();
        System.out.println();
       obj.pop();
     //      System.out.println("\nFinding the middle element: ");
       obj.findmiddle();
    
     System.out.println();
       obj.pop();
      //     System.out.println("\nFinding the middle element: ");
       obj.findmiddle();
       
        System.out.println();
       obj.pop();
       obj.findmiddle();
       System.out.println();
       obj.pop();
       obj.findmiddle();
       System.out.println();
       obj.pop();
       obj.findmiddle();System.out.println();
       obj.pop();
       obj.findmiddle();
       
       
    }
}
    class Node
    {
        // A DLL Node
        int data;
        Node next;
        Node prev;
        
        Node(int x)   
        {
            this.data=x;
        }
        // enjoying the polymorphism
        Node(int x,Node next)
        {
            this.data=x;
            this.next=next;
        }
         // enjoying the polymorphism
        Node(int x,Node next,Node prev)
        {
            this.data=x;
            this.next=next;
            this.prev=prev;
        }
        
        public int getdata()
        {
            return data;
        }
    }
    

class Stack
{
    Node head=null;   // Head Node
    Node mid;  // for mainting the middle element    
    int count;
    // declaring the node structure   
    
    public void push(int x)  // First Node index=1  inserting the element at first location
    {
        
        Node newNode=new Node(x,head,null);
        
        count++;
        
        /* Change mid pointer in two cases
       1) Linked List has only 1 Node
       2) Number of nodes in linked list is odd */
        
        if(count==1)
        {
            mid=newNode;
        }
        else
        {
            head.prev=newNode;
            // count is odd
            if(count%2==1)
                mid=mid.prev;
        }           
        head=newNode;
       }
    
    // Java has garbage collector which automatically collects the unrequired data
    public void pop()  //value x is to be deleted
    {    
        if(count==0)
        {
            System.out.println("Stack is empty\n");
            return;
        }
        
        Node newhead=head;
        int item=newhead.data;
        head=head.next;
        
         // If linked list doesn't become empty, update prev
    // of new head as NULL
         if (head != null)
          head.prev = null;
         
         count--;
         
         // update the mid pointer when we have even number of
    // elements in the stack, i,e move down the mid pointer.
         if(count%2==0)
         {
             mid=mid.next;
         }
         
         
         newhead=null;
         
         System.out.println("Popped Node="+item);
    }
    
    
    // function for finding the middle element
    public void findmiddle()
    {
       if(count==0)    
       {
           System.out.println("Stack is empty");
           return;
       }
       
         System.out.println("Middle Node= "+ mid.data);
    }
    
    public void top()
    {
        Node temp=head;
        if(temp==null)
            System.out.println("Linked List is empty");
        else
        {
            System.out.println("Top element is : "+temp.data);
        }
    }
    
    public void display()
    {
        Node temp=head;
        
        if(temp==null)
            System.out.println("Linked List is empty");
        else
            do
            {
                System.out.println(temp.data);
            }while((temp=temp.next)!=null);
    }
    public void deletestack()
    {
        head=null;
        
    }
    
}
    

