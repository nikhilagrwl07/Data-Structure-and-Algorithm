
package amazontest;


public class LinkedList {
     public static void main(String[] args) {
         operations op=new operations();
         op.insert(10);
         op.insert(20);
         op.insert(30);
         op.insert(40);
         op.insert(50);
         op.insert(60);
         op.insert(70);
         
         op.display("Before reversing");
         op.reverseInBlocks(2);
         op.display("After reversing");
     }
}


class operations
{
    NodeLL head;
    
    public void insert(int d)
    {
        if(head==null)
        {
            head=new NodeLL();
            head.data=d;
            head.next=null;
        }
        else
        {
            NodeLL temp=new NodeLL();
            temp.setData(d);
            temp.setNext(head);
            head=temp;
        }
        
    }
    
    public void display(String s)
    {
        System.out.println("\n"+s);
        NodeLL h=head;
        while(h!=null)
        {
            System.out.print(h.data+" ");
            h=h.next;
        }
    }
    
    public void reverse()
    {
        NodeLL prev=null;
        NodeLL current=head;
        NodeLL after;
        
        while(current!=null)
        {
            after=current.next;
            current.next=prev;
            prev=current;
            current=after;
            
        }
        
        head=prev;
    }
    
    public void reverseInBlocks(int k)
    {
        head=reverseInBlocksUtil(head,k);
    }
    
    public NodeLL reverseInBlocksUtil(NodeLL rt,int k)
    {
            int count=0;
            NodeLL prev=null;
            NodeLL current=rt;
            NodeLL after;

            while(current!=null && count<k)
            {
                after=current.next;
                current.next=prev;
                prev=current;
                current=after;
                count++;
            }

            // performing the recursion-------------
            if(current!=null)
                rt.next=reverseInBlocksUtil(current,k);
            
            //-----------------------------------
            return prev;
        
    }
}



class NodeLL
{
    int data;
    NodeLL next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeLL getNext() {
        return next;
    }

    public void setNext(NodeLL next) {
        this.next = next;
    }
    
    
}