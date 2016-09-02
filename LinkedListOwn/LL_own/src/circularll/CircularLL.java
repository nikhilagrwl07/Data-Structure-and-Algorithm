// Circular linked list
package circularll;
public class CircularLL {

    public static void main(String[] args) {
         LL obj=new LL();
           obj.insertAtLast(10);
           obj.insertAtLast(20);
           obj.insertAtLast(30);
           obj.insertAtY(44, 2);
           obj.insertAtLast(70);
           obj.display();
           System.out.println("----------deletion-----------");
            obj.deleteLast();
           obj.display();
        
    }
}

     class Node
    {
        int data;
        Node next;
        
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
        
        public int getdata()
        {
            return data;
        }
    }

class LL
{
    Node start;   // Head Node
    
    // declaring the node structure
    public void insertAtLast(int x)
    {
       
        
        if(start==null)  // List is empty
        {
             Node t=new Node(x);
            start=t;
            start.next=t;
                
        }
        
        else
        {
            Node temp=start;  //temporary Node
            while(temp.next!=start)
            { 
                temp=temp.next;
            }
                        
            temp.next=new Node(x,start);  // last node pointing to head node
        }
    }
    
    public void insertAtY(int x,int y)  // First Node index=1
    {
        Node temp=start;
        if(temp==null)  // List is empty
        {
           temp=new Node(x,temp);   
        }
        
        else
        {
            int t=1;
            while(t<y-1)
            {
                temp=temp.next;
                t++;
            }
            
            if(temp.next==start) // the last element
            {
             temp.next=new Node(x,start);
            }
            else
            {
                Node temp2=temp.next;
                temp.next=new Node(x,temp2);
            }
        }
    }
    
    // Java has garbage collector which automatically collects the unrequired data
    public void deleteLast()  //value x is to be deleted
    {        
        Node temp=start;
        Node btemp=start;
                   
       // if(temp!= start)
        //{
        while(temp.next!=start)
        {
            btemp=temp;
            temp=temp.next;
            
        }
        
        btemp.next=temp.next;
        temp.next=null;
      
        //}
        
       /* else
        {
            start=start.next;  // Head node is removed to second element if element to delete is the head node.
        }
        * 
        */
    }
    public void display()
    {
        Node temp=start;
        if(temp==null)
            System.out.println("Linked List is empty");
        else
            do
            {
                System.out.println(temp.data);
                //start=start.next;
            }while((temp=temp.next)!=start);
    }
}


