
package linkedlistown;

import java.util.HashMap;
import java.util.Stack;

public class LinkedListOwn {

    public static void main(String[] args) {
        // TODO code application logic here
       // Node t1=new Node(50,null);
       // Node t2=new Node(60,null);
        LinkedList ll3=new LinkedList();
         ll3.insert(49);
         ll3.insert(50);
        ll3.insert(60);
       // ll3.display();
        
        LinkedList ll=new LinkedList();
        ll.insert(10);
      ll.insert(20);
       ll.insert(30);
        ll.insert(40);
         ll.insert(50);
          ll.insert(60);
           ll.insert(70);
            ll.insert(80);
             ll.insert(90);
              ll.insert(100);

       // ll.createNode(60, null);
      // ll.connectll(ll3);
       
       ll.display();
      
     //  ll.middleElement2();
      //  System.out.println("Printing from end");

        //ll.printLLfromEnd(ll.head , 1);
//      System.out.println("--------After deleting------");
//        ll.delete(10);
//        ll.display();
        
       //  System.out.println("--------After reversing------");
       //  ll.reverse_3_pointer();
       // ll.reverse_try_2();
          
      //   ll.display();

   // System.out.println("--------After reversing in pair------");
     //  ll.reverse_k(3);
        
       //  ll.display();
         
       // ll.nthNodeFromEnd(7);
        ll.insertCycle(60);
        ll.cycleDetection();
        ll.cycleDetectionUsingMap();
       // ll.cycleStartingPoint();
     // ll.lengthofCycle();
      
        LinkedList ll2=new LinkedList();
        ll2.insert(20);
        ll2.insert(25);
        ll2.insert(50);
        ll2.insert(50);
       // ll2.insert(25);
       // ll2.insert(20);
        ll2.insert(65);
         //ll2.connectll(ll3);
//         ll2.insertNode(t1);
 //       ll2.insertNode(t2);
      //  System.out.println("LinkedList 2.....");
      //  ll2.display();
//     
        //ll.merge2ll(ll,ll2);
      //  ll2.palindrome(ll2);
       // ll2.display();
       // ll3.intersectingNode(ll,ll2);
        //ll3.intersectingNode2(ll, ll2);
    }
}

class LinkedList
{
    public Node head;
    
        // means inserting at the end
    public void insert(int x)
    {
        if(head==null)
        {
           head=new Node(x,null);
            //head=n;            
        }        
        else
        {
            Node temp=head;
            
            while(temp.next!=null)
            {                
                temp=temp.next;
            }
            temp.next=new Node(x,null);
        }
        
           // System.out.println(head);
    }
    public void insertCycle(int x)
    {
         if(head==null)
        {
           head=new Node(x,null);
            //head=n;            
        }        
        else
        {
            Node temp=head;
            
            while(temp.next!=null)
            {                
                temp=temp.next;
            }
            temp.next=new Node(x,head.next);
        }
    }
    
    // Insert the particular Node
    public void insertNode(Node t)
    {
        if(t==null) return;
        Node start=head;
        while(start.next!=null)
        {
            start=start.next;
        }
        start.next=new Node(t.data,null);
    }
  
    public void connectll(LinkedList l4)
    {
       Node start=head;
       
       while(start.next!=null)
           start=start.next;
       
       start.next=l4.head;
       
    }
    
     int globalvaribale = 0;
    public Node printLLfromEnd(Node h ,int nth)
    {
        if(h!=null){

            this.printLLfromEnd(h.next , nth);
            globalvaribale ++;
            if(globalvaribale ==nth){
                System.out.println(h.data);
                
            }
         
          }
        
        return null;
    }
    
    public void middleElement2()
    {
         Node a=head;
        Node b=head;
        
        while((b!=null) && (b.next!=null))
        {
            a=a.next;
            b=b.next.next;
        }

        System.out.println("Middle element = "+a.data);
    } 
            
    public void merge2ll(LinkedList l1,LinkedList l2)
    {
        if(l1==null && l2==null) {
            return;
        }
        
        LinkedList result=new LinkedList();
        Node h3=null;
        int flag=0;
        
        Node h1=l1.head,h2=l2.head;
        
     //   System.out.println("Value = "+h2.data);
        while(true)
        {
            while(h1!=null && h2!=null && h1.data<=h2.data)
            {
                if(result.head==null)
                {
                    // create the head
                    result.head=new Node(h1.data,null);
                    h3=result.head;
                }
                else
                {
                    h3.next=new Node(h1.data,null);
                    h3=h3.next;
                }
                h1=h1.next;
           
            }
            
            while(h2!=null && h1!=null && h1.data>h2.data)
            {
                if(result.head==null)
                {
                    // create the head
                   result.head=new Node(h2.data,null);
                   h3=result.head;
                }
                else
                {                    
                    h3.next=new Node(h2.data,null);
                    h3=h3.next;
                }
                h2=h2.next;
                
           // System.out.println("Check 2");
            }
            
            if(h1==null){
                flag=1;
                break;
            }
            else if(h2==null)
            {
                flag=2;
                break;
            }
                     
        }
       
        if(flag==1){
            while(h2!=null){
                  h3.next=new Node(h2.data,null);
                  h2=h2.next;
                  h3=h3.next;
            }
        }
        else if(flag==2){
            while(h1!=null){
                  h3.next=new Node(h1.data,null);
                  h1=h1.next;
                  h3=h3.next;
            }
        }
        
        Node temp=result.head;
        System.out.println("Merged List");
        
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public void palindrome(LinkedList l)
    {
        if(l.head==null)    // || l.head.next==null){
        {
            System.out.println("Empty LinkedList");
            return;
        }
        if(l.head!=null && l.head.next==null)
        {
            System.out.println("Palindrome");
            return;
        }
        // finding the even and odd list length
       int even=0;
        Node slow=l.head,fast=l.head;
        while(true)
        {
            if(fast.next!=null)
                fast=fast.next;
            else
            {
                even=0;
                System.out.println("Odd length");
               
                break;
            }
            
             if(fast.next!=null)
                fast=fast.next;
            else
            {
               System.out.println("Even length");
                even=1;
                break;
            }
             
             slow=slow.next;
            
        }
        // now reversing the second half of the list
        // Node start=slow.next;
             if(slow.next==null)
                return;
        
        Node start=slow.next,nextNode,temp=null;
       
        while(start!=null)
        {
            nextNode=start.next;
            start.next=temp;
            temp=start;
            start=nextNode;
        }
        start=temp;
        Node head2=temp;
       
        Node startfirst=head;
        // chekcing first half with reversed second half
       
        
        while(start!=null && startfirst.data==start.data)
        {            
          //  System.out.println("List 1:"+startfirst.data);
          //  System.out.println("List 2:"+start.data);
                                
            start=start.next;
            startfirst=startfirst.next;
          
        }
        
        if(start!=null)
            System.out.println("NOT palindrome");
        else
            System.out.println("Palindrome");
            
       // attaching the second half
         if(slow.next==null)
                return;
        
        Node start2=head2;
        Node temp2=null;
        //nextNode,temp=null;
       
        while(start2!=null)
        {
            nextNode=start2.next;
            start2.next=temp2;
            temp2=start2;
            start2=nextNode;
        }
        
        slow.next=temp2;
        
      //  System.out.println("Temp="+temp2.data);        
    }
    
 /*   public void evenOddLength()
    {
        Node slow=head,fast=head;
        while(true)
        {
            slow=slow.next;
            
            fast=fast.next;
            
            if(fast.next!=null)
                fast=fast.next;
            else
            {
                System.out.println("Even length");
                break;
            }
        }
    }
   */ 
    public void intersectingNode(LinkedList l1,LinkedList l2)
    {
        if(l1==null || l2==null) {
            System.out.println("No intersecting node");
            return;
        }
        Stack<Node> s1=new Stack<Node>();
       // Stack<Node> s2=new Stack<>();
        
        // putting all nodes in LnikedList 1
        Node t1=l1.head;
        
        while(t1.next!=null)
        {
            s1.push(t1);
            t1=t1.next;
        }
        s1.push(t1);
        System.out.println("Size = "+s1.size());
        l2.reverse_3_pointer();
        
        Node t=l2.head;
         Node p=s1.pop();
         Node temp=null;
        while(true)
        {                   
            if(t==p) {
                 temp=t;                
                 p=s1.pop();
                 t=t.next;
            }
            else if(t==null || p==null)
                break;
            else
            {
                System.out.println("Intersecting node = "+temp.data);
               return;
            }    
            
        }
        
        System.out.println("No interseting Node");
    }
    
    public void intersectingNode2(LinkedList l1,LinkedList l2)
    {
        if(l1==null || l2==null) return;
        
        int len1=0,len2=0,diff=0;
        
        Node h1=l1.head;
        Node h2=l2.head;
        
        
        while(h1!=null)
        {
            len1++;
            h1=h1.next;
        }
           while(h2!=null)
        {
            len2++;
            h2=h2.next;
        }
         if(len1>len2)
         {
             diff=len1-len2;
             h1=l1.head;
             
             for(int i=1;i<=diff;i++)
             {
                 h1=h1.next;
             }
             h2=l2.head;
             
         }
         else
         {
             diff=len2-len1;
                h2=l2.head;
             for(int i=1;i<=diff;i++)
             {
                 h2=h2.next;
             } 
             h1=l1.head;
         }
         
         while(h1!=h2)
         {
             h1=h1.next;
             h2=h2.next;
         }
         System.out.println("Intersecting Node = "+h1.data);
    }
    // deleting the node
    public void delete(int x)
    {
        if(head.data==x)
            head=head.next;
        else
        {
            Node temp=head;
            Node prevTemp=null;
        while(temp.data !=x)
        {
            prevTemp=temp;
            temp=temp.next;
        }
        prevTemp.next=temp.next;
        }
        
    }
  
    
    // i think it is 3 pointer strategy
    public void reverse_3_pointer()
    {
        if(head==null || head.next==null)
            return;
        
        Node prev=null;
        Node current=head;
        Node next;
        
        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        
    }
   
    //Source: http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
    public void reverse_try_2()
    {
        if(head==null || head.next==null)
            return;
        
        int i=0,flag=-1;
        Node node=head,nextnode=node.next,nextNextNode;
        
        while(true)
        {            
            if(i==0)
            {
               i++;
                node.next=null;
            }
            
                if(nextnode.next==null)
                {
                    nextNextNode=null;
                    flag=1;
                }
                else
                {
                     nextNextNode=nextnode.next;
                }
               
                nextnode.next=node;
                node=nextnode;
                nextnode=nextNextNode;
                
                if(flag==1)
                    break;
            
        }
        head=node;
            
    }
   
    
    public void reverse_k(int k)
    {
        head=reverse_size_k(head,k);
    }
    
    public Node reverse_size_k(Node head,int k)
    {
        if(head==null || head.next==null || k<=1)
            return head;
        
        Node current=head,next=null,prev=null;
        int count=0;
        
        // reverse first k nodes of the linked list
        while(current!=null && count<k)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }
        
        if(next!=null)
        {
            head.next=reverse_size_k(next,k);
        }
        
        return prev;
    }
   
    public void nthNodeFromEnd(int n)
    {
        if(n<=0) return;
       
        int i;
        Node slow=head,fast=head;
        
        for(i=1;i<=n;i++)
        {
            fast=fast.next;
            
            if(fast==null)
            {System.out.println("Parameter out of LinkedList length");
                return;
            }
        }
        
        
        // travsering each node at a time of slow and fast
        while(fast!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        
        System.out.println(n+"th Node from the end = "+slow.data);
    }

    public void cycleDetectionUsingMap()
    {

       HashMap<Node,Node> hm = new HashMap<Node,Node>();

       Node t = head ;
       int flag =0;
       while(t!=null){
           if(hm.get(t)==null){
               hm.put(t,t);
           }
           else
           {
               System.out.println("Loop exists");
               flag =1;
               break;
           }
           t=t.next;
       }
       if(flag ==0)
       {
            System.out.println("Loop does not exists");
       }


    }
    public void cycleDetection()
    {
        Node slow=head,fast=head;
        int cycle=0;
        
        while(true)
        {
            fast=fast.next;
   
            fast=fast.next;
            slow=slow.next;
            
            if(fast==null || slow==null)
             break;
            
            if(fast==slow)
            {     
                cycle=1;
                break;
            }
        }
        
        if(cycle==1) System.out.println("Cycle detected");
        else     System.out.println("Cycle NOT detected"); 
            
    }
    
     public void cycleStartingPoint()
    {
        Node slow=head,fast=head;
        int cycle=0;
        
        while(true)
        {
            fast=fast.next;
   
            fast=fast.next;
            slow=slow.next;
            
            if(fast==null || slow==null)
             break;
            
            if(fast==slow)
            {     
                cycle=1;
                break;
            }
        }
        
        if(cycle==1)
        {
            System.out.println("Cycle detected");
            slow=head;
            while(true)
            {
                if(slow==fast)
                {
                    System.out.println("Starting point of cycle="+slow.data);
                    break;
                }
                slow=slow.next;
                fast=fast.next;
            }
            
        }
        else     System.out.println("Cycle NOT detected"); 
            
    }
    
    public void lengthofCycle()
    {
        Node slow=head,fast=head;
        int cycle=0;
        
        while(true)
        {
            fast=fast.next;
   
            fast=fast.next;
            slow=slow.next;
            
            if(fast==null || slow==null)
             break;
            
            if(fast==slow)
            {     
                cycle=1;
                break;
            }
        }
        
        if(cycle==1)
        {
            int length=0;
          //  System.out.println("Cycle detected");
            slow=head;
            while(true)
            {
                if(slow==fast)
                {
            //        System.out.println("Starting point of cycle="+slow.data);
                   // System.out.println("Length of cycle="+length*2);
                    break;
                }
                slow=slow.next;
                fast=fast.next;
                //length++;
            }
            
            // length of cycle
            while(true)
            {
               fast=fast.next;
               if(fast==slow)
               {
                 length++;
                 System.out.println("Length of cycle="+length);  
                 break;
               }
               else
               {
                  // fast=fast.next;
                   length++;
               }
            }
            
        }
        else     
            System.out.println("Cycle NOT detected"); 
            
    }
    
     
    public void display()
    {
        Node temp=head;
     //System.out.println(head.data);
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

 
   

   
}

 class Node{
   public Node next=null;
    public int data;
    
    public Node(int x,Node next)
    {
        this.data=x;
        this.next=next;
    }
}