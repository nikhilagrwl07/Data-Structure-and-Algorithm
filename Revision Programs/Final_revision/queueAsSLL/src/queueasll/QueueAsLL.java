
package queueasll;

public class QueueAsLL {

    public static void main(String[] args) 
    {
        queue q=new queue();
        
        q.enQueue(20);
        q.enQueue(30);
        q.display();
        q.deQueue();
        //q.display();
        q.enQueue(50);
        q.enQueue(60);
        q.enQueue(70);
       // q.display();
       // q.deQueue();
        q.display();
       // q.deQueue();
        q.display();
        
       // q.deQueue();
             
            q.display();
    }
    
}


  class queue
  {
        Node backNode;
        Node frontNode;

        int flag=0;
    public void enQueue(int a)
    {
        if(frontNode==null)
        {
            Node t=new Node(a);
            t.next=t.prev=null;
            backNode=frontNode=t;
        }
        else
        {
            Node pp=new Node(a);
            pp.next=backNode;
            pp.prev=null;
            backNode=pp;
            
            if(flag==0)
            {
                flag=1;
                frontNode.prev=backNode;
            }
            
        }
        
       
    }
    
    public void deQueue()
    {
        if(this.isEmpty())
        {
         System.out.println("Underflow");
        }
        else
        {
            if(frontNode==backNode)
            {
                frontNode=backNode=null;
            }
            else
            {
                    frontNode=frontNode.prev;
                      frontNode.next=null;
            }
            
        }
        
    }
    
    public boolean isEmpty()
    {
        if(frontNode==null)
            return true;
        else
            return false;
    }
    
    public void display()
    {
        Node temp=backNode;
        
        System.out.println("\nBack ---------------> front");
        
        while(temp!=null)
        {            
            System.out.print(temp.data+"    ");
            temp=temp.next;
        }
    }
   
    }


class Node
{
    int data;
    Node next;
    Node prev;

    public Node(int x)
    {
        this.data=x;

    }   
    
    public Node(int x,Node next)
    {
        this.data=x;
        this.next=next;

    } 
    
    public Node(int x,Node next,Node prev)
    {
        this.data=x;
        this.next=next;
        this.prev=prev;
    } 

}