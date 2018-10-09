
package LinkedList_MergeSort;

class LL_MergeSort 
{
      public static void main(String[] args) 
      {
       linklist l=new linklist();
       l.insert(10);
       l.insert(0);
       l.insert(50);
       l.insert(-10);
       l.insert(100);
       l.insert(50);
       l.insert(-90);
       l.insert(555);
        System.out.println("1st linked list: ");  
       l.display();
       
       
         linklist l2=new linklist();
       l2.insert(100);
       l2.insert(-89);
       l2.insert(500);
       l2.insert(-100);
       l2.insert(66);
       l2.insert(33);
       l2.insert(-97);
       l2.insert(555);
       System.out.println("2nd linked list: ");  
        l2.display();
       
      System.out.println("After merge Sort: L1");
       Node n2=l.mergeSort(l.getFirst());
       l.sethead(n2);      
       l.display();
       
        System.out.println("After merge Sort: L2");
       Node n3=l.mergeSort(l2.getFirst());
       l2.sethead(n3);
        l.display();
        
        
       System.out.println("After merging two list(inplace): ");
         Node n=l.mergeIterative(l.getFirst(),l2.getFirst());
        // l.sethead(n);
        l.displayFromNode(n);
    }
    
}


class linklist
{
    Node start;     //=new Node();
 
    public void insert(int x)
    {
        if(start==null)
        {
           start=new Node();
            start.setdata(x);
            start.setnext(null);
       
        }
        else
        { 
            Node t=start;
            Node lastbefore=start;
            
           while(t!=null)
           {
               lastbefore=t;
               t=t.next;
           }
           
           lastbefore.next=new Node();
           lastbefore.next.setdata(x);
           lastbefore.next.setnext(t);
           
        }
    }
     
    public void display()
    {
        Node t=start;
                 
        while(t!=null)
        {
            System.out.print(t.data+"   ");
            t=t.next;
        }
        System.out.println();
    }
    
     public void displayFromNode(Node tp)
    {
        Node t=tp;
                 
        while(t!=null)
        {
            System.out.print(t.data+"   ");
            t=t.next;
        }
        System.out.println();
    }
 
    public void delete()
    {
        Node t=start;
        Node tb=start;
        
        while(t.next!=null)
        {
            tb=t;
            t=t.next;
        }
        tb.next=null;
        
    }

    public void sethead(Node a)
    {
        start=a;
    }
    
    public Node getFirst()
    {
        return start;
    }

    public Node mergeSort(Node originalHead)
    {
        if(originalHead==null || originalHead.next ==null)
        {
            return originalHead;
        }
        
        Node a=originalHead;
        Node b=originalHead.next;
        
        while((b!=null) && (b.next!=null))
        {
           originalHead=originalHead.next;
            b=b.next.next;
        }
     //   System.out.println("a= " +originalHead.data+" b= "+b.data);
       b=originalHead.next; 
       
       originalHead.next=null;
       
       Node left = mergeSort(a);
       Node right = mergeSort(b);

       //return mergeRecursive(left, right);
       return mergeIterative(left, right);
    }
    
     // Iterative method to merge
    public Node mergeIterative(Node a, Node b) 
  	{ 
		Node head = new Node(); 
		//Node head = temp;
		Node c = head; 
    		while ((a != null) && (b != null)) 
      		{
			if (a.data <= b.data) 
        		{ 
				c.next = a; 
				c = a;   // Shifting the pointer 
				a = a.next; 
			} 
      			else 
        		{ 
				c.next = b; 
				c = b; 
				b = b.next;
			} 
    		}
		c.next = (a == null) ? b : a; 
    		return head.next; 
  	} 

    // Recursive method to merge
    public Node mergeRecursive(Node a, Node b)
    {
        if(a==null)
            return b;
        
        if(b==null)
            return a;
        
        Node result;
        
        if(a.getdata()<=b.getdata())
        {
            result=a;
            result.setnext(mergeRecursive(a.getnext(), b));
        }
        else
        {
            result=b;
            result.setnext(mergeRecursive(a, b.getnext()));
        }
    
        return result;
                
    }

}



class Node
 {
    int data;
    Node next;
    
    public void setdata(int a)
    {
        data=a;
    }
    
    public void setnext(Node n)
    {
        next=n;
    }
    
    public int getdata()
    {
        return data;
    }
    public Node getnext()
    {
        return next;
    }
 }
