// Linked List own java implementation
// Source of information: http://techyrajeev.blogspot.in/2012/01/linked-list-implementation-in-java.html
package javaapplication1;

public class JavaApplication1 {

    public static void main(String[] args) 
    {
        int targetv=101;
         LinkedList l=new LinkedList();
        
            
             l.insert(20);
           l.insert(59);
            l.insert(90);
            
        //sort l2 in ascending order by merge sort
                        
            
           l.display();
            System.out.println("-------------------------");

        l.delete(2);
          System.out.println("---------after deletion---------");
          //  l.display();
   }
}   
    class LinkedList
    {
    private Node start;

    public void insert(int x)
  {
  if(start==null)    // When NO node is present in LL
     start=new Node(x,start);

  if(start!=null)
  {
    Node temp=start;
    while(temp.next!=null)
    {
       temp=temp.next;
    }
    temp.next=new Node(x);
  }
 }

public void display()
{
 if(start==null)
 {
 System.out.println("List is empty!");
 }
 else
 {
 Node temp=start;
while(temp.next!=null)
{
 temp=temp.next;
 System.out.println(temp.getData());
}
}
}

 public void delete(int x)
 {    
Node prev=start;
Node temp=start;
 while(temp.getData()!=x)
 {
if(temp.next==null)
{
    System.out.println("Element not found!!");
     break;
}
 prev=temp;
  temp=temp.next;
}
 if(temp==start)
 {
start=start.next;
  }
 else
 {
 prev.next=temp.next;
 }
}
 
public class Node   // Private static inner class Node is used so as to enforce Encapsulation concept of java.
  {
  private int data;
  Node next;
  
  Node(int data)                //this is for setting the value assigned
  {
   //this.setData(data);
   this.data=data;
  }
  
  Node(int data,Node next)
  {
   //this.setData(data);
      this.data=data;
   this.next=next;
  }

 public int getData()
 {
   return data;
 }
  
 }
}
