// Linked List own java implementation
// Source of information: http://techyrajeev.blogspot.in/2012/01/linked-list-implementation-in-java.html
package javaapplication1;

public class JavaApplication1 {

    public static void main(String[] args) 
    {
        int k=3;
         LinkedList l=new LinkedList();
          l.insert(10);
           l.insert(20);
            l.insert(30);
            l.insert(40);
            l.insert(50);
            l.display();
            System.out.println("-------------------------");
         //l.delete(2);
            l.rotate(k);
          System.out.println("---------after Rotation---------");
            l.display();
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
 
 public void rotate(int r)
 {
     int i;
      for(i=1;i<=r;i++)
   {
       delete(start.data);
     insert(start.data);  
   }
 }
 

 
 private static class Node   // Private static inner class Node is used so as to enforce Encapsulation concept of java.
  {
  private int data;
  Node next;
  
  Node(int data)
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

/*Follow the steps to create a linked list:

1.Create a class LinkedList with a private static inner class which will be the node of linked list or you can also create a separate class Node instead of inner class.But I think a private Inner class will be best suitable for encapsulation property(Make it private if your node is not going to be used for another purpose).

2.Node class has two attributes 

first information and second link which stores the address of next node in the chain.

3.Define suitable constructor for Node class

4.Define getters and setters for class if you feel need for it.

5.Now proceed back to your LinkedList class. It has a single attribute of Node class and add functionality to your LinkedList like methods to append, add at beginning ,insert at any point, delete,display etc.

6. Now your linked list is complete !!! You can use it any where you like.*/
    

