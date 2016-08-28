
package stack;


public class StackAsLL {

    public static void main(String[] args) {
        
        LL obj=new LL();
        obj.push(2);
        
       // obj.insertAtBottom(-1);
      //  System.out.println("Inserting -1 at the bottom");        

        //obj.display();
        
        obj.push(6);
       obj.push(4);
       obj.push(1);
       obj.push(5);
       
       obj.display();
      // obj.getminimum();
       
      System.out.println("\nReversing the stack content: ");
      obj.reverse();
    // obj.reverseIterative();
        obj.display();
        
      //  obj.display();
      //  obj.pop();
       // obj.pop();
        
     //   obj.getminimum();
      // obj.display();
       //obj.top();
       //System.out.println("Deleting the whole stack");
      // obj.deletestack();
      // obj.display();
    }
}
    
class NodeSLL
    {
        int data;
        NodeSLL next;
        
        NodeSLL(int x)   
        {
            this.data=x;
        }
        // enjoying the polymorphism
        NodeSLL(int x,NodeSLL next)
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
    NodeSLL start;   // Head Node
    NodeSLL minstart;  // creating a new stack;
    // declaring the node structure   
    
    public void getminimum()
    {
        System.out.println("Minimum element is :"+minstart.data);
    }
    //recursive version but still Space Complexity is O(n)=n
    public void reverse()
    {
        if(start==null)
            return;
       
        int t=start.data;
        start=start.next;
        reverse();
        insertAtBottom(t);
    }
    
    // iterative version
    public void reverseIterative()
    {
        if(start==null || start.next==null)
        {
            return;
        }
        
        NodeSLL prev=null;
        NodeSLL current=start;
        NodeSLL next;

        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        
        start=prev;
        
    }
    
    public void insertAtBottom(int d)
    {
        if(start==null)
        {
            push(d);
            return;
        }
        
        int t=start.data;
        start=start.next;
       insertAtBottom(d);
       push(t);
    }
    
    public void push(int x)  // First Node index=1  inserting the element at first location
    {
        
        NodeSLL temp=start;
        NodeSLL temp2=minstart;
        
        if(start==null)  // List is empty
        {
           start=new NodeSLL(x,start);   
           minstart=new NodeSLL(x,minstart);
        }           
        else
        {
          // there exist a starting node
                        
            temp=new NodeSLL(x);
            temp.next=start;
            start=temp;           
            
            //for getting minimum
            if(minstart.data>x)
            {
             temp2=new NodeSLL(x);
            temp2.next=minstart;
            minstart=temp2;
                
            }
            
        }
    }
    
    // Java has garbage collector which automatically collects the unrequired data
    public void pop()  //value x is to be deleted
    {    
      
      //  System.out.println("Element popped is "+popped);
        
        if(start==null)
        {
            System.out.println("Underflow");
            //return;
        }
        else
        {
             System.out.println("Popped element = "+start.data);
            if(start.data==minstart.data)
            {
                start=start.next;
                minstart=minstart.next;
            }
            else
            {
                start=start.next;
            }
            
        }
        
        
    }
    
    public void top()
    {
        NodeSLL temp=start;
        if(temp==null)
            System.out.println("Linked List is empty");
        else
        {
            System.out.println("Top element is : "+temp.data);
        }
    }
    
    public void display()
    {
        
        NodeSLL temp=start;
        System.out.println("Top -----> Bottom");
        if(temp==null)
            System.out.println("Linked List is empty");
        else
            do
            {
                System.out.println(temp.data);
                //start=start.next;
            }while((temp=temp.next)!=null);
    }
    public void deletestack()
    {
        start=null;
        
    }
    
}
    

