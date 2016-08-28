
package stack;



public class SatckAsDLLMiddleElement {
    public static void main(String args[])
    {
        operation op = new operation();
      
        op.push(4);       
        op.display();
        op.middleElement();
        
        op.push(10);        
        op.display();
        op.middleElement();
        
        
        op.push(-4);        
        op.display();
        op.middleElement();
        
        op.push(14);  
        op.display();
        op.middleElement();
        
        
        op.push(90);        
         op.display();
        op.middleElement();
        
        //op.display();
        op.pop();
          op.display();
        op.middleElement();
        
        op.pop();
          op.display();
        op.middleElement();
        
        op.pop();
          op.display();
        op.middleElement();
        
        op.pop();
          op.display();
        op.middleElement();
    }
    
}
class operation
{
    NodeDLL head=null;
    NodeDLL mid=null;
    int count=0;
    
    public void push(int x)
    {
        // Case when head is null
        if(head==null)
        {
            head=new NodeDLL();
            head.data=x;
            head.next=head.prev=null;
            // setting middle element for 1 node
            mid=head;
            count=1;
        }
        else
        {
          NodeDLL temp=new NodeDLL();
          count++;
          temp.data=x;
          temp.prev=null;
          temp.next=head;
          head.prev=temp;

          head=temp;        
          
          if(count%2==0)
          {
              mid=mid.prev;
          }

          
        }
        
    }
    
    public void display()
    {
            System.out.println("Top ----> Bottom");
        NodeDLL temp=head;
        
        
        while(temp!=null)
        {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
        
    }
    
    public void pop()
    {        
        System.out.println("popped element = "+head.data);
        head=head.next;
        count--;
        if(count%2==0)
        {
            
        }
        else
        {
            mid=mid.next;
        }
    }
    
    public void middleElement()
    {
        if(mid==null)
        {
            System.out.println("Underflow");
        }
        else
        {
            System.out.println("Middle element = "+mid.data);
        }
    }
    
}



class NodeDLL
{
    int data;
    NodeDLL prev;
    NodeDLL next;
       
}