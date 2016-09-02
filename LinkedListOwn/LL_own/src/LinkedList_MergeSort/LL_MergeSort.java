
package LinkedList_MergeSort;

class LL_MergeSort 
{
      public static void main(String[] args) 
      {
       linklist l=new linklist();
//       l.insert(10);
//       l.insert(0);
//       l.insert(50);
//       l.insert(-10);
//       l.insert(100);
//       l.insert(50);
//       l.insert(-90);
//       l.insert(555);
        l.insert(10);
       l.insert(40);
       l.insert(53);
       l.insert(30);
       l.insert(67);
       l.insert(12);
       l.insert(89);
       l.insert(89);
        System.out.println("1st linked list: ");  
       linklist.display(l.getFirst());
       
       
         linklist l2=new linklist();
       l2.insert(100);
       l2.insert(-89);
       l2.insert(500);
       l2.insert(-100);
       l2.insert(66);
       l2.insert(33);
       l2.insert(-97);
       l2.insert(555);
//       System.out.println("2nd linked list: ");  
//       linklist.display(l2.getFirst());
//       
      System.out.println("After merge Sort: L1");
       Node1 n2=linklist.mergeSort(l.getFirst());
       l.sethead(n2);      
       linklist.display(l.getFirst());
//       
//        System.out.println("After merge Sort: L2");
//        Node n3=linklist.mergeSort(l2.getFirst());
//        l2.sethead(n3);
//        linklist.display(l2.getFirst());
//        
//        
//       System.out.println("After merging two list(inplace): ");
//         Node n=linklist.mergeIterativ(l.getFirst(),l2.getFirst());
//        // l.sethead(n);
//        l.displayFromNode(n);
    }
    
}


class linklist
{
    Node1 start;     //=new Node();
 
    public void insert(int x)
    {
        if(start==null)
        {
           start=new Node1();
            start.setdata(x);
            start.setnext(null);
       
        }
        else
        { 
            Node1 t=start;
            Node1 lastbefore=start;
            
           while(t!=null)
           {
               lastbefore=t;
               t=t.next;
           }
           
           lastbefore.next=new Node1();
           lastbefore.next.setdata(x);
           lastbefore.next.setnext(t);
           
        }
    }
     
    public static void display(Node1 r)
    {
        Node1 s=r;
                 
        while(s!=null)
        {
            System.out.print(s.data+"   ");
            s=s.next;
        }
        System.out.println();
    }
    
     public void displayFromNode(Node1 tp)
    {
        Node1 t=tp;
                 
        while(t!=null)
        {
            System.out.print(t.data+"   ");
            t=t.next;
        }
        System.out.println();
    }
 
    public void delete()
    {
        Node1 t=start;
        Node1 tb=start;
        
        while(t.next!=null)
        {
            tb=t;
            t=t.next;
        }
        tb.next=null;
        
    }

    public void sethead(Node1 a)
    {
        start=a;
    }
    
    public Node1 getFirst()
    {
        return start;
    }

    public static Node1 mergeSort(Node1 originalHead)
    {
        if(originalHead==null || originalHead.next ==null)
        {
            return originalHead;
        }
        
        Node1 a=originalHead;
        Node1 b=originalHead.next;
        
        while((b!=null) && (b.next!=null))
        {
           originalHead=originalHead.next;
            b=b.next.next;
        }
     //   System.out.println("a= " +originalHead.data+" b= "+b.data);
       b=originalHead.next; 
       
       originalHead.next=null;
       
       Node1 left = mergeSort(a);
       Node1 right = mergeSort(b);
       
       return mergeIterative(left, right);
    }
    
     // Iterative method to merge
    public static Node1 mergeIterative(Node1 a, Node1 b) 
  	{ 
		Node1 head = new Node1(); 
		//Node head = temp;
		Node1 c = head; 
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
    
       public static Node1 mergeIterative2(Node1 a, Node1 b) 
  	{ 
		if(a==null) return b;
                if(b==null) return a;
                
                
                Node1 result = new Node1();
                Node1 temp=result;
                
                while(a!=null && b!=null)
                {
                    if(a.data<=b.data)
                    {
                        result.next=a;
                        a=a.next;
                      
                    }
                    
                    else 
                    {
                         result.next=b;
                         b=b.next;
                        
                    }
                    
                    result=result.next;
                    
                }
                
                if(a==null)
                {
                    result.next=b;
                }
                else if(b==null)
                {
                    result.next=a;
                }
                return temp.next;
  	} 

    // Recursive method to merge
    public static Node1 mergeRecursive(Node1 a, Node1 b)
    {
        if(a==null)
            return b;
        
        if(b==null)
            return a;
        
        
        Node1 result;
        
        while(a.getnext()!=null && b.getnext()!=null)
        {
            if(a.getnext().data<=b.getnext().data)
            {
                result=a;
                a=a.next;
            }
            else 
            {
                result=b;
                b=b.next;
            }
            result=result.next;
        }
        
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
    
    public static Node1 mergeIterativ(Node1 a, Node1 b)
    {
        if(a==null)
            return b;
        
        if(b==null)
            return a;
        
        
        Node1 result = new Node1();
        Node1 head =result;
        
        while(a!=null && b!=null)
        {   
//            System.out.println("data " + a.getnext().data);
            if(a.data<=b.data)
            {
                result.next=a;
                a=a.next;
            }
            else 
            {
                result.next=b;
                b=b.next;
            }
            result=result.next;
        }
        
        if(a==null)
        {
            while(b!=null)
            {
                result.next=b;
                b=b.getnext();
                result=result.next;
            }
            
        }
        else if(b==null)
        {
          while(a!=null)
            {
                result.next=a;
                a=a.getnext();
                result=result.next;
            }  
        }
       
        
        return head.next;
                
    }

}



class Node1
 {
    int data;
    Node1 next;

    public Node1() {
    }
    
    
    public void setdata(int a)
    {
        data=a;
    }
    
    public void setnext(Node1 n)
    {
        next=n;
    }
    
    public int getdata()
    {
        return data;
    }
    public Node1 getnext()
    {
        return next;
    }
 }
