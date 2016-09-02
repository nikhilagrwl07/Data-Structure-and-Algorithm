
package amazontest;

import java.util.HashMap;
import java.util.Iterator;

public class AmazonTest {

    public static void main(String[] args) {
        operation ob=new operation();
        Node root=ob.makeRoot(8);        
        ob.insert(root, 4);
        ob.insert(root, 5);
        ob.insert(root, 2);
        ob.insert(root, 1);
        ob.insert(root, 3);
        ob.insert(root, 7);
        ob.insert(root, 6);
        ob.insert(root, 9);
        ob.insert(root, 10);
        ob.insert(root, 11);
        
        System.out.println("Inorder traversal: ");
        ob.InOrder(root);
        System.out.println("\n------------------------------");
        
       // HashMap<Integer,Integer> hm=new HashMap();
        // key= horizontal distance
        // Value= Node data value
       // ob.verticalSum(root, 0, hm);
       // ob.printValues(hm);
        
//        Node a=new Node();
//         a.data=6;
//         
//       Node b=new Node();
//        b.data=4;
//         
//        ob.LCA(a, b, root);
//            ob.pathsRootToLeafs(root,Integer.toString(root.data));
//            System.out.println("Sum = "+ob.sum);
            
        ob.height();
    }
}



class operation
{
    Node root;
   
    public Node makeRoot(int d)
    {
        root=new Node();
        root.data=d;
        root.prev=root.next=null;
        
        return root;
    }
    
    
    public void insert(Node rt,int d)
    {
        if(rt==null)
        {
            rt=new Node();
            rt.data=d;
            rt.prev=rt.next=null;
            return;
        }
        
        if(rt.data>d)
        {
            if(rt.prev==null)
            {
                rt.prev=new Node();            
                rt.prev.data=d;
                rt.prev.prev=rt.prev.next=null;
            }
            else
            {
              insert(rt.prev,d);
            }
        }
        else
        {
            if(rt.next==null)
            {
                rt.next=new Node();            
                rt.next.data=d;
                rt.next.prev=rt.next.next=null;
            }
            else
            {
                  insert(rt.next,d);
            }
        }
    
        
    }

    public void InOrder(Node rt)
    {
        if(rt!=null)
        {
            InOrder(rt.prev);
            System.out.print(rt.data+" ");
            InOrder(rt.next);
        }
               
    }

    // calculating vertical sum of each node
    public void verticalSum(Node r,int hD,HashMap<Integer,Integer> hm)
    {
        if(r==null)
            return;
        
        if(hm.containsKey(hD))
        {
          //  Integer val= hm.get(hD);
           // val=val+r.data;            
            hm.put(hD,hm.get(hD)+r.data);
        }
        else
        {
            hm.put(hD, r.data);
        }
        
        verticalSum(r.prev, hD-1, hm);
        verticalSum(r.next, hD+1, hm);
    }
 
    public void printValues(HashMap<Integer,Integer> hm)
    {
     
        System.out.println("key  Value");  
        Iterator iterator = hm.keySet().iterator();  
       
         while (iterator.hasNext()) {  
       Integer key = (Integer) iterator.next();//.toString();  
       Integer value = hm.get(key);//.toString();  
       
       System.out.println(key + " " + value);  
    }  
        
    }
    
    public void LCA(Node a, Node b,Node r)
    {
        if(LCAUtil(a,b,r)==null)
        {
             System.out.println("Elements not found");
        }
        else
        {
 System.out.println("LCA of "+a.data+" and "+b.data+" = "+LCAUtil(a, b, root).data);
        }
    }
    
    
    public Node LCAUtil(Node a, Node b,Node r)
    {
        Node left=null,right=null;
        
        if(r==null)
        {
            //System.out.println("null");
            return r;
        }     
        

   if(r.data==a.data|| r.data==b.data)
   {
       return r;
   }
        left=LCAUtil(a, b, r.prev);
        right=LCAUtil(a, b, r.next);
        
        if(left==null && right==null)
        {
            return left;
        }   
        else if(left!=null && right!=null)  // Condition 2: when a and b are on differnt side then  root is parent
        {
            return r;
        }
        else 
            return left!=null?left:right; // Condition 1: when a and b are on same side then  either a or b is paent
        
    }
    
    int sum=0;
    public void pathsRootToLeafs(Node rt,String n)
    {
        if(rt==null)
        {
            System.out.println("NULL");
            return;
        }

        
        if(rt.prev==null && rt.next==null)
        {
            System.out.println(n);
            sum+=Integer.parseInt(n);
            
        }
        else if(rt.prev!=null && rt.next==null)
        {
            //n=n+rt.prev.data;
            pathsRootToLeafs(rt.prev,n+rt.prev.data);
        }
        else if(rt.prev==null && rt.next!=null)
        {
            //n=n+rt.next.data;
            pathsRootToLeafs(rt.next,n+rt.next.data);
        }
        else if(rt.prev!=null && rt.next!=null)
        {
            pathsRootToLeafs(rt.prev,n+rt.prev.data);
            pathsRootToLeafs(rt.next,n+rt.next.data);
        }
        
    }
    
    public void height()
    {
        Node rt=root;
        System.out.println("Height = "+heightUtil(rt));
    }
    
    public int heightUtil(Node rt)
    {
        if(rt==null)
            return 0;
        
        return Math.max(heightUtil(rt.prev),heightUtil(rt.next))+1;
    }
    
}



class Node
{
    int data;
    Node prev;
    Node next;
}

